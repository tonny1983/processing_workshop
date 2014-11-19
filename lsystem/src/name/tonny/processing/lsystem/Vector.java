package name.tonny.processing.lsystem;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

public class Vector {
	private PVector startPoint;
	private PVector endPoint;
	
	private final int max=255;
    private final int min=10;
    private final Random random = new Random();
	
	final private float REDUCTION_RATE;
	
	public Vector(PVector startPoint, PVector endPoint, float reductionRate) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.REDUCTION_RATE = reductionRate;
	}
	
	public Vector getCounterclockwise(float sita) {
		double x = (endPoint.x - startPoint.x) * REDUCTION_RATE * Math.cos(sita)
				- (endPoint.y - startPoint.y) * REDUCTION_RATE * Math.sin(sita)
				+ endPoint.x;
		double y = (endPoint.x - startPoint.x) * REDUCTION_RATE * Math.sin(sita)
				+ (endPoint.y - startPoint.y) * REDUCTION_RATE * Math.cos(sita)
				+ endPoint.y;
		PVector newEnd = new PVector((float)x, (float)y);
		return new Vector(endPoint, newEnd, REDUCTION_RATE);
	}
	
	public Vector getClockwise(float sita) {
		double x = (endPoint.x - startPoint.x) * REDUCTION_RATE * Math.cos(sita)
				+ (endPoint.y - startPoint.y) * REDUCTION_RATE * Math.sin(sita)
				+ endPoint.x;
		double y = -1 * (endPoint.x - startPoint.x) * REDUCTION_RATE * Math.sin(sita)
				+ (endPoint.y - startPoint.y) * REDUCTION_RATE * Math.cos(sita)
				+ endPoint.y;
		PVector newEnd = new PVector((float)x, (float)y);
		return new Vector(endPoint, newEnd, REDUCTION_RATE);
	}
	
	public void drawVector(int maxY, PApplet applet) {
		applet.stroke(random.nextInt(max)%(max-min+1) + min, random.nextInt(max)%(max-min+1) + min, random.nextInt(max)%(max-min+1) + min);
		applet.line(startPoint.x, maxY - startPoint.y, endPoint.x, maxY - endPoint.y);
	}
}
