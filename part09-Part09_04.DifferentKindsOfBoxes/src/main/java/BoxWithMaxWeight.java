
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class BoxWithMaxWeight extends Box {
    
    private int capacity;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (totalWeight() + item.getWeight() <= capacity) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
    
    private int totalWeight() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        
        return totalWeight;
    }
}
