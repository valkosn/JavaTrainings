/*
 * Copyright (c) 2016.
 */

package space;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Valko Serhii on 17.03.2016.
 */
public class SolarSystemNew extends AbstractSpaceObject
{
    private static Set<String> inputSpaceObjectList = new LinkedHashSet<>();

    static
    {
        readDB();

        for (String currString : inputSpaceObjectList)
        {
            String[] spaceObjectParams = currString.split(",");
            String name = spaceObjectParams[0];
            double weight = Double.parseDouble(spaceObjectParams[1]);
            double radius = Double.parseDouble(spaceObjectParams[2]);
            String head = spaceObjectParams[3];
            String type = spaceObjectParams[4];

            switch (type)

            {
                case "Sun":
                    spaceObjectsList.add(new Sun(name, weight, radius, SpaceObjectType.SUN));
                    break;
                case "Planet":
                    spaceObjectsList.add(new Planet(name, weight, radius, getSpaceObjectByName(head), SpaceObjectType.PLANET));
                    break;
                case "Satellite":
                    spaceObjectsList.add(new Satellite(name, weight, radius, getSpaceObjectByName(head), SpaceObjectType.SATELLITE));
                    break;
                default:
                    throw new IllegalArgumentException("incorrect type");
            }
        }
    }


    private static SpaceObject getSpaceObjectByName(String name)
    {

        for (SpaceObject spaceObject : spaceObjectsList)
        {
            if (spaceObject.getName().equals(name)) return spaceObject;
        }
        throw new IllegalArgumentException("no object");
    }


    private static void readDB()
    {

        try
        {
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Work\\JavaRushHomeWork\\JavaRushHomeWork\\src\\space\\SolarSystemDB.txt"));
            while (fileReader.ready()) inputSpaceObjectList.add(fileReader.readLine());
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
