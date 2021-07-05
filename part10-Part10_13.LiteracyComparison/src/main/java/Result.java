
/**
 *
 * @author Matt
 */
public class Result {

    private String gender, country;
    private int year;
    private double literacyPercent;

    public Result(String gender, String country, int year, double literacyPercent) {
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }

    @Override
    public String toString() {
        return country + " (" + year + "), " + gender + ", " + literacyPercent;
    }

}
