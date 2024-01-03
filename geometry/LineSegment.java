package geometry;

/**
 * Utilised by the canvas class to create a list of lines.
 * Can be used to create a line between two cartesian coordinate positions
 * 
 * @author Y3905304
 */
public class LineSegment {

		
	CartesianCoordinate startPoint;
	CartesianCoordinate endPoint;


	/**
	 * @param startPoint Start coordinate of line
	 * @param endPoint End coordinate of line
	 */
	public LineSegment(CartesianCoordinate startPoint, CartesianCoordinate endPoint) {
			
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public CartesianCoordinate getStartPoint() {
		return startPoint;
	}

	public CartesianCoordinate getEndPoint() {
		return endPoint;
	}

	public void setStartPoint(CartesianCoordinate startPoint) {
		this.startPoint = startPoint;
	}

	public void setEndPoint(CartesianCoordinate endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * 
	 * @return Returns the lentgh of the line
	 */
	public double length() {
		double length = 0;
		
		length = Math.hypot((endPoint.getX() - startPoint.getX()), (endPoint.getY() - startPoint.getY()));
		
		return length;
	}


}
