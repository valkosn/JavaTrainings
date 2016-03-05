/*
 * Copyright (c) 2016.
 */

package fibonacci.impl;

import fibonacci.AbstractFibonacci;

/**
 * Created by Valko Serhii on 05.03.2016.
 */
public class FibonacciFromAlgor extends AbstractFibonacci
{

    @Override
    public long calculate(int n)
    {
        int f = 0;
        int g = 1;

        for (int i = 0; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return g;
    }
}
