
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matt
 */
public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageUnits;
    
    public StorageFacility() {
        storageUnits = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        storageUnits.putIfAbsent(unit, new ArrayList<String>());
        storageUnits.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return storageUnits.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        if (!storageUnits.containsKey(storageUnit)) {
            return;
        }
        
        storageUnits.get(storageUnit).remove(item);
        
        if (storageUnits.get(storageUnit).isEmpty()) {
            storageUnits.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> unitsContainingItems = new ArrayList<>();
        
        for (String unit : storageUnits.keySet()) {
            if (storageUnits.get(unit).isEmpty()) {
                continue;
            }
            
            unitsContainingItems.add(unit);
        }
        
        return unitsContainingItems;
    }
}
