package menu;

import fibonacci.Fibonacci;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public abstract class AbstractMenu implements Menu
{

  @Override
  public abstract void build();

  protected int getN(BufferedReader reader) throws IOException
  {
    System.out.print("Enter the order of the Fibonacci numbers - ");
    return Integer.parseInt(reader.readLine());
  }

  protected String getMenuPrompt(List<String> options)
  {
    StringBuilder sb = new StringBuilder("Availiable impementations:\n");
    int i = 1;
    for (String option : options)
    {
      sb.append(option).append(" - ").append(i++).append("\n");
    }
    sb.append("EXIT - 0");
    return sb.toString();
  }

  protected List<Class<? extends Fibonacci>> getAvailableImplementations(Class<? extends Fibonacci> fibImpl)
  {
    List<Class<? extends Fibonacci>> result = new LinkedList<>();
    try
    {
      List<Class<?>> list = getAllClassesFromPackage(fibImpl.getPackage());

      for (Class<?> clazz : list)
      {
        if (fibImpl.isAssignableFrom(clazz))
        {
          result.add((Class<? extends Fibonacci>) clazz);
        }
      }
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException("Exception", e);
    }
    return result;
  }

  private static List<Class<?>> getAllClassesFromPackage(Package packageForScan) throws IOException, ClassNotFoundException
  {
    ArrayList<Class<?>> list = new ArrayList<>();
    Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageForScan.getName() + "/impl");
    while (urls.hasMoreElements())
    {
      URL url = urls.nextElement();
      File dir = new File(url.getFile());
      for (File f : dir.listFiles())
      {
        String name = packageForScan.getName() + ".impl." + f.getName().replace(".class", "");
        list.add(Class.forName(name));
      }
    }
    return list;
  }
}
