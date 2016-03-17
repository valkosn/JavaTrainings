/*
 * Copyright (c) 2016.
 */

package space;

import java.util.List;

/**
 * Created by Valko Serhii on 15.03.2016.
 */
abstract class AbstractSpaceObject
{
    protected String name;
    protected double weight;
    protected double radius;
    protected List<SolarSystem> tails;

    AbstractSpaceObject(String name, double weight, double radius, List<SolarSystem> tails)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.tails = tails;
    }


    public String getName()
    {
        return name;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getRadius()
    {
        return radius;
    }


    public List<SolarSystem> getTails()
    {
        return tails;
    }
}
