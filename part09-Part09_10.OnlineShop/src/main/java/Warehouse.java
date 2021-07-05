
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Matt
 */
public class Warehouse {

    private Map<String, Integer> prices, quantities;

    public Warehouse() {
        prices = new HashMap<>();
        quantities = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        quantities.put(product, stock);
    }

    public int price(String product) {
        return prices.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return quantities.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (quantities.containsKey(product) 
                && quantities.get(product) > 0) {
            int quantity = quantities.get(product) - 1;
            quantities.put(product, quantity);
            return true;
        }
        
        return false;
    }
    
    public Set<String> products() {
        return quantities.keySet();
    }
}
