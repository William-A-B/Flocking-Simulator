package obstacles;

import bird.Bird;
import drawing.Canvas;
import geometry.CartesianCoordinate;

/**
 * Class within the objects package with a rectangle shape.
 * Draws a rectangle when constructed by the given parameters
 * Contains a noFlyZone, where birds cannot fly in
 * 
 * @author Y3905304
 */
public class Rectangle {

	private Canvas myCanvas;
	
	private CartesianCoordinate noFlyZoneMin;
	private CartesianCoordinate noFlyZoneMax;
	
	/**
	 * Constructor to draw a rectangle at the given position
	 * Creates a no fly zone area which is used to determine where birds can and cannot fly
	 * 
	 * @param myCanvas The canvas to draw the birds onto
	 * @param topLeftX The top left X position of the object
	 * @param topLeftY The top left Y position of the object
	 * @param dx Length of the X sides
	 * @param dy Length of the Y sides
	 */
	public Rectangle(Canvas myCanvas, int topLeftX, int topLeftY, int dx, int dy) {
		
		this.myCanvas = myCanvas;
		drawRectangle(topLeftX, topLeftY, dx, dy);
		setNoFlyZone(topLeftX, topLeftY, dx, dy);
		
		
	}

	/**
	 * Draws a rectangle when called from the constructor.
	 * 
	 * @param topLeftX The top left X position of the object
	 * @param topLeftY The top left Y position of the object
	 * @param dx Length of the X sides
	 * @param dy Length of the Y sides
	 */
	private void drawRectangle(int topLeftX, int topLeftY, int dx, int dy) {
		
		// Create a bird ("turtle") that will be used to draw out the shape
		// Afterwards set it to null so its not used anymore
		Bird drawingBird = new Bird(myCanvas);
		
		// Start drawing from the top left corner
		drawingBird.moveTo(topLeftX, topLeftY);
		
		drawingBird.putPenDown();
		drawingBird.turn(90);
		drawingBird.move(dx);
		drawingBird.turn(90);
		drawingBird.move(dy);
		drawingBird.turn(90);
		drawingBird.move(dx);
		drawingBird.turn(90);
		drawingBird.move(dy);
		drawingBird.putPenUp();
		
		drawingBird = null;
		
	}
	
	/**
	 * Defines the area of the object where no birds or predators can fly
	 * 
	 * @param topLeftX The top left X position of the object
	 * @param topLeftY The top left Y position of the object
	 * @param dx Length of the X sides
	 * @param dy Length of the Y sides
	 */
	public void setNoFlyZone(int topLeftX, int topLeftY, int dx, int dy) {
		noFlyZoneMin = new CartesianCoordinate(topLeftX, topLeftY);
		noFlyZoneMax = new CartesianCoordinate((topLeftX + dx), (topLeftY + dy));
	}
	
	/**
	 * @return Returns the minimum no fly zone
	 */
	public CartesianCoordinate getNoFlyZoneMin() {
		return noFlyZoneMin;
	}

	/**
	 * @return Returns the maximum no fly zone
	 */
	public CartesianCoordinate getNoFlyZoneMax() {
		return noFlyZoneMax;
	}
}
