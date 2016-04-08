/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import gof.creation.singleton.Singleton_v6;

import java.io.*;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */
public class Prototype_v2 implements Serializable
{
    private String name;
    private int age;
    private Singleton_v6 gender;
    private Car car;

    public Prototype_v2(String name, int age, Singleton_v6 gender)
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

    public Prototype_v2 getCopy(){

        Prototype_v2 copy = null;
        try
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(this);
            outputStream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            copy = (Prototype_v2) objectInputStream.readObject();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return copy;
    }

    @Override
    public String toString()
    {
        return String.join(" ",name, Integer.toString(age), gender.toString(), car.toString());
    }
}
