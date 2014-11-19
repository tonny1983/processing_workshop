package name.tonny.processing.lsystem;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;


public class LSYSTEM extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4791239911085433597L;

	public void setup() {
		size(600, 600);
		background(0, 0, 0);
		noLoop();
	}

	public void draw() {
		PVector p1 = new PVector(300, 50);
		PVector p2 = new PVector(300, 250);
		Vector vector = new Vector(p1, p2, 0.6f);
		vector.drawVector(600, this);
		ArrayList<Vector> listV = new ArrayList<Vector>();
		listV.add(vector);
		for (int i = 0; i < 14; i++) {
			ArrayList<Vector> temp = new ArrayList<Vector>();
			for (Vector vec : listV) {
				Vector left = vec.getCounterclockwise(QUARTER_PI);
				left.drawVector(600, this);
				Vector right = vec.getClockwise(QUARTER_PI);
				right.drawVector(600, this);
				temp.add(left);
				temp.add(right);
			}
			listV = temp;
		}
	}
}
