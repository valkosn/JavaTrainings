/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1.factory;

import gof.creation.abstractFactory.abstractFactory_v1.items.Button;
import gof.creation.abstractFactory.abstractFactory_v1.items.CheckBox;
import gof.creation.abstractFactory.abstractFactory_v1.items.Window;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */
public interface AbstractFactory_v1
{
    Window createWindow();
    Button createButton();
    CheckBox createCheckBox();
}
