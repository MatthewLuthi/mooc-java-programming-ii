
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Matt
 */
public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<>();
    }
    
    public void sort() {
        Collections.sort(hand);
    }
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void print() {
        hand.stream().forEach(card -> System.out.println(card));
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    private int sumOfValues() {
        return hand.stream().mapToInt(card -> card.getValue()).sum();
    }

    @Override
    public int compareTo(Hand other) {    
        return this.sumOfValues() - other.sumOfValues();
    }
    
    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
}
