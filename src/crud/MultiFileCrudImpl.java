package crud;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/**
 * @author Orest Lozynskyy
 * @since 28-Mar-16
 */
public class MultiFileCrudImpl implements Crud {
  private static final String INDEX_DB = "index.db";
  private Path baseDir;
  private FileChannel indexFileChannel;
  private static String maxId = "maxId: ";

  private static Integer id = null;

  public MultiFileCrudImpl(String baseDir) {
    try {
      Path path = Paths.get(baseDir);
      if (!Files.exists(path) || !Files.isDirectory(path)) {
        this.baseDir = Files.createDirectories(path);
      } else {
        this.baseDir = path;
      }

      path = Paths.get(baseDir + "/" + INDEX_DB);
      Path indexDb;
      if (!Files.exists(path)) {
        indexDb = Files.createFile(path);
      } else {
        indexDb = path;
      }

      indexFileChannel = FileChannel.open(indexDb, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.DSYNC);

      String line = findMaxId();

      if (line != null && !line.isEmpty()) {
        id = Integer.valueOf(line.substring(maxId.length()).trim());
      } else {
        id = null;
      }

      if (id == null) {
        id = 0;
        write((maxId + id));
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public Row find(String id) {
    Path path = Paths.get(baseDir + "/" + id);
    if (!Files.exists(path)) {
      return null;
    }
    try (BufferedReader fileReader = new BufferedReader(new FileReader(path.toFile()))) {
      return new Row(fileReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(Row row) {
    Path path = Paths.get(baseDir + "/" + row.getId());
    if (!Files.exists(path)) {
      throw new RuntimeException("Can't find file for update");
    }
    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
      fileWriter.write(row.toString());
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(String id) {
    Path path = Paths.get(baseDir + "/" + id);
    if (!Files.exists(path)) {
      throw new RuntimeException("Can't find file for delete");
    }
    try {
      Files.delete(path);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public Row save(Row row) {
    if (row.getId() == null || row.getId().isEmpty()) {
      row.setId(getNextId().toString());
    }
    Path path = Paths.get(baseDir + "/" + row.getId());
    if (Files.exists(path)) {
      throw new RuntimeException("File already exists");
    }
    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
      fileWriter.write(row.toString());
      return row;
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private Integer getNextId() {
    if (id != null) {
      findMaxId();
      write(maxId + ++id);
    }
    return id;
  }

  private String findMaxId() {
    String line;
    ByteBuffer buffer = ByteBuffer.allocate(100);
    try {
      while (indexFileChannel.read(buffer) >= 0 && buffer.position() != 0) {
        buffer.flip();
        line = readLine(buffer);
        if (line.contains(maxId)) {
          return line;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return "";
  }

  private void write(String line) {
    ByteBuffer buffer = ByteBuffer.allocate(100);
    buffer.put(line.getBytes(), 0, line.length());
    buffer.flip();
    try {
      indexFileChannel.write(buffer, 0);
      buffer.flip();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private String readLine(ByteBuffer buffer) {
    StringBuilder builder = new StringBuilder(50);
    while (buffer.hasRemaining()) {
      builder.append((char) buffer.get());
    }
    buffer.flip();
    return builder.toString();
  }

  public static void main(String[] args) throws IOException {
    String pathToDir = "C:\\mytemp\\output\\db";
    MultiFileCrudImpl crud = new MultiFileCrudImpl(pathToDir);

    //Create
    int n = 1_000;
    Row row = null;
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      row = crud.save(new Row("Шорты пляжные синие", "159.00", "12"));
    }
    System.out.println("save n: " + n + " lasts: " + (System.currentTimeMillis() - start) + " ms");
    Row testRow = new Row("" + n, "Шорты пляжные синие", "159.00", "12");
    if (!testRow.equals(row)) throw new AssertionError("save failed");

    //Read
    Random random = new Random();
    String id;
    start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      id = (random.nextInt(n) + 1) + "";
      row = crud.find(id);
      if (row == null) throw new AssertionError("find failed for id: " + id);
    }
    System.out.println("find n: " + n + " lasts: " + (System.currentTimeMillis() - start) + " ms");
    row = crud.find(testRow.getId());
    if (!testRow.equals(row)) throw new AssertionError("find failed");

    //update
    row.setProductName("Orest");
    testRow.setProductName("Orest");
    row.setPrice("159856");
    testRow.setPrice("159856");
    crud.update(row);
    row = crud.find(row.getId());
    if (!row.equals(testRow)) throw new AssertionError("update failed");

    //Delete
    start = System.currentTimeMillis();
    for (int i = 1; i <= n; i++) {
      crud.delete("" + i);
    }
    System.out.println("delete n: " + n + " lasts: " + (System.currentTimeMillis() - start) + " ms");

    row = crud.find(row.getId());
    if (row != null) throw new AssertionError("update failed");

    try {} finally {
      Path path = Paths.get(pathToDir + "\\index.db");
      Files.deleteIfExists(path);
    }
  }
}
