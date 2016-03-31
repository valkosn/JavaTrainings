package crud;

/**
 * @author Orest Lozynskyy
 * @since 28-Mar-16
 */
public interface Crud {
  Row find(String id);
  void update(Row row);
  void delete(String id);
  Row save(Row row);
}
