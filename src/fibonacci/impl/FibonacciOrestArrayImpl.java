package fibonacci.impl;

import fibonacci.AbstractFibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class FibonacciOrestArrayImpl extends AbstractFibonacci
{
  @Override
  public long calculate(int n)
  {
    int absN = Math.abs(n);
    for (; maxGenerated <= absN; maxGenerated++)
    {
      result[maxGenerated] = result[maxGenerated - 1] + result[maxGenerated - 2];
    }
    return n > 1 ? result[absN] : -result[absN];
  }
}
