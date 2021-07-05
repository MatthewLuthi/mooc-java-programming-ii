

public class Main {

    public static void main(String[] args) {
        // Use this main program for testing your classes!
        Item iphone = new Item("iPhone", 1);
        Item ipod = new Item("iPod", 1);
        
        Suitcase suitcase = new Suitcase(5);
        suitcase.addItem(iphone);
        suitcase.addItem(ipod);
        
        Hold hold = new Hold(10);
        hold.addSuitcase(suitcase);
        
        hold.printItems();
    }

}
