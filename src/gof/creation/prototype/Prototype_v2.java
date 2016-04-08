/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import gof.creation.singleton.Singleton_v6;

import java.io.*;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */
public class Prototype_v2 extends AbstractPrototype implements Serializable
{

    @Override
    public Prototype_v2 clone()
    {
        Prototype_v2 copy = null;
        try
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(this);
            outputStream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            copy = (Prototype_v2) objectInputStream.readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return copy;
    }
}
