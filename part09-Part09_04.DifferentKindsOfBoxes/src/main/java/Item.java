
import java.util.Objects;


public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object comparedObj) {
        if (this == comparedObj) {
            return true;
        }
        
        if (!(comparedObj instanceof Item)) {
            return false;
        }
        
        Item comparedItem = (Item) comparedObj;
        
        if (this.getName().equals(comparedItem.getName())) {
            return true;
        }
        
        return false;
    }
}
