
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class Pipe<T> {
    
    private ArrayList<T> values;
    
    public Pipe() {
        values = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        values.add(value);
    }
    
    public T takeFromPipe() {
        if (!isInPipe()) {
            return null;
        }
        
        T oldestValue = values.get(0);
        values.remove(oldestValue);
        return oldestValue;
    }
    
    public boolean isInPipe() {
        return !values.isEmpty();
    }
}
