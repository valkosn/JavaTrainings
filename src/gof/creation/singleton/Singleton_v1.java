/*
 * Copyright (c) 2016.
 */

package gof.creation.singleton;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * Lazy initialization;
 * No thread - safe
 * */

public final class Singleton_v1
{
    private static Singleton_v1 instance;

    private Singleton_v1()
    {

    }

    public static Singleton_v1 getInstance()
    {
        return instance != null ? instance : (instance = new Singleton_v1());
    }

}
