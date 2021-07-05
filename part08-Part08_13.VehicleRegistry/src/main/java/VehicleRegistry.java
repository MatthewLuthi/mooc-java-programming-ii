
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matt
 */
public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        registry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.containsKey(licensePlate)) {
            return false;
        }

        registry.put(licensePlate, owner);
        return true;

    }

    public String get(LicensePlate licensePlate) {
        return registry.getOrDefault(licensePlate, null);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (registry.containsKey(licensePlate)) {
            registry.remove(licensePlate);
            return true;
        }

        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate licensePlate : registry.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        ArrayList<String> ownersPrinted = new ArrayList<>();

        for (String owner : registry.values()) {
            if (ownersPrinted.contains(owner)) {
                continue;
            }

            ownersPrinted.add(owner);
            System.out.println(owner);
        }
    }
}
