/**
 * @author: Peter
 * @date: 10/03/2021
 * @description:
 */
public class Animal {
    protected String name, noise;
    protected int age;

    public Animal (String name, int aga) {
        this.name = name;
        this.age = age;
        this.noise = "Huh?";
    }

    public String makeNoise() {
        if (age < 5) {
            return noise.toUpperCase();
        } else {
            return noise;
        }
    }

    public void greet() {
        System.out.println("Aninmal " + name + " says: " + makeNoise());
    }
}
