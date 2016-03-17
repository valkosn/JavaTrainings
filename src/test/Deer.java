/*
 * Copyright (c) 2016.
 */

package test;

/**
 * Created by Valko Serhii on 16.03.2016.
 */
public class Deer
{

        public Deer() {
            System.out.print("Deer");
        }

        public Deer(int age) {
            System.out.print("DeerAge");
        }

        private boolean hasHorns() {
            return false;
        }

        public static boolean meth()
        {
            return true;
        }

        public static void main(String[] args) {
            Deer deer = new Reindeer(5);
            System.out.println("," + deer.hasHorns());

        }
}
