/**
 *
 * @author Matt
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        history = new ChangeHistory();
        addToWarehouse(initialBalance);
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double received = super.takeFromWarehouse(amount);
        history.add(getBalance());
        return received;
    }
    
    public String history() {
        return history.toString();
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName()
            + "\nHistory: " + history() 
            + "\nLargest amount of product: " + history.maxValue() 
            + "\nSmallest amount of product: " + history.minValue() 
            + "\nAverage: " + history.average());
    }
}
