/*
 * Copyright (c) 2016.
 */

package gof.creation.singleton;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * No Lazy initialization;
 * Thread-safe;
 * */

public final class Singleton_v2
{
    private static Singleton_v2 instance = new Singleton_v2();

    private Singleton_v2()
    {

    }

    public static Singleton_v2 getInstance()
    {
        return instance;
    }
}
