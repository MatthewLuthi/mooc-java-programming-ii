
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class ChangeHistory {
    private ArrayList<Double> states;
    
    public ChangeHistory() {
        states = new ArrayList<>();
    }
    
    public double maxValue() {
        if (states.isEmpty()) {
            return 0.0;
        }
        
        double largest = states.get(0);
        
        for (double value : states) {
            if (value > largest) {
                largest = value;
            }
        }
        
        return largest;
    }
    
    public double minValue() {
        if (states.isEmpty()) {
            return 0.0;
        }
        
        double smallest = states.get(0);
        for (double value : states) {
            if (value < smallest) {
                smallest = value;
            }
        }
        
        return smallest;
    }
    
    public double average() {
        double sum = 0;
        for (double value : states) {
            sum += value;
        }
        
        return sum / (double) states.size();
    }
    
    public void add(double status) {
        states.add(status);
    }
    
    public void clear() {
        states.clear();
    }
    
    @Override
    public String toString() {
        return states.toString();
    }
}
