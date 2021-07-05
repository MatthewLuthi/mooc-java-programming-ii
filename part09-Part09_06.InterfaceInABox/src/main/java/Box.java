
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class Box implements Packable {

    private double maxCapacity;
    private ArrayList<Packable> items;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        items = new ArrayList<>();
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            weight += item.weight();
        }

        return weight;
    }

    public void add(Packable item) {
        if (item.weight() + weight() <= maxCapacity) {
            items.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
    
    
}
