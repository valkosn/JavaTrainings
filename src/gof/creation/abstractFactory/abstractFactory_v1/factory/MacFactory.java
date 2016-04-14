/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.factory;

import gof.creation.abstractFactory.abstractFactory_v1.items.Button;
import gof.creation.abstractFactory.abstractFactory_v1.items.CheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.items.Window;
import gof.creation.abstractFactory.abstractFactory_v1.macItems.MacButton;
import gof.creation.abstractFactory.abstractFactory_v1.macItems.MacCheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.macItems.MacWindow;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class MacFactory implements AbstractFactory_v1
{
    @Override
    public Window createWindow()
    {
        return new MacWindow();
    }

    @Override
    public Button createButton()
    {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox()
    {
        return new MacCheckBox();
    }
}
