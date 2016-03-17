/*
 * Copyright (c) 2016.
 */

package space;

import java.util.List;

/**
 * Created by Valko Serhii on 15.03.2016.
 */
interface SpaceObject
{
    String getName();

    double getWeight();

    double getRadius();

    List<SolarSystem> getTails();

    SolarSystem getHead();

    SpaceObjectType getType();





}
