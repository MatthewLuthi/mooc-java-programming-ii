
public class Main {

    public static void main(String[] args) {
        Box box = new Box(10);

//        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2));
//        box.add(new Book("Robert Martin", "Clean Code", 1));
//        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        Box box2 = new Box(5);
        box2.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box2.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box2.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));
        
        Box box3 = new Box(3);
        box3.add(new Book("JK Rowling", "Harry Potter", 1));
        box3.add(new Book("Suzanne Collins", "The hunger games", 2));
        
        box.add(box2);
        box.add(box3);

        System.out.println(box);
    }

}
