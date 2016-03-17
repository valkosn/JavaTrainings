/*
 * Copyright (c) 2016.
 */

package space;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valko Serhii on 15.03.2016.
 */
public enum SolarSystemENUMv1 implements SpaceObject
{
    NO_SATELLITES,

    //Suns
    SUN("Sun", 1.98855e30, 695700, SpaceObjectType.SUN),

    //Planets
    MERCURY("Mercury", 3.3011e23, 2439.7, SUN, SpaceObjectType.PLANET),
    VENUS("Venus", 4.8675e24, 6051.8, SUN, SpaceObjectType.PLANET),
    EARTH("Earth", 5.97237e24, 6371.0, SUN, SpaceObjectType.PLANET),
    MARS("Mars", 6.4171e23, 3389.5, SUN, SpaceObjectType.PLANET),
    JUPITER("Jupiter", 1.8986e27, 69911, SUN, SpaceObjectType.PLANET),
    SATURN("Saturn", 5.6836e26, 58232, SUN, SpaceObjectType.PLANET),
    URANUS("Uranus", 8.6810e25, 25362, SUN, SpaceObjectType.PLANET),
    NEPTUNE("Neptune", 1.0243e26, 24622, SUN, SpaceObjectType.PLANET),

    //Satellites
    MOON("Moon", 7.342e22, 1737.1, EARTH, SpaceObjectType.SATELLITE),
    DEIMOS("Deimos", 1.4762e15, 6.2, MARS, SpaceObjectType.SATELLITE),
    PHOBOS("Phobos", 1.0659e16, 11.2667, MARS, SpaceObjectType.SATELLITE),
    GANYMEDE("Ganymede", 1.4819e23, 2634.1, JUPITER, SpaceObjectType.SATELLITE),
    CALLISTO("Callisto", 1.075938e23, 2410.3, JUPITER, SpaceObjectType.SATELLITE),
    IO("Io", 8.931938e22, 1821.6, JUPITER, SpaceObjectType.SATELLITE),
    EUROPA("Europa", 4.799844e22, 1560.8, JUPITER, SpaceObjectType.SATELLITE),
    TITAN("Titan", 1.3452e23, 2575.5, SATURN, SpaceObjectType.SATELLITE),
    ENCELADUS("Enceladus", 1.08022e20, 252.1, SATURN, SpaceObjectType.SATELLITE),
    TITANIA("Titania", 3.527e21, 788.4, URANUS, SpaceObjectType.SATELLITE),
    OBERON("Oberon", 3.014e21, 761.4, URANUS, SpaceObjectType.SATELLITE),
    UMBRIEL("Umbriel", 1.172e21, 584.7, URANUS, SpaceObjectType.SATELLITE),
    ARIEL("Ariel", 1.353e21, 578.9, URANUS, SpaceObjectType.SATELLITE),
    MIRANDA("Miranda", 6.59e19, 235.8, URANUS, SpaceObjectType.SATELLITE),
    TRITON("Triton", 2.14e22, 1353.4, NEPTUNE, SpaceObjectType.SATELLITE);

    private String name;
    private double weight;
    private double radius;
    private SpaceObject head;
    private SpaceObjectType type;

    SolarSystemENUMv1()
    {

    }

    SolarSystemENUMv1(String name, double weight, double radius, SpaceObject head, SpaceObjectType type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.head = head;
        this.type = type;
    }

    SolarSystemENUMv1(String name, double weight, double radius, SpaceObjectType type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.type = type;
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

    public List<SpaceObject> getTails()
    {
        List<SpaceObject> satellitesList = new ArrayList<>();
        for (SolarSystemENUMv1 ss : SolarSystemENUMv1.values())
        {
            if (this.equals(ss.head)) satellitesList.add(ss);
        }
        if (satellitesList.size() == 0) satellitesList.add(NO_SATELLITES);

        return satellitesList;
    }

    public SpaceObject getHead()
    {
        for (SolarSystemENUMv1 ss : SolarSystemENUMv1.values())
        {
            if (this.head.equals(ss)) return ss;
        }
        return null;
    }

    public SpaceObjectType getType()
    {
        return this.type;
    }
}