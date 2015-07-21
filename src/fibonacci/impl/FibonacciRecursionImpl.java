package fibonacci.impl;

import fibonacci.AbstractFibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class FibonacciRecursionImpl extends AbstractFibonacci
{
  @Override
  public long calculate(int n)
  {
    if (decision(n))
    {
      return n;
    }
    return n > 1 ? calculate(n - 1) + calculate(n - 2) : -(calculate(Math.abs(n) - 1) + calculate(Math.abs(n) - 2));
  }
}
