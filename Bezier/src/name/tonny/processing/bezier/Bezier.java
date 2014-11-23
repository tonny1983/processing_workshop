package name.tonny.processing.bezier;

import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class Bezier extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -567624496920482307L;

	private static final List<Vector> list = new LinkedList<Vector>();
	
	/**
	 * whether the applet is running
	 */
	private boolean runFlag = false;
	/**
	 * whether the applet is pausing
	 */
	private boolean pauseFlag = false;
	
	private int step = 1;
	
	public void setup() {
		size(600, 600);
		background(0, 0, 0);
		textSize(14);
		fill(240, 102, 153);
		text("click mouse to create line(s)", 5, 15);
		text("press [r] to calculate Bezier", 5, 30);
		text("press [p] to pause", 5, 45);
		text("press [n] to clear all", 5, 60);
		frameRate(10);
		noLoop();
	}
	
	public void draw() {
		if (runFlag && !pauseFlag && !Vector.drawBezier(list, this, (float)(step++ * 0.01))) {
			noLoop();
			runFlag = false;
		}
			
	}
	
	@Override
	public void keyPressed() {
		// press 'r' for start to run
		if (key == 'r' && !runFlag) {
			runFlag = !runFlag;
			list.remove(0);
			loop();
		}
		// press 'n' for new one
		if (key == 'n') {
			noLoop();
			list.removeAll(list);
			runFlag = false;
			step = 1;
			background(0, 0, 0);
			clear();
			redraw();
			textSize(14);
			fill(240, 102, 153);
			text("click mouse to create line(s)", 5, 15);
			text("press [r] to calculate Bezier", 5, 30);
			text("press [p] to pause", 5, 45);
			text("press [n] to clear all", 5, 60);
		}
		// press 'p' to pause
		if (key == 'p') {
			if (pauseFlag) 
				loop();
			else
				noLoop();
			pauseFlag = !pauseFlag;
		}
	}

	@Override
	public void mousePressed() {
		if (!runFlag) {
			Vector.addVector(list, new PVector(mouseX, mouseY));
			Vector.drawLineInList(list, this);
			redraw();
		}
	}
	
	
}
