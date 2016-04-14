/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.linuxItems;

import gof.creation.abstractFactory.abstractFactory_v1.items.CheckBox;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class LinuxCheckBox implements CheckBox
{
    public LinuxCheckBox()
    {
        System.out.println(this.getClass().getSimpleName() + "created");
    }
}
