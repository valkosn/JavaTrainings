/*
 * Copyright (c) 2016.
 */

package space;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valko Serhii on 17.03.2016.
 */
public abstract class SpaceObjectImpl extends AbstractSpaceObject implements SpaceObject
{

    public SpaceObjectImpl(String name, double weight, double radius, SpaceObject head, SpaceObjectType type)
    {
        super(name, weight, radius, head, type);
    }

    public SpaceObjectImpl(String name, double weight, double radius, SpaceObjectType type)
    {
        super(name, weight, radius, type);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public double getWeight()
    {
        return weight;
    }

    @Override
    public double getRadius()
    {
        return radius;
    }

    @Override
    public List<SpaceObject> getTails()
    {
        List<SpaceObject> satellitesList = new ArrayList<>();
        for (SpaceObject spaceObject : spaceObjectsList)
        {
            if (this.equals(spaceObject.getHead())) satellitesList.add(spaceObject);
        }

        return satellitesList;
    }

    @Override
    public SpaceObject getHead()
    {
        return this.head;
    }

    @Override
    public SpaceObjectType getType()
    {
        return this.type;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
}
