
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.liNumber);
        hash = 31 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public boolean equals(Object comparedObj) {
        if (this == comparedObj) {
            return true;
        }
        
        if (!(comparedObj instanceof LicensePlate)) {
            return false;
        }
        
        LicensePlate comparedPlate = (LicensePlate) comparedObj;
        
        if (liNumber.equals(comparedPlate.liNumber)
                && country.equals(comparedPlate.country)) {
            return true;
        }
        
        return false;
    }
    
    

}
