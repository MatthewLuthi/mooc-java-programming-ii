

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        
        String regex = "17:23:05";
        
        Checker check = new Checker();
        
        if (check.timeOfDay(regex)) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }
    }
}
