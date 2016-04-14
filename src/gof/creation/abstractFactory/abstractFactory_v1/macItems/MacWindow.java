/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.macItems;

import gof.creation.abstractFactory.abstractFactory_v1.items.Window;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class MacWindow implements Window
{
    public MacWindow()
    {
        System.out.println(this.getClass().getSimpleName() + "created");
    }
}
