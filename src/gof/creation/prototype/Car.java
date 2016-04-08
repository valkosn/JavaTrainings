/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import java.io.Serializable;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */
public class Car implements Serializable
{
    private String model;

    public Car(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}
