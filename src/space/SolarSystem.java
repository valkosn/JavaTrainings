/*
 * Copyright (c) 2016.
 */

package space;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valko Serhii on 15.03.2016.
 */
public enum SolarSystem implements SpaceObject
{
    NO_SATELLITES,
    //Satellites
    MOON("Moon", 7.342e22, 1737.1, "Earth", "Satellite"),
    DEIMOS("Deimos", 1.4762e15, 6.2, "Mars", "Satellite"),
    PHOBOS("Phobos", 1.0659e16, 11.2667, "Mars", "Satellite"),
    GANYMEDE("Ganymede", 1.4819e23, 2634.1, "Jupiter", "Satellite"),
    CALLISTO("Callisto", 1.075938e23, 2410.3, "Jupiter", "Satellite"),
    IO("Io", 8.931938e22, 1821.6, "Jupiter", "Satellite"),
    EUROPA("Europa", 4.799844e22, 1560.8, "Jupiter", "Satellite"),
    TITAN("Titan", 1.3452e23, 2575.5, "Saturn", "Satellite"),
    ENCELADUS("Enceladus", 1.08022e20, 252.1, "Saturn", "Satellite"),
    TITANIA("Titania", 3.527e21, 788.4, "Uranus", "Satellite"),
    OBERON("Oberon", 3.014e21, 761.4, "Uranus", "Satellite"),
    UMBRIEL("Umbriel", 1.172e21, 584.7, "Uranus", "Satellite"),
    ARIEL("Ariel", 1.353e21, 578.9, "Uranus", "Satellite"),
    MIRANDA("Miranda", 6.59e19, 235.8, "Uranus", "Satellite"),
    TRITON("Triton", 2.14e22, 1353.4, "Neptune", "Satellite"),

    //Planets
    MERCURY("Mercury", 3.3011e23, 2439.7, "Sun", "Planet"),
    VENUS("Venus", 4.8675e24, 6051.8, "Sun", "Planet"),
    EARTH("Earth", 5.97237e24, 6371.0, "Sun", "Planet"),
    MARS("Mars", 6.4171e23, 3389.5, "Sun", "Planet"),
    JUPITER("Jupiter", 1.8986e27, 69911, "Sun", "Planet"),
    SATURN("Saturn", 5.6836e26, 58232, "Sun", "Planet"),
    URANUS("Uranus", 8.6810e25, 25362, "Sun", "Planet"),
    NEPTUNE("Neptune", 1.0243e26, 24622, "Sun", "Planet"),

    //Suns
    SUN("Sun", 1.98855e30, 695700, "Sun");

    private String name;
    private double weight;
    private double radius;
    private String head;
    private String type;

    SolarSystem()
    {

    }

    SolarSystem(String name, double weight, double radius, String head, String type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.head = head;
        this.type = type;
    }

    SolarSystem(String name, double weight, double radius, String type)
    {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
        this.type = type;
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
    public List<SolarSystem> getTails()
    {
        List<SolarSystem> satellitesList = new ArrayList<>();
        for (SolarSystem ss : SolarSystem.values())
        {
            if (this.getName().equals(ss.head)) satellitesList.add(ss);
        }
        if (satellitesList.size() == 0) satellitesList.add(NO_SATELLITES);
        return satellitesList;
    }

    @Override
    public SolarSystem getHead()
    {
        for (SolarSystem ss : SolarSystem.values())
        {
            if (this.head.equals(ss.getName())) return ss;
        }
        return null;
    }

    @Override
    public SpaceObjectType getType()
    {
        switch (this.type){
            default: throw new IllegalArgumentException();
            case "Satellite" : return SpaceObjectType.SATELLITE;
            case "Planet" : return SpaceObjectType.PLANET;
            case "Sun" : return SpaceObjectType.SUN;
        }
    }


}
