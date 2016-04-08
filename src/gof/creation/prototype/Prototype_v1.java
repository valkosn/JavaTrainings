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
public class Prototype_v1 implements Cloneable
{
    private String name;
    private int age;
    private Singleton_v6 gender;

    public Prototype_v1(String name, int age, Singleton_v6 gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Singleton_v6 getGender()
    {
        return gender;
    }

    public void setGender(Singleton_v6 gender)
    {
        this.gender = gender;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public Prototype_v1 clone(){
        try
        {
            return (Prototype_v1) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString()
    {
        return String.join(" ",name, Integer.toString(age), gender.toString());
    }
}
