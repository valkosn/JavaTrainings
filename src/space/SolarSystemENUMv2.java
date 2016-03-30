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
    MOON("Moon", 7.342e22, 1737.1),
    DEIMOS("Deimos", 1.4762e15, 6.2),
    PHOBOS("Phobos", 1.0659e16, 11.2667),
    GANYMEDE("Ganymede", 1.4819e23, 2634.1),
    CALLISTO("Callisto", 1.075938e23, 2410.3),
    IO("Io", 8.931938e22, 1821.6),
    EUROPA("Europa", 4.799844e22, 1560.8),
    TITAN("Titan", 1.3452e23, 2575.5),
    ENCELADUS("Enceladus", 1.08022e20, 252.1),
    TITANIA("Titania", 3.527e21, 788.4),
    OBERON("Oberon", 3.014e21, 761.4),
    UMBRIEL("Umbriel", 1.172e21, 584.7),
    ARIEL("Ariel", 1.353e21, 578.9),
    MIRANDA("Miranda", 6.59e19, 235.8),
    TRITON("Triton", 2.14e22, 1353.4),

    //Planets
    MERCURY("Mercury", 3.3011e23, 2439.7),
    VENUS("Venus", 4.8675e24, 6051.8),
    EARTH("Earth", 5.97237e24, 6371.0, MOON),
    MARS("Mars", 6.4171e23, 3389.5, DEIMOS, PHOBOS),
    JUPITER("Jupiter", 1.8986e27, 69911, GANYMEDE, CALLISTO, IO, EUROPA),
    SATURN("Saturn", 5.6836e26, 58232, TITAN, ENCELADUS),
    URANUS("Uranus", 8.6810e25, 25362, TITANIA, OBERON, UMBRIEL,ARIEL, MIRANDA),
    NEPTUNE("Neptune", 1.0243e26, 24622, TRITON),

    //Suns
    SUN("Sun", 1.98855e30, 695700, MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE);



    private String name;
    private double weight;
    private double radius;
    private SpaceObject head;
    private List<SpaceObject> tails;

    SolarSystemENUMv2(String name, double weight, double radius, SpaceObject ... tails)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        List<SpaceObject> list = new ArrayList<>();
        for (SpaceObject tail : tails)
        {
            list.add(tail);
            tail.setHead(this);
        }
        this.tails = list;
    }

    SolarSystemENUMv2(String name, double weight, double radius)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
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
        return this.head;
    }

    public List<SpaceObject> getTails()
    {
        return this.tails;
    }

    public SpaceObjectType getType()
    {
        return null;
    }



    public void setHead(SpaceObject head) {
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
