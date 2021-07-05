
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matt
 */
public class Herd implements Movable {
    
    private List<Movable> herd;
    
    public Herd() {
        herd = new ArrayList<>();
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : herd) {
            movable.move(dx, dy);
        }
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    @Override
    public String toString() {
        String herdPositions = "";
        
        for (Movable movable : herd) {
            herdPositions += movable.toString() + "\n";
        }
        
        return herdPositions;
    }
}
