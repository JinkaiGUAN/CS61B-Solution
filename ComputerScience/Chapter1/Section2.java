public class Question25 {
	public static void main(String[] args) {
		double t = Double.parseDouble(args[0]);
		double v = Double.parseDouble(args[1]);
		double w = 35.74 + 0.6215*t + (0.4275*t - 35.75) * Math.pow(v, 0.16);
		if (v > 120 || v < 3 || w > 50) {
			System.out.println("Invalid");
		} else {
			System.out.println(w);
		}
	}
}

public class Question26 {
	public void main(String[] args) {
		double x = double.parseDouble(args[0]);
		double y = double.parseDouble(args[1]);
		double l = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double theta = Math.atan2(y, x);
	}
}

public class Question29 {
	public static void main(Stirng[] args) {
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);

		int y0 = y - (14 - m) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = m + 12 * ((14-m)/12) - 2;
		int d0 = (d + x + 31*m0/12) % 7;
	}
}



