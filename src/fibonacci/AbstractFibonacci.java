package fibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public abstract class AbstractFibonacci implements Fibonacci
{
  protected static long[] result = new long[500];
  protected static int maxGenerated = 2;
  static
  {
    result[0] = 0L;
    result[1] = 1L;
  }

  private String name;

  @Override
  public String getName()
  {
    return name;
  }

  protected static boolean decision(int n)
  {
    switch (n) {
      case 0:
      case 1:
      case -1:
        return true;
      default:
        return false;
    }
  }

  @Override
  abstract public long calculate(int n);
}
