/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import gof.creation.singleton.Singleton_v6;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * Mark as cloneable
 */
public class Prototype_v1 extends AbstractPrototype implements Cloneable
{


    @Override
    public Prototype_v1 clone() throws CloneNotSupportedException
    {
        return (Prototype_v1) super.clone();
    }
}
