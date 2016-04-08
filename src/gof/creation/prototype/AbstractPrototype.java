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

    public AbstractPrototype(String name, int age, Singleton_v6 gender)
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

    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
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
