package tools;

import geometry.CartesianCoordinate;

/**
 * Utility class which contains miscellaneous methods that can be called from anywhere within the program
 * Used to implement methods which are useful for various functionalities.
 * 
 * @author Y3905304
 */
public class Utils {
	
	/**
	 * Pauses the current thread for a set period of time.
	 * 
	 * @param time the time to pause, in milliseconds.
	 */
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// We are happy with interruptions, so do not report any exceptions.
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculates the displacement between two sets of coordinates
	 * 
	 * @param x1 First X coordinate position
	 * @param y1 First Y coordinate position
	 * @param x2 Second X coordinate position
	 * @param y2 Second Y coordinate position
	 * @return Returns the displacement between the two coordinates
	 */
	public static double displacement(double x1, double y1, double x2, double y2) {

		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}
	
	/**
	 * Calculates the bearing relative from the first position given.
	 * This gives the bearing from North to the second position, centered around position one
	 * 
	 * @param positionOne The centre position for the bearing, the start position
	 * @param positionTwo The position to calculate the bearing to
	 * @return Returns the bearing given in degrees from positionOne to positonTwo
	 */
	public static double bearing(CartesianCoordinate positionOne, CartesianCoordinate positionTwo) {
		double bearing = 0.0;
		// Top right quadrant
		if (positionTwo.getX() >= positionOne.getX() && positionTwo.getY() <= positionOne.getY()) {
			bearing = Math.toDegrees(Math.atan2(positionTwo.getX() - positionOne.getX(), positionOne.getY() - positionTwo.getY()));
		}
		// Bottom right quadrant
		else if (positionTwo.getX() > positionOne.getX() && positionTwo.getY() > positionOne.getY()) {
			bearing = Math.toDegrees(Math.atan2(positionTwo.getY() - positionOne.getY(), positionTwo.getX() - positionOne.getX()));
			bearing = bearing + 90;
		}
		// Bottom left quadrant
		else if (positionTwo.getX() <= positionOne.getX() && positionTwo.getY() >= positionOne.getY()) {
			bearing = Math.toDegrees(Math.atan2(positionOne.getX() - positionTwo.getX(), positionTwo.getY() - positionOne.getY()));
			bearing = bearing + 180;
		}
		// Top left quadrant
		else if (positionTwo.getX() < positionOne.getX() && positionTwo.getY() < positionOne.getY()) {
			bearing = Math.toDegrees(Math.atan2(positionOne.getY() - positionTwo.getY(), positionOne.getX() - positionTwo.getX()));
			bearing = bearing + 270;
		}
		else {
			return 0.0;
		}
		
	
		return bearing;
	}
	
}
