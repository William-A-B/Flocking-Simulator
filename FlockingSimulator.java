import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import bird.DynamicBird;
import drawing.Canvas;
import gui.GUI;
import obstacles.Rectangle;
import tools.Utils;



/**
 * Entry point into program
 * Main class handles the setup of the simulator window
 * And contains the main game loop to run the simulation
 * 
 * @author Y3905304
 */
public class FlockingSimulator {

	
	// Frame for adding panels and canvas to
	private JFrame mainFrame = new JFrame();
	
	// Canvas for drawing onto
	private Canvas myCanvas = new Canvas();
	
	// Constants for the initial window size
	public static final int WINDOW_X_SIZE = 1280;
	public static final int WINDOW_Y_SIZE = 720;
	
	// Lists to store the various birds, and objects
	private List<Rectangle> listOfObjects;
	private List<DynamicBird> listOfBirds;
	
	/**
	 * Main constructor to enter the program
	 */
	public FlockingSimulator() {
		super();
		
		initialiseCanvas();
		initialiseObjects();
		initialiseBirds();
		initialiseGUI();
	}
	
	/**
	 * Creates an object of this class to call the runProgram method
	 * @param args, command line arguments
	 */
	public static void main(String[] args) {
		FlockingSimulator myFlockingSimulation = new FlockingSimulator();
		
		myFlockingSimulation.runProgram();
	}
	
	/**
	 * Initialises the canvas and adds it to the frame window
	 */
	private void initialiseCanvas() {
		// Setup frame of type JFrame
		mainFrame.setTitle("Flocking Simulation");
		mainFrame.setSize(WINDOW_X_SIZE, WINDOW_Y_SIZE);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		// Initialise canvas.
		myCanvas.setDoubleBuffered(true);
		myCanvas.setOpaque(false);
		
		// Construct new main JPanel to overlay background and canvas.
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new OverlayLayout(mainPanel));
		
		// Overlay canvas.
		mainPanel.add(myCanvas, BorderLayout.CENTER);
		
		// Add main panel to main JFrame
		mainFrame.add(mainPanel);
	}
	
	/**
	 * Create the lists to store the birds and predators
	 */
	private void initialiseBirds() {
		listOfBirds = Collections.synchronizedList(new ArrayList<>());
	}
	
	/**
	 * Instantiate a GUI object to setup the GUI onto the frame window
	 */
	private void initialiseGUI() {
		
		GUI gui = new GUI(mainFrame, myCanvas);
		
		gui.setupGUI();
		
		gui.setupPanels();
		
		gui.defineListeners(listOfBirds, listOfObjects);
	}

	/**
	 * Instantiate the Objects for the birds to avoid and add them into the list
	 */
	private void initialiseObjects() {
		listOfObjects = Collections.synchronizedList(new ArrayList<>());
		listOfObjects.add(new Rectangle(myCanvas, 100, 100, 150, 50));
		listOfObjects.add(new Rectangle(myCanvas, 350, 200, 80, 180));
		listOfObjects.add(new Rectangle(myCanvas, 550, 300, 120, 120));	
	}
	
	/**
	 * Method to handle the game loop and flocking simulation
	 * Continuous loop which runs to update the birds and predators
	 * Undraws all birds, flocks any birds according to sliders,
	 * then updates the positions of all birds and predators, 
	 * then redraws everything again.
	 */
	private void runProgram() {
		// Variables used for running the game
		// deltaTime the framerate to update the birds with
		int deltaTime = 20;
		boolean continueRunning = true;
		int count = -1;
		
		// Variables to store the canvas width and height
		int canvasWidth = 0;
		int canvasHeight = 0;
		
		// Game loop with random motion
		while (continueRunning) {
			
			// Get the canvas width and height, so the window can be resized dynamically
			canvasWidth = myCanvas.getWidth();
			canvasHeight = myCanvas.getHeight();
			
			// Undraw all birds on the screen
			synchronized (listOfBirds) {
				for (DynamicBird aBird : listOfBirds) {
					aBird.undraw();
				}
			}
			
			// Conditionals to handle the counter used to determine the random motion of the birds
			// Initial reset state - allows birds to turn the maximum angle of +/- 180
			if (count == -1) {
				deltaTime = 0;
				count = 0;
			}
			// Random motion update reset state - birds update angular velocity by a small amount in this case
			else if (count == 0) {
				deltaTime = 1;
			}
			// Dont update angle of birds
			else {
				deltaTime = 20;
			}
			
			// Need to store the index of the bird that may have been caught and eaten
			// So it can be removed from the list once the iteration has completed
			List<Integer> indexOfEatenBirds = new ArrayList<Integer>();
 
			
			// Update methods to flock and avoid objects, then to update all the birds positions
			// Update methods for predators to chase prey and avoid objects, then to update all the predators positions
			synchronized (listOfBirds) {
				for (DynamicBird aBird : listOfBirds) {
					aBird.flock(listOfBirds, aBird);
					
					aBird.avoidObject(aBird, listOfObjects);
					
					int index = aBird.chasePrey(listOfBirds, aBird);
					
					if (index >= 0) {
						indexOfEatenBirds.add(index);
					}
					
					aBird.update(deltaTime);
				}
			}
			
			// Remove any eaten birds
			synchronized (listOfBirds) {
				if (indexOfEatenBirds.size() > 0) {
					for (Integer indexOfEatenBird : indexOfEatenBirds) {
						listOfBirds.remove(listOfBirds.get(indexOfEatenBird));
					}
				}
			}
			
			
			// Redraw all birds onto the screen
			// Wrap their position around if they are at the edge of the window
			// Redraw all predators onto the screen
			// Wrap their position around if they are at the edge of the window
			synchronized (listOfBirds) {
				for (DynamicBird aBird : listOfBirds) {
					aBird.draw();
					// Debug used to see the position of the birds printed out
					//System.out.println("\t(" + aFlockingBird.getPositionX() + "," + aFlockingBird.getPositionY() + ")");
					
					aBird.wrapPosition(canvasWidth, canvasHeight);
				}
			}
	
			// Pause all actions for deltaTime - effectively responsible for the refresh rate of the game
			Utils.pause(deltaTime);
			
			// If count reaches zero, get a new random counter starting number between 2 and 12
			if (count == 0) {
				count = 2 + (int)(10 *  Math.random());
			}
			// Decrement counter value after each loop iteration
			count--;
			
		}
	}
}