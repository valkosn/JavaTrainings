/*
 * Copyright (c) 2016.
 */

package gof.creation.singleton;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

/**
 * No lazy initialization;
 * Thread-safe;
 * Can't be inherited, because ENUMs implicitly extend Enum.class */
public enum Singleton_v6
{
    MALE, FEMALE;

}
