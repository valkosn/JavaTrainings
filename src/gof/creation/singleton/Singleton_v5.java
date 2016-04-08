/*
 * Copyright (c) 2016.
 */

package gof.creation.singleton;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * Double - Checked Locking
 * Lazy initialization;
 * Thread-safe;
 * My be some problem with access to static field "instance", its may be fixed if use "volatile" modifier;
 * Using "volatile" modifier can lose performance at multiprocessor system;
 */
public final class Singleton_v5
{
    private static Singleton_v5 instance;

    private Singleton_v5()
    {

    }

    public static Singleton_v5 getInstance()
    {
        if (instance == null)
            synchronized (Singleton_v5.class)
            {
                if (instance == null)
                    instance = new Singleton_v5();
            }
        return instance;
    }
}
