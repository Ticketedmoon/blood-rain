package com.bloodrain.display.DisplayConfiguration;

import com.bloodrain.display.DisplayPanels.RenderPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Display {

	// Display objects
	private static Display display;
	private JFrame frame;

	// Constants
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 520;
	private static final int TOTAL_RAIN_AMOUNT = 400;
	private static final String TITLE = "Blood Rain - Created by Shane Creedon";

	/**
	 * Private Constructor which the static factory will utilise.
	 */
	private Display() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		frame = new JFrame(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2);

		RenderPanel renderPanel = new RenderPanel(TOTAL_RAIN_AMOUNT);
		renderPanel.setFocusable(true);
		frame.add(renderPanel);
	}

	/**
	 * Static factory to create a display object.
	 *
	 * Static factory seemed to be the best approach for construction given that we can name the method
	 * and control access to the creation of the object and what is returned. There should only ever be a single
	 * display object actively present (Singleton) and we can control this with the static factory pattern.
	 *
	 * @return Display Object
	 */
	public static Display createDisplay() {
		if (display == null) {
			display = new Display();
		}
		return display;
	}

	/**
	 * Void method that shows enables the display to be visible to the user.
	 *
	 * Method will display the initialized display object to the user with the standard {@link #WIDTH} Width and
	 * {@link #HEIGHT} height.
	 */
	public void showDisplay() {
		frame.setVisible(true);
	}
}
