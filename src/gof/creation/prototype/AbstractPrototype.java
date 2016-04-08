/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import gof.creation.singleton.Singleton_v6;

import java.io.Serializable;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */
public abstract class AbstractPrototype implements Serializable
{
    private String name;
    private int age;
    private Singleton_v6 gender;
    private Car car;


    public Singleton_v6 getGender()
    {
        return gender;
    }

    public AbstractPrototype setGender(Singleton_v6 gender)
    {
        this.gender = gender;
        return this;
    }

    public int getAge()
    {
        return age;
    }

    public AbstractPrototype setAge(int age)
    {
        this.age = age;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public AbstractPrototype setName(String name)
    {
        this.name = name;
        return this;
    }

    public Car getCar()
    {
        return car;
    }

    public AbstractPrototype setCar(Car car)
    {
        this.car = car;
        return this;
    }

    @Override
    public AbstractPrototype clone() throws CloneNotSupportedException
    {
        return (AbstractPrototype) super.clone();
    }

    @Override
    public String toString()
    {
        return String.join(" ", name, Integer.toString(age), gender.toString(), car.toString());
    }
}
