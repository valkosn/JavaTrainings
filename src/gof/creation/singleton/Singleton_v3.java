/*
 * Copyright (c) 2016.
 */

package gof.creation.singleton;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * Initialization on Demand Holder;
 * Lazy initialization;
 * Thread-safe;
 * */

public final class Singleton_v3
{
    private Singleton_v3(){

    }

    private static class Singleton_v3Holder{
        private final static Singleton_v3 instance = new Singleton_v3();
    }

    public static Singleton_v3 getInstance(){
        return Singleton_v3Holder.instance;
    }


}
