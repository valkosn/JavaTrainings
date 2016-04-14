/*
 * Copyright (c) 2016.
 */

package gof.creation.abstractFactory.abstractFactory_v1;

import gof.creation.abstractFactory.abstractFactory_v1.factory.AbstractFactory_v1;

/**
 * Created by Valko Serhii on 13-Apr-16.
 */
public class test
{
    private static String osType = "gof.creation.abstractFactory.abstractFactory_v1.factory.WinFactory";
    public static void main(String[] args)throws Exception
    {
        AbstractFactory_v1 factory = (AbstractFactory_v1) Class.forName(osType).newInstance();
        factory.createCheckBox();
        factory.createCheckBox();
    }
}
