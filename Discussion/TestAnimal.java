/**
 * @author: Peter
 * @date: 10/03/2021
 * @description:
 */
public class TestAnimal {
	public static void main(String[] args) {
		Animal a = new Animal("Pluto", 10);
		Cat c = new Cat("Garfield", 6);
		Dog d = new Dog("Fido", 4);
		a.greet(); // Aninmal Pluto says: Huh?
		c.greet(); // Cat Garfield says: Meow!
		d.greet(); // Dog Fido says: WOOF!
		a = c;
		a.greet();
		((Cat) a).greet(); // Cat Garfield says: Meow?
		a.greet(); //  Cat Garfield says: Meow?
		a = new Dog("Fod", 10);
//		d = a;
	}

}
