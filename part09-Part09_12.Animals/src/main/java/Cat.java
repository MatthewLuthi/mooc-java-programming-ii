/**
 *
 * @author Matt
 */
public class Cat extends Animal implements NoiseCapable {
    
    public Cat() {
        super("Cat");
    }
    
    public Cat(String name) {
        super(name);
    }
    
    protected void purr() {
        System.out.println(this.getName() + " purrs");
    }

    @Override
    public void makeNoise() {
        purr();
    }
}
