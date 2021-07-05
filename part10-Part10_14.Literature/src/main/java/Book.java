/**
 *
 * @author Matt
 */
public class Book implements Comparable<Book> {
    private String name;
    private int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }

    public String getName() {
        return name;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + ageRecommendation + " year-olds or older)";
    }

    @Override
    public int compareTo(Book comparedBook) {
        if (this.ageRecommendation == comparedBook.ageRecommendation) {
            return this.name.compareTo(comparedBook.name);
        }
        
        return this.ageRecommendation - comparedBook.ageRecommendation;
    }
    
    
}
