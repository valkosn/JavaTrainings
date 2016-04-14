/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.factory;

import gof.creation.abstractFactory.abstractFactory_v1.items.Button;
import gof.creation.abstractFactory.abstractFactory_v1.items.CheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.items.Window;
import gof.creation.abstractFactory.abstractFactory_v1.winItems.WinButton;
import gof.creation.abstractFactory.abstractFactory_v1.winItems.WinCheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.winItems.WinWindow;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class WinFactory implements AbstractFactory_v1
{
    @Override
    public Window createWindow()
    {
        return new WinWindow();
    }

    @Override
    public Button createButton()
    {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox()
    {
        return new WinCheckBox();
    }
}
