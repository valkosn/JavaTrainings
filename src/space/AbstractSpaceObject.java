/*
 * Copyright (c) 2016.
 */

package space;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valko Serhii on 15.03.2016.
 */
abstract class AbstractSpaceObject
{

    protected static List<SpaceObject> spaceObjectsList = new ArrayList<>();
    protected String name;
    protected double weight;
    protected double radius;
    protected SpaceObject head;
    protected SpaceObjectType type;

    AbstractSpaceObject()
    {

    }

    AbstractSpaceObject(String name, double weight, double radius, SpaceObject head, SpaceObjectType type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.head = head;
        this.type = type;
    }

    AbstractSpaceObject(String name, double weight, double radius, SpaceObjectType type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.type = type;
    }


}
