
public class Main {

    public static void main(String[] args) {
        SimpleDate d = new SimpleDate(1, 5, 2098);
        SimpleDate compared = new SimpleDate(3, 1, 1900);
        
        System.out.println(d.hashCode() + "\n"
            + compared.hashCode());

    }
}
