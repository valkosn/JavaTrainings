/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.winItems;

import gof.creation.abstractFactory.abstractFactory_v1.items.Button;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class WinButton implements Button
{
    public WinButton()
    {
        System.out.println(this.getClass().getSimpleName() + "created");
    }
}
