/*
 * Copyright (c) 2016.
 */

package space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Valko Serhii on 17.03.2016.
 */
public enum SolarSystemENUMv2 implements SpaceObject
{

    //Satellites
    MOON("Moon", 7.342e22, 1737.1, SpaceObjectType.SATELLITE),
    DEIMOS("Deimos", 1.4762e15, 6.2, SpaceObjectType.SATELLITE),
    PHOBOS("Phobos", 1.0659e16, 11.2667, SpaceObjectType.SATELLITE),
    GANYMEDE("Ganymede", 1.4819e23, 2634.1, SpaceObjectType.SATELLITE),
    CALLISTO("Callisto", 1.075938e23, 2410.3, SpaceObjectType.SATELLITE),
    IO("Io", 8.931938e22, 1821.6, SpaceObjectType.SATELLITE),
    EUROPA("Europa", 4.799844e22, 1560.8, SpaceObjectType.SATELLITE),
    TITAN("Titan", 1.3452e23, 2575.5, SpaceObjectType.SATELLITE),
    ENCELADUS("Enceladus", 1.08022e20, 252.1, SpaceObjectType.SATELLITE),
    TITANIA("Titania", 3.527e21, 788.4, SpaceObjectType.SATELLITE),
    OBERON("Oberon", 3.014e21, 761.4, SpaceObjectType.SATELLITE),
    UMBRIEL("Umbriel", 1.172e21, 584.7, SpaceObjectType.SATELLITE),
    ARIEL("Ariel", 1.353e21, 578.9, SpaceObjectType.SATELLITE),
    MIRANDA("Miranda", 6.59e19, 235.8, SpaceObjectType.SATELLITE),
    TRITON("Triton", 2.14e22, 1353.4, SpaceObjectType.SATELLITE),

    //Planets
    MERCURY("Mercury", 3.3011e23, 2439.7, SpaceObjectType.PLANET),
    VENUS("Venus", 4.8675e24, 6051.8, SpaceObjectType.PLANET),
    EARTH("Earth", 5.97237e24, 6371.0, Arrays.asList(MOON), SpaceObjectType.PLANET),
    MARS("Mars", 6.4171e23, 3389.5, Arrays.asList(DEIMOS, PHOBOS), SpaceObjectType.PLANET),
    JUPITER("Jupiter", 1.8986e27, 69911, Arrays.asList(GANYMEDE, CALLISTO, IO, EUROPA), SpaceObjectType.PLANET),
    SATURN("Saturn", 5.6836e26, 58232, Arrays.asList(TITAN, ENCELADUS), SpaceObjectType.PLANET),
    URANUS("Uranus", 8.6810e25, 25362, Arrays.asList(TITANIA, OBERON, UMBRIEL,ARIEL, MIRANDA), SpaceObjectType.PLANET),
    NEPTUNE("Neptune", 1.0243e26, 24622, Arrays.asList(TRITON), SpaceObjectType.PLANET),

    //Suns
    SUN("Sun", 1.98855e30, 695700, Arrays.asList(MERCURY, VENUS, EARTH, MARS, JUPITER,
                                                SATURN, URANUS, NEPTUNE),SpaceObjectType.SUN);



    private String name;
    private double weight;
    private double radius;
    private SpaceObject head;
    private List<SpaceObject> tails;
    private SpaceObjectType type;

    SolarSystemENUMv2()
    {

    }

    SolarSystemENUMv2(String name, double weight, double radius, List<SpaceObject> tails, SpaceObjectType type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.tails = tails;
        this.type = type;
    }

    SolarSystemENUMv2(String name, double weight, double radius, SpaceObjectType type)
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

    public SpaceObject getHead(){
        if(this.head == null && !this.getType().equals(SpaceObjectType.SUN)) initializeHeads();
        return this.head;
    }

    public List<SpaceObject> getTails()
    {
        return this.tails;
    }

    public SpaceObjectType getType()
    {
        return this.type;
    }

    public void initializeHeads (){
        for (SolarSystemENUMv2 spaceObject : SolarSystemENUMv2.values()) {
            spaceObject.setHead(spaceObject.innerGetHead());
        }
    }

    private void setHead (SpaceObject head) {
        this.head = head;
    }

    private SpaceObject innerGetHead()
    {
        for (SpaceObject spaceObject : SolarSystemENUMv2.values())
        {
            if(spaceObject.getTails() != null)
            {
                for (SpaceObject tails : spaceObject.getTails())
                {
                    if (this.getName().equals(tails.getName())) return spaceObject;
                }
            }
        }
        return null;
    }
}
