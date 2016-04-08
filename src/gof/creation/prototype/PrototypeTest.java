/*
 * Copyright (c) 2016.
 */

package gof.creation.prototype;

import gof.creation.factoryMethod.PrototypeImplementationFactory;
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
        AbstractPrototype prototype_1 = PrototypeImplementationFactory.getPrototypeImpl(clazz);
        prototype_1.setName("Orest").setAge(30).setGender(Singleton_v6.MALE).setCar(new Car("Ford"));
        System.out.println(clazz.getSimpleName() + "\n" + prototype_1.toString());

        AbstractPrototype prototype_2 = prototype_1.clone();
        prototype_2.setName("Serg");
        prototype_2.setAge(29);
        prototype_2.getCar().setModel("Opel");
        System.out.println(prototype_1.toString() + "\n" + prototype_2.toString());
    }
}
