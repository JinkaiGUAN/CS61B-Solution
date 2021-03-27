/*Question 1*/
public class AllEqual {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);

		if (x == y && y == z) {
			System.out.println("Equal!");
		} else {
			System.out.println("Not equal!");
		}
	}
}


/*Question 6*/
public class RollLoadedDie {
	public static void main(String[] args) {
		double r = Math.random();

		int roll;
		if (r < 1.0 / 8.0) roll = 1;
		else if ( r < 2.0 / 8.0) roll = 2;
		else if ( r < 3.0 / 8.0) roll = 3;
		else if ( r < 4.0 / 8.0) roll = 4;
		else if ( r < 5.0 / 8.0) roll = 5;
		else roll = 6;

		System.out.println(roll);
	}
}


/*Question 8*/
public class Hello {
	public static void main(String[] args) {
		int n = INteger.parseInt(args[0]);

		for (int i = 1; i <= n; i++) {
			System.out.print(i);

			if (i % 100 >= 11 && i % 100 <= 20) {
				System.out.print("th");
			} else if (i % 10 == 1) System.out.print("st");
			else if (i % 10 == 2) System.out.print("nd");
			else if (i % 10 == 3) System.out.print("rd");
			else System.out.print("th");
			System.out.print(" Hello");
		}
	}
}


/*Question 9*/
public class FivePerLine {
	public static void main(String[] args) {
		
		for (int i = 1000; i <= 2000; i ++) {
			if ( (i+1) % 5 == 0) {
				System.out.println();
			}
			System.out.print(i + " ");
		}
	}
}


/*Question 12*/
public class FunctionGrowth {
	public static void main(String[] args) {
		String header = "log n \tn \tn log n \tn^2 \tn^3";
		System.out.println(header);
		int n = 16
		while (n <= 2048) {
			System.out.print((int) Math.log(i));
			System.out.print('\t');
			System.out.print(i);
			System.out.print('\t');
			System.out.print((int) i * Math.log(i));
			System.out.print('\t');
			System.out.print(Math.pow(i, 2));
			System.out.print('\t');
			System.out.print(Math.pow(i, 3));
			System.out.println();

			n *= 2;
		}
	}
}