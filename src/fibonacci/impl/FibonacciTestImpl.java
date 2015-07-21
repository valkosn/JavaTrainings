package fibonacci.impl;

import java.util.ArrayList;

import fibonacci.AbstractFibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class FibonacciTestImpl extends AbstractFibonacci
{
  @Override
  public long calculate(int n)
  {
    if (decision(n))
    {
      return n;
    }
    ArrayList<Long> result = new ArrayList<>();
    result.add(0L);
    result.add(1L);
    for (int i = 2; i <= Math.abs(n); i++)
    {
      result.add(result.get(i - 1) + result.get(i - 2));
    }

    return n > 1 ? result.get(Math.abs(n)) : -result.get(Math.abs(n));
  }
}
