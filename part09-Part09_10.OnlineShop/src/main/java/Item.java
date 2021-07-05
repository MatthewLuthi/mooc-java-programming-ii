
import java.util.Objects;

/**
 *Items can be added to the shopping cart. An item is a product with a quantity.
 * Example, add an item representing one bread to the cart or an item representing 24 coffees
 * @author Matt
 */
public class Item {
    
    private String product;
    private int qty, unitPrice;
    
    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    

    public int price() {
        return qty * unitPrice;
    }
    
    public void increaseQuantity() {
        qty++;
    }
    
    @Override
    public String toString() {
        return product + ": " + qty;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.product);
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
        
        if (product.equals(comparedItem.product)) {
            return true;
        }
        
        return false;
    }
}
