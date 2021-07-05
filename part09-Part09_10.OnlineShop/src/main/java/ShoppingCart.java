
import java.util.HashMap;
import java.util.Map;

/**
 * Shopping cart stores products added there as item-objects.
 *
 * @author Matt
 */
public class ShoppingCart {
    
   private Map<String, Item> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void add(String product, int price) {
        items.putIfAbsent(product, new Item(product, 0, price));
        items.get(product).increaseQuantity();
    }

    public int price() {
        int price = 0;
        for (Item product : items.values()) {
            price += product.price();
        }

        return price;
    }

    public void print() {
        for (Item product : items.values()) {
            System.out.println(product);
        }
    }
}
