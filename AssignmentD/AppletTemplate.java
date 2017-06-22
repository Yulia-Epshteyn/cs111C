package Assignments.AssignmentD;

import javax.swing.*;
import java.awt.*;

public class AppletTemplate extends JApplet {
	final static int MAX_SIDE_OF_SQUARE = 240;
	final static int MIN_SIDE_OF_SQUARE = 15;
	final static int FACTOR_OF_SHRINK = 2;

	public void init() {
		setSize(500, 500);
		setBackground(Color.white);
	}

	public void paint(Graphics pen) {

		drawSquere(250, 250, MAX_SIDE_OF_SQUARE, pen);
	}

	public void drawSquere(int x, int y, int side, Graphics pen) {


		if (side < MIN_SIDE_OF_SQUARE) {
			return;
		} else {
			pen.setColor(Color.gray);
			pen.fillRect(x - side / FACTOR_OF_SHRINK, y - side / FACTOR_OF_SHRINK, side, side);
			pen.setColor(Color.black);
			pen.drawRect(x - side / FACTOR_OF_SHRINK, y - side / FACTOR_OF_SHRINK, side, side);

			drawSquere(x - side / FACTOR_OF_SHRINK, y - side / FACTOR_OF_SHRINK, side / FACTOR_OF_SHRINK, pen);
			drawSquere(x - side / FACTOR_OF_SHRINK, y + side / FACTOR_OF_SHRINK, side / FACTOR_OF_SHRINK, pen);
			drawSquere(x + side / FACTOR_OF_SHRINK, y + side / FACTOR_OF_SHRINK, side / FACTOR_OF_SHRINK, pen);
			drawSquere(x + side / FACTOR_OF_SHRINK, y - side / FACTOR_OF_SHRINK, side / FACTOR_OF_SHRINK, pen);
		}

	}
}
