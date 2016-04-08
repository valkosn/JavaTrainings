/*
 * Copyright (c) 2016.
 */

package gof.creation.singleton;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * Lazy initialization;
 * Thread - safe;
 * "synchronization" will working once, at first call method getInstance();
 * */

public final class Singleton_v4
{
    private static Singleton_v4 instance;

    private Singleton_v4()
    {

    }

    public static synchronized Singleton_v4 getInstance()
    {
        return instance != null ? instance : (instance = new Singleton_v4());
    }
}
