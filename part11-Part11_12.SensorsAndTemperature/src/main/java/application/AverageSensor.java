package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matt
 */
public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        sensors = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }
    
    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (s.isOn()) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void setOn() {
        for (Sensor s : sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s : sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if (!isOn()) {
            throw new IllegalStateException();
        }
        
        int reading = (int) sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();
        readings.add(reading);
        return reading;
    } 
    
    public List<Integer> readings() {
        return readings;
    }
}
