/*
 * Copyright (c) 2016.
 */

package space;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valko Serhii on 15.03.2016.
 */
public class TestSolarSystem extends AbstractSpaceObject
{
    List<SpaceObject> spaceObjects = new ArrayList<>();

    static {

    }

    TestSolarSystem(String name, int weight, int radius, List<SolarSystem> tails)
    {
        super(name, weight, radius, tails);
    }

    private void build(){

        try
        {
            BufferedReader fileReader = new BufferedReader(new FileReader("SolarSystemDB.txt"));
            while (fileReader.ready()){
                String currLine = fileReader.readLine();
                String[] spaceObjectParams = currLine.split("#");
                String type = spaceObjectParams[0];
                String name = spaceObjectParams[1];
                int weight = Integer.parseInt(spaceObjectParams[2]);
                int radius = Integer.parseInt(spaceObjectParams[3]);
                String head = spaceObjectParams[4];
                



            }
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
