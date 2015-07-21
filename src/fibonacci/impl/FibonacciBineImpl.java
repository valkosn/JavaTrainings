package fibonacci.impl;

import fibonacci.AbstractFibonacci;

/**
 * @author OrestO
 * @since 7/21/2015
 */
public class FibonacciBineImpl extends AbstractFibonacci
{
  @Override
  //TODO: figure out what is wrong when n > 100
  public long calculate(int n)
  {
    long result = Math.round(Math.pow(((1 + Math.sqrt(5)) / 2), Math.abs(n)) / Math.sqrt(5));
    return n >= 0 ? result : -result;
  }
}
