/*
 * Copyright (c) 2016.
 */

package gof.creation.factoryMethod;

import gof.creation.prototype.*;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */
public class PrototypeImplementationFactory
{
    public static AbstractPrototype getPrototypeImpl (Class<? extends AbstractPrototype> clazz) {

        if (clazz == Prototype_v1.class) return new Prototype_v1();
        else if (clazz == Prototype_v2.class) return new Prototype_v2();
        else throw new IllegalArgumentException();
    }
}
