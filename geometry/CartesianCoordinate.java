package geometry;

/**
 * Class to handle cartesian coordinates
 * Allows the construction of objects with an x and y position
 * Contains methods to set and return these positions
 * 
 * @author Y3905304
 */
public class CartesianCoordinate {

	
	// Doubles to store the x and y poisitions
	private double xPosition;
	private double yPosition;
	
	/**
	 * Class constructor, creates a new object with the given x and y positions
	 * 
	 * @param xPosition
	 * @param yPosition
	 */
	public CartesianCoordinate(double xPosition, double yPosition) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + xPosition + ", " + yPosition + ")";
	}

	/**
	 * 
	 * @return xPosition Returns the X position in the cartesian coordinate
	 */
	public double getX() {
		return xPosition;
	}


	/**
	 * 
	 * @param xPosition Used to set the X position in the cartesian coordinate to this value
	 */
	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * 
	 * @return yPosition Returns the Y osition in the cartesian coordinate
	 */
	public double getY() {
		return yPosition;
	}

	/**
	 * 
	 * @param yPosition Used to set the Y position in the cartesian coordinate to this value
	 */
	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}
	
	
	
}
