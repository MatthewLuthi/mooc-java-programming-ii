package application;

import java.util.Random;

/**
 *
 * @author Matt
 */
public class TemperatureSensor implements Sensor {
    
    private boolean on;
    
    public TemperatureSensor() {
        on = false;
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void setOn() {
        on = true;
    }

    @Override
    public void setOff() {
        on = false;
    }

    @Override
    public int read() {
        setOn();
        
        if (!isOn()) {
            throw new IllegalStateException();
        }

        Random r = new Random();
        return r.nextInt(61) - 30;
    }
}
