public class Body {
	/*Six instance variables */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	static final double gravitationalConst = 6.67e-11; 

	/*Constructor  */
	public Body(double xP, double yP, double xV,
	 			double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass  = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		double deltaX = Math.abs(this.xxPos - b.xxPos);
		double deltaY = Math.abs(this.yyPos - b.yyPos);
		double dis = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

		return dis;
	}

	public double calcForceExertedBy(Body b) {
		double force;
		if (this.equals(b)) {
			force = 0;
		} else {
 			double dis = this.calcDistance(b);
			force = gravitationalConst * this.mass * b.mass / Math.pow(dis, 2);
		}

		return force;
	}

	public double calcForceExertedByX(Body b) {
		double forceX;
		if (this.equals(b)) {
			forceX = 0;
		} else {
			double cos = (b.xxPos - this.xxPos) / this.calcDistance(b);
			forceX = this.calcForceExertedBy(b) * cos;
		}

		return forceX;
	}

	public double calcForceExertedByY(Body b) {
		double forceY;
		if (this.equals(b)) {
			forceY = 0;
		} else {
			double sin = (b.yyPos - this.yyPos) / this.calcDistance(b);
			forceY = this.calcForceExertedBy(b) * sin;
		}
		
		return forceY;
	}


	public double calcNetForceExertedByX(Body[] bodies) {
		int listLength = bodies.length;
		double netForceX = 0;
		for (int i=0; i < listLength; i = i + 1) {
			if (this.equals(bodies[i])) {
				netForceX = netForceX;
			} else {
   				netForceX = netForceX + this.calcForceExertedByX(bodies[i]);
			}
		}

		return netForceX;
	}

	public double calcNetForceExertedByY(Body[] bodies) {
		int listLength = bodies.length;
		double netForceY = 0;
		for (int i = 0; i < listLength; i = i + 1) {
			if (this.equals(bodies[i])) {
				netForceY = netForceY;
			} else {
				netForceY = netForceY + this.calcForceExertedByY(bodies[i]);
			}
		}

		return netForceY;
	}

	public Body update(double deltaT, double forceX, double forceY) {
		// Calculate the acceleration
		double accelerationX = forceX / this.mass;
		double accelerationY = forceY / this.mass;
		// Update velocity
		this.xxVel = this.xxVel + deltaT * accelerationX;
		this.yyVel = this.yyVel + deltaT * accelerationY;
		// Update position
		this.xxPos = this.xxPos + deltaT * this.xxVel;
		this.yyPos = this.yyPos + deltaT * this.yyVel;

		return this;
	}

	public void draw() {
		String folderName = "./images/";
		String path = folderName + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, path);
	}

}