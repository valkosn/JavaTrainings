package gof.structure.adapter;

/**
 * Created by Valko Serhii on 31-May-16.
 */
public class Test {
    public static void main(String[] args) {
        Sensor sensor = new Adapter();
        System.out.print(sensor.getTemp());
    }
}
