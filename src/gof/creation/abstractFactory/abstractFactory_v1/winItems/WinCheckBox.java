/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.winItems;

import gof.creation.abstractFactory.abstractFactory_v1.items.CheckBox;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class WinCheckBox implements CheckBox
{
    public WinCheckBox()
    {
        System.out.println(this.getClass().getSimpleName() + "created");
    }
}
