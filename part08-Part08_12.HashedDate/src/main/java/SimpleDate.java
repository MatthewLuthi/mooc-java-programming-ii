
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }
    
    @Override
    public boolean equals(Object comparedObj) {
        // If the variables are located in the same place, they're the same.
        if (this == comparedObj) {
            return true;
        }
        
        // If comparedObject is not of type SimpleDate, the objects aren't the same.
        if (!(comparedObj instanceof SimpleDate)) {
            return false;
        }
        
        // Let's convert the object to a SimpleDate object.
        SimpleDate comparedDate = (SimpleDate) comparedObj;
        
        
        // If the instance variables of the objects are the same, so are the objects.
        if (year == comparedDate.year
                && month == comparedDate.month
                && day == comparedDate.day) {
            return true;
        }
        
        // Otherwise objects aren't the same.
        return false;
    }
}
