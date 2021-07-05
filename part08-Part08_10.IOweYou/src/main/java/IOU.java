
import java.util.HashMap;

/**
 *
 * @author Matt
 */
public class IOU {
    private HashMap<String, Double> debt;
    
    public IOU() {
        debt = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        debt.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return debt.getOrDefault(toWhom, 0.0);
    }
}
