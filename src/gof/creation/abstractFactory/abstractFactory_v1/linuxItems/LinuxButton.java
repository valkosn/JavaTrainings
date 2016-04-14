/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.linuxItems;

import gof.creation.abstractFactory.abstractFactory_v1.items.Button;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class LinuxButton implements Button
{
    public LinuxButton()
    {
        System.out.println(this.getClass().getSimpleName() + "created");
    }
}
