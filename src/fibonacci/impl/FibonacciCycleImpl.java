package fibonacci.impl;

import fibonacci.AbstractFibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class FibonacciCycleImpl extends AbstractFibonacci
{
  @Override
  public long calculate(int n)
  {
    if (decision(n))
    {
      return n;
    }
    long result = 0;
    long temp0 = 0;
    long temp1 = 1;
    for (int i = 2; i <= Math.abs(n); i++)
    {
      result = temp0 + temp1;
      temp0 = temp1;
      temp1 = result;
    }

    return n > 1 ? result : -result;
  }
}
