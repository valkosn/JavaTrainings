/*
 * Copyright (c) 2016.
 */

package space;

/**
 * Created by Valko Serhii on 17.03.2016.
 */
public class Planet extends AbstractSpaceObject
{
    public Planet(String name, double weight, double radius, SpaceObject head, SpaceObjectType type)
    {
        super(name, weight, radius, head, type);
    }
}
