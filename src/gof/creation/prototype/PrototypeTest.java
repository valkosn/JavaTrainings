/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import gof.creation.singleton.Singleton_v6;

/**
 * Created by Valko Serhii on 08-Apr-16.
 */

public class PrototypeTest
{
    public static void main(String[] args) throws Exception
    {
        test(Prototype_v1.class);
        test(Prototype_v2.class);
    }

    static void test(Class<? extends AbstractPrototype> clazz) throws Exception
    {
        AbstractPrototype prototype_1;
        AbstractPrototype prototype_2;
        if (clazz == Prototype_v1.class) prototype_1 = new Prototype_v1("Orest", 30, Singleton_v6.MALE);
        else if (clazz == Prototype_v2.class) prototype_1 = new Prototype_v2("Orest", 30, Singleton_v6.MALE);
        else throw new IllegalArgumentException("Incorrect argument");

        prototype_1.setCar(new Car("Ford"));
        System.out.println(clazz.getSimpleName() + "\n" + prototype_1.toString());

        prototype_2 = prototype_1.clone();
        prototype_2.setName("Serg");
        prototype_2.setAge(29);
        prototype_2.getCar().setModel("Opel");
        System.out.println(prototype_1.toString() + "\n" + prototype_2.toString());
    }
}
