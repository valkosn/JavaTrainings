package gof.structure.adapter;

/**
 * Created by Valko Serhii on 31-May-16.
 */
public class Adapter implements Sensor {
    @Override
    public int getTemp() {
        return (new FahrenheitSensor().getTemp() - 32) * 5 / 9;
    }
}
