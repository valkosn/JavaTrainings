/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.factory;

import gof.creation.abstractFactory.abstractFactory_v1.items.Button;
import gof.creation.abstractFactory.abstractFactory_v1.items.CheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.items.Window;
import gof.creation.abstractFactory.abstractFactory_v1.linuxItems.LinuxButton;
import gof.creation.abstractFactory.abstractFactory_v1.linuxItems.LinuxCheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.linuxItems.LinuxWindow;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class LinuxFactory implements AbstractFactory_v1
{
    @Override
    public Window createWindow()
    {
        return new LinuxWindow();
    }

    @Override
    public Button createButton()
    {
        return new LinuxButton();
    }

    @Override
    public CheckBox createCheckBox()
    {
        return new LinuxCheckBox();
    }
}
