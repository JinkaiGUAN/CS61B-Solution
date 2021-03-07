public class NBody {

	/*It is a method return the radius of the universe.*/
	public static double readRadius(String file) {
		In in = new In(file);

		int planetsNum = in.readInt();
		double universeRadius = in.readDouble();

		return universeRadius; 
	}


	/*Return a list of planets*/
	public static Body[] readBodies(String file) {
		In in = new In(file);
		int numOfPlanets = in.readInt(); 
		Body[] planetList = new Body[numOfPlanets];

		// int planetsNum = in.readInt();
		// double universeRadius = in.readDouble();

		in.readDouble(); // Skip the second line
		for (int i = 0; i < numOfPlanets; i++) {
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double m 	= in.readDouble();
			String img  = in.readString();
			planetList[i] = new Body(xPos, yPos, xVel, yVel, m, img);
		}

		return planetList;
	}

 	public static void main(String[] args) {
 		/*Collecting all needed input*/
 		// Gain the time and delta time of the command
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		// Strore the filename
		String fileName = args[2];

		Body[] bodies = readBodies(fileName);
		double radius = readRadius(fileName);
		
		/**Drawing the background: 
		 * First, set the scale so that it matches the radius of the
		 universe.
		 * Then draw the immage starfield.jpg as the background.*/

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "./images/starfield.jpg");

		for (Body b : bodies) {
			b.draw();
		}
		StdDraw.show();
		StdDraw.pause(10000);
		StdDraw.clear();

		for (double time = 0; time < T; time+=dt) {
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];

			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}

			for (int i = 0; i < bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (Body b : bodies) {
				b.draw();
			}

			StdDraw.show(); // double buffering problem
			StdDraw.pause(10);	
		} 

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			 bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
			 bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
		}

	}
	
}