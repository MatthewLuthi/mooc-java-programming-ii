package application;

/**
 *
 * @author Matt
 */
public class Statistics {
    private Dictionary dictionary;
    private int guesses;
    private int correctGuesses;
    
    public Statistics(Dictionary dictionary) {
        this.dictionary = dictionary;
        guesses = 0;
        correctGuesses = 0;
    }
    
    public int getGuesses() {
        return guesses;
    }
    
    public int getCorrectGuesses() {
        return correctGuesses;
    }
    
    public void incrementGuesses() {
        guesses++;
    }
    
    public void incrementCorrectGuesses() {
        correctGuesses++;
    }
    
    public int getWordCount() {
        return dictionary.wordCount();
    }
}
