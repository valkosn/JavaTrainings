/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.linuxItems;

import gof.creation.abstractFactory.abstractFactory_v1.items.Window;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class LinuxWindow implements Window
{
    public LinuxWindow()
    {
        System.out.println(this.getClass().getSimpleName() + "created");
    }
}
