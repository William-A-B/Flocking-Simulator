package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bird.DynamicBird;
import bird.FlockingBird;
import bird.Predator;
import bird.DynamicBird.BirdType;
import drawing.Canvas;
import obstacles.Rectangle;

/**
 * GUI class which handles all of the panels, sliders and buttons being added
 * Contains all the event listeners for these sliders and buttons,
 * so that the simulation can be controlled whilst running
 * 
 * @author Y3905304
 */
public class GUI {
	
	// Main fields for Window Frame and GUI
	private JFrame guiFrame;
	private Canvas myCanvas;
	
	// Main fields for panels to hold buttons and sliders
	private JPanel lowerPanel = new JPanel();
	private JPanel lowerPanel2 = new JPanel();
	private JPanel lowerPanelMain = new JPanel();
	private JPanel upperPanel = new JPanel();

	// Main fields for the buttons
	private JButton addBirdButton;
	private JButton addTenBirdsButton;
	private JButton removeBirdButton;
	private JButton addPredatorButton;
	private JButton removePredatorButton;
	private JButton clearAllButton;
	private JButton fullScreenButton;
	
	// Main fields for the sliders
	private JSlider speedSlider;
	private JSlider alignmentShiftSlider;
	private JSlider alignmentRadiusSlider;
	private JSlider cohesionShiftSlider;
	private JSlider separationShiftSlider;
	
	// Main fields for the labels
	private JLabel speedLabel;
	private JLabel alignmentShiftLabel;
	private JLabel alignmentRadiusLabel;
	private JLabel cohesionShiftLabel;
	private JLabel separationLabel;
	private JLabel numberOfBirdsLabel;
	private JLabel numberOfPredatorsLabel;
	
	// Constants to define behaviour
	private static final int BIRD_SPEED_MIN = 0;
	private static final int BIRD_SPEED_MAX = 1000;
	private static final int BIRD_SPEED = 100;
	public static final int WINDOW_X_SIZE = 1280;
	public static final int WINDOW_Y_SIZE = 720;

	
	/**
	 * Constructor for the GUI class
	 * 
	 * @param mainFrame Frame for adding all components to
	 * @param myCanvas Canvas for drawing birds and predators onto
	 */
	public GUI(JFrame mainFrame, Canvas myCanvas) {
		this.guiFrame = mainFrame;
		this.myCanvas = myCanvas;
		
	}
	
	/**
	 * Instantiates and sets up the Buttons, Labels, and Sliders
	 */
	public void setupGUI() {
		// Setup single Turtle button
		addBirdButton = new JButton("Add Bird");
		addBirdButton.setEnabled(true);
		addBirdButton.setBackground(Color.GREEN);
		addBirdButton.setOpaque(false);
		
		// Setup multiple Turtle button
		addTenBirdsButton = new JButton("Add Ten Birds");
		addTenBirdsButton.setEnabled(true);
		addTenBirdsButton.setBackground(Color.GREEN);
		addTenBirdsButton.setOpaque(false);
		
		// Setup remove Turtle button
		removeBirdButton = new JButton("Remove Bird");
		removeBirdButton.setEnabled(true);
		removeBirdButton.setBackground(Color.GREEN);
		removeBirdButton.setOpaque(false);
		
		// Setup add Predator button
		addPredatorButton = new JButton("Add Predator");
		addPredatorButton.setEnabled(true);
		addPredatorButton.setBackground(Color.GREEN);
		addPredatorButton.setOpaque(false);
		
		// Setup remove Predator button
		removePredatorButton = new JButton("Remove Predator");
		removePredatorButton.setEnabled(true);
		removePredatorButton.setBackground(Color.GREEN);
		removePredatorButton.setOpaque(false);
		
		// Initialise number of birds label
		numberOfBirdsLabel = new JLabel("Birds: " + 0);
		numberOfPredatorsLabel = new JLabel("Predators: " + 0);
		
		// Setup clear all button
		clearAllButton = new JButton("Clear All");
		clearAllButton.setEnabled(true);
		clearAllButton.setBackground(Color.GREEN);
		clearAllButton.setOpaque(false);
		
		// Setup clear all button
		fullScreenButton = new JButton("Full Screen");
		fullScreenButton.setEnabled(true);
		fullScreenButton.setBackground(Color.GREEN);
		fullScreenButton.setOpaque(false);
		
		// Setup Speed slider
		speedSlider = new JSlider(JSlider.HORIZONTAL, BIRD_SPEED_MIN, BIRD_SPEED_MAX, BIRD_SPEED);
		speedSlider.setEnabled(true);
		speedSlider.setOpaque(false);
		
		speedSlider.setMajorTickSpacing(250);
		speedSlider.setMinorTickSpacing(50);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		
		// Initialise speed label.
		speedLabel = new JLabel("Speed: " + BIRD_SPEED);
		
		// Setup Alignment Shift slider
		alignmentShiftSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		alignmentShiftSlider.setEnabled(true);
		alignmentShiftSlider.setOpaque(false);
		
		alignmentShiftSlider.setMajorTickSpacing(25);
		alignmentShiftSlider.setMinorTickSpacing(5);
		alignmentShiftSlider.setPaintTicks(true);
		alignmentShiftSlider.setPaintLabels(true);
		
		// Initialise Alignment Shift label
		alignmentShiftLabel = new JLabel("Alginment Shift: " + 0);
		
		// Setup Alignment Radius slider
		alignmentRadiusSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 80);
		alignmentRadiusSlider.setEnabled(true);
		alignmentRadiusSlider.setOpaque(false);
		
		alignmentRadiusSlider.setMajorTickSpacing(50);
		alignmentRadiusSlider.setMinorTickSpacing(10);
		alignmentRadiusSlider.setPaintTicks(true);
		alignmentRadiusSlider.setPaintLabels(true);
		
		// Initialise Alignment Radius label
		alignmentRadiusLabel = new JLabel("Alginment Radius: " + 80);
		
		// Setup Cohesion slider
		cohesionShiftSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		cohesionShiftSlider.setEnabled(true);
		cohesionShiftSlider.setOpaque(false);
		
		cohesionShiftSlider.setMajorTickSpacing(25);
		cohesionShiftSlider.setMinorTickSpacing(5);
		cohesionShiftSlider.setPaintTicks(true);
		cohesionShiftSlider.setPaintLabels(true);
		
		// Initialise Cohesion label
		cohesionShiftLabel = new JLabel("Cohesion Shift: " + 0);
		
		// Setup Separation slider
		separationShiftSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		separationShiftSlider.setEnabled(true);
		separationShiftSlider.setOpaque(false);
		
		separationShiftSlider.setMajorTickSpacing(25);
		separationShiftSlider.setMinorTickSpacing(10);
		separationShiftSlider.setPaintTicks(true);
		separationShiftSlider.setPaintLabels(true);
		
		// Initialise Separation label
		separationLabel = new JLabel("Separation Shift: " + 0);
		
		
	}
	
	/**
	 * Sets up the panels to contain the Buttons, Labels and Sliders
	 * Added to the top and bottom of the frame so the user can interact with them
	 */
	public void setupPanels() {
		// Setup lower panel
		lowerPanel.setLayout(new FlowLayout());
		lowerPanel.setBackground(new Color(194, 244, 255));
		lowerPanel.add(alignmentShiftLabel);
		lowerPanel.add(alignmentShiftSlider);
		lowerPanel.add(cohesionShiftLabel);
		lowerPanel.add(cohesionShiftSlider);
		lowerPanel.add(separationLabel);
		lowerPanel.add(separationShiftSlider);
		
		lowerPanel2.setLayout(new FlowLayout());
		lowerPanel2.setBackground(new Color(194, 244, 255));
		lowerPanel2.add(speedLabel);
		lowerPanel2.add(speedSlider);
		lowerPanel2.add(alignmentRadiusLabel);
		lowerPanel2.add(alignmentRadiusSlider);
		
		lowerPanelMain.setLayout(new GridLayout(2, 1));
		lowerPanelMain.setBackground(new Color(194, 244, 255));
		lowerPanelMain.add(lowerPanel2, BorderLayout.SOUTH);
		lowerPanelMain.add(lowerPanel, BorderLayout.SOUTH);
		
		
		// Setup upper panel
		upperPanel.setLayout(new FlowLayout());
		upperPanel.setBackground(new Color(194, 244, 255));
		upperPanel.add(addBirdButton);
		upperPanel.add(addTenBirdsButton);
		upperPanel.add(removeBirdButton);
		upperPanel.add(addPredatorButton);
		upperPanel.add(removePredatorButton);
		upperPanel.add(clearAllButton);
//		upperPanel.add(numberOfBirdsLabel);
//		upperPanel.add(numberOfPredatorsLabel);
		
		guiFrame.add(upperPanel, BorderLayout.NORTH);
		guiFrame.add(lowerPanelMain, BorderLayout.SOUTH);
		guiFrame.revalidate();
	}
	
	/**
	 * Method to instantiate a flocking bird
	 * The bird is added into the listOfFlockingBirds
	 * And then displayed on the canvas window
	 * 
	 * @param listOfFlockingBirds List containing all the birds which flock
	 * @param listOfObjects List containing all the objects the birds must avoid
	 */
	public void addBird(List<DynamicBird> listOfBirds, List<Rectangle> listOfObjects) {
		double alignCalc = 0;
		alignCalc = alignmentShiftSlider.getValue();
		System.out.println("slider " + alignCalc);
		alignCalc = alignCalc/800;
		
		double radiusCalc = 0;
		radiusCalc = alignmentRadiusSlider.getValue();
		System.out.println("slider " + radiusCalc);
		
		double cohesionCalc = 0;
		cohesionCalc = cohesionShiftSlider.getValue();
		System.out.println("slider " + cohesionCalc);
		cohesionCalc = cohesionCalc/800;
		
		double separationCalc = 0;
		separationCalc = separationShiftSlider.getValue();
		System.out.println("slider " + separationCalc);
		separationCalc = separationCalc/1600;
		
		FlockingBird aFlockingBird = new FlockingBird(myCanvas, WINDOW_X_SIZE/2, WINDOW_Y_SIZE/2, listOfObjects);
		aFlockingBird.setSpeed(speedSlider.getValue());
		aFlockingBird.setAlignmentShift(alignCalc);
		aFlockingBird.setAlignmentRadius(radiusCalc);
		aFlockingBird.setCohesionShift(cohesionCalc);
		aFlockingBird.setSeparationShift(separationCalc);
		
		synchronized (listOfBirds) {
			listOfBirds.add(aFlockingBird);
		}
	}
	/**
	 * Method to instantiate a predator
	 * The predator is added into the listOfPredators
	 * And then displayed on the canvas window
	 * 
	 * @param listOfPredators List containing all the predators which eat birds
	 * @param listOfObjects List containing all the objects the predators must avoid
	 */
	
	public void addPredator(List<DynamicBird> listOfBirds, List<Rectangle> listOfObjects) {
		Predator aPredator = new Predator(myCanvas, WINDOW_X_SIZE/2, WINDOW_Y_SIZE/2, listOfObjects);
		aPredator.setSpeed(speedSlider.getValue()*1.05);
		
		synchronized (listOfBirds) {
			listOfBirds.add(aPredator);
		}
	}
	
	/**
	 * Removes the last flocking bird in the list
	 * 
	 * @param listOfBirds List of birds to remove bird from
	 */
	public void removeBird(List<DynamicBird> listOfBirds) {
		int indexToRemove = -1;
		synchronized (listOfBirds) {
			for (int i = 0; i < listOfBirds.size(); i++) {
				if (listOfBirds.get(i).getBirdType() == BirdType.FLOCKINGBIRD) {
					indexToRemove = i;
				}
			}
			
			if (indexToRemove >= 0) {
				listOfBirds.get(indexToRemove).undraw();
				listOfBirds.remove(indexToRemove);
			}
			else {
				System.out.println("No more birds left to remove!");
			}
		}
	}
	
	/**
	 * Removes the last predator in the list
	 * 
	 * @param listOfBirds List of birds to remove predator from
	 */
	public void removePredator(List<DynamicBird> listOfBirds) {
		int indexToRemove = -1;
		synchronized (listOfBirds) {
			for (int i = 0; i < listOfBirds.size(); i++) {
				if (listOfBirds.get(i).getBirdType() == BirdType.PREDATOR) {
					indexToRemove = i;
				}
			}
			if (indexToRemove >= 0) {
				listOfBirds.get(indexToRemove).undraw();
				listOfBirds.remove(indexToRemove);
			}
			else {
				System.out.println("No more predators left to remove!");
			}
			
		}
	}
	
	/**
	 * Update the number in the upper panel, showing the current number of birds on the canvas
	 * 
	 * @param listOfFlockingBirds List containing all the birds which flock
	 */
	public void updateBirdNumbers(List<DynamicBird> listOfBirds) {
		numberOfBirdsLabel.setText("Birds: " + listOfBirds.size());
	}
	
	/**
	 * Update the number in the upper panel, showing the current number of predators on the canvas
	 * 
	 * @param listOfPredators List containing all the predators which eat birds
	 */
	public void updatePredatorNumbers(List<DynamicBird> listOfBirds) {
		numberOfPredatorsLabel.setText("Predators: " + listOfBirds.size());
	}

	/**
	 * Defines all the event listeners for the Buttons and Sliders on the GUI
	 * Utilises anonymous classes to run actions for each listener when the user changes something in the GUI
	 * 
	 * @param listOfFlockingBirds List containing all the birds which flock
	 * @param listOfPredators List containing all the predators which eat birds
	 * @param listOfObjects List containing all the objects the birds and predators must avoid
	 */
	public void defineListeners(List<DynamicBird> listOfBirds, List<Rectangle> listOfObjects) {
		
		// Listener for the add singular bird button
		// Adds a single bird to the canvas
		addBirdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addBird(listOfBirds, listOfObjects);
				updateBirdNumbers(listOfBirds);
			}
		});
		
		// Listener to add 10 birds to the canvas
		addTenBirdsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					addBird(listOfBirds, listOfObjects);
					updateBirdNumbers(listOfBirds);
				}
			}
		});
		
		// Listener to remove the last bird added from the canvas
		removeBirdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				removeBird(listOfBirds);
				updateBirdNumbers(listOfBirds);									
			}
		});
		
		// Listener to add a predator to the canvas
		addPredatorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addPredator(listOfBirds, listOfObjects);
				updatePredatorNumbers(listOfBirds);
			}
		});
		
		// Listener to remove the last predator added from the canvas
		removePredatorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removePredator(listOfBirds);
				updatePredatorNumbers(listOfBirds);				
			}
		});
		
		// Clears all birds and predators on the canvas
		// Undraws all birds and predators
		// Removes all birds and predators from the lists
		clearAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized (listOfBirds) {
					while (listOfBirds.size() > 0) {
						listOfBirds.get(listOfBirds.size()-1).undraw();
						listOfBirds.remove(listOfBirds.size()-1);
						updateBirdNumbers(listOfBirds);
						updatePredatorNumbers(listOfBirds);
					}
				}
			}
		});
		
		// Listener to adjust the speed of the birds and predators based on the slider value
		speedSlider.addChangeListener(new ChangeListener() {
		
			@Override
			public void stateChanged(ChangeEvent e) {
				synchronized (listOfBirds) {
					for (DynamicBird aBird : listOfBirds) {
						aBird.setSpeed(speedSlider.getValue());
					}
				}
				speedLabel.setText("Speed: " + speedSlider.getValue());
			}
			
		});
		
		// Listener to adjust the amount of alignment the birds flock by
		// Sets the alignment Shift constant for each bird
		alignmentShiftSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				double alignCalc = 0;
				alignCalc = alignmentShiftSlider.getValue();
				System.out.println("slider " + alignCalc);
				alignCalc = alignCalc/800;
				
				synchronized (listOfBirds) {
					for (DynamicBird aBird : listOfBirds) {
						// Only apply flocking parameters if the bird is a flocking bird
						// If a flocking bird, cast to a flocking bird to set the constants
						if (aBird.getBirdType() == BirdType.FLOCKINGBIRD) {
							((FlockingBird) aBird).setAlignmentShift(alignCalc);
							System.out.printf("%1.5f\n", ((FlockingBird) aBird).getAlignmentShift());
						}
						
					}
				}
				alignmentShiftLabel.setText("Alignment Shift: " + alignmentShiftSlider.getValue());
			}
			
		});
		
		
		alignmentRadiusSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				double radiusCalc = 0;
				radiusCalc = alignmentRadiusSlider.getValue();
				System.out.println("slider " + radiusCalc);
				
				synchronized (listOfBirds) {
					for (DynamicBird aBird : listOfBirds) {
						// Only apply flocking parameters if the bird is a flocking bird
						// If a flocking bird, cast to a flocking bird to set the constants
						if (aBird.getBirdType() == BirdType.FLOCKINGBIRD) {
							((FlockingBird) aBird).setAlignmentRadius(radiusCalc);
							System.out.printf("%1.5f\n", ((FlockingBird) aBird).getAlignmentRadius());
						}
						
					}
				}
				alignmentRadiusLabel.setText("Alignment Radius: " + alignmentRadiusSlider.getValue());
			}
			
		});
		
		cohesionShiftSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				double cohesionCalc = 0;
				cohesionCalc = cohesionShiftSlider.getValue();
				System.out.println("slider " + cohesionCalc);
				cohesionCalc = cohesionCalc/1600;
				
				synchronized (listOfBirds) {
					for (DynamicBird aBird : listOfBirds) {
						// Only apply flocking parameters if the bird is a flocking bird
						// If a flocking bird, cast to a flocking bird to set the constants
						if (aBird.getBirdType() == BirdType.FLOCKINGBIRD) {
							((FlockingBird) aBird).setCohesionShift(cohesionCalc);
							System.out.printf("%1.5f\n", ((FlockingBird) aBird).getCohesionShift());
						}
						
					}
				}
				cohesionShiftLabel.setText("Cohesion Shift: " + cohesionShiftSlider.getValue());
			}
			
		});
		
		separationShiftSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				double separationCalc = 0;
				separationCalc = separationShiftSlider.getValue();
				System.out.println("slider " + separationCalc);
				separationCalc = separationCalc/1600;
				
				synchronized (listOfBirds) {
					for (DynamicBird aBird : listOfBirds) {
						// Only apply flocking parameters if the bird is a flocking bird
						// If a flocking bird, cast to a flocking bird to set the constants
						if (aBird.getBirdType() == BirdType.FLOCKINGBIRD) {
							((FlockingBird) aBird).setSeparationShift(separationCalc);
							System.out.printf("%1.5f\n", ((FlockingBird) aBird).getSeparationShift());
						}
						
					}
				}
				separationLabel.setText("Separation Shift: " + separationShiftSlider.getValue());
			}
			
		});
		
	}

}
