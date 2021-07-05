
/**
 *
 * @author Matt
 */
public class ProductWarehouse extends Warehouse {

    private String productName;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        productName = name;
    }

    @Override
    public String toString() {
        return productName + ": " + super.toString();
    }
}
