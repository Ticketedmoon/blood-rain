package com.bloodrain.display.panels;

import com.bloodrain.display.entities.RainDrop;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/** Represents a JPanel implementation.
 *  Also of the type ActionListener, implementing such methods.
 *
 * @author Shane Creedon
 * @author www.skybreak.cf
 * @version 0.0.1
 * @since 0.0.1
 */
public final class RenderPanel extends JPanel implements ActionListener {

	private transient RainDrop[] rain;

    /**
     * Constructor for RenderPanel, an extension of JPanel.
     *
     * This class hones the ability to paint the rain particles to the screen.
     * It also controls how they behave and interact within the 2D plain.
     *
     * @param raindropAmount The amount of rain objects to be created
     */
	public RenderPanel(int raindropAmount) {
		rain = new RainDrop[raindropAmount];
        new Timer(15, this).start();
		createRain();
	}

    /**
     * Generator method which populates the private array class member: {@link #rain}
     */
	private void createRain() {
		for(int i = 0; i < rain.length; i++) {
            RainDrop rainDrop = new RainDrop();
            this.rain[i] = rainDrop;
        }
	}

    /**
     * Paint component method override from parent.
     *
     * Method override from parent class.
     * Specific implementation details involve, creating a rectangle with appropriate width and height, using the
     * graphics object. This rectangle is drawn to the display. If the Y-position is greater than the display height,
     * reset the rain particle object to Y-position zero. This gives the effect of infinite rainfall.
     *
     * @param gfx Graphics object that we can use to create shapes on the dispaly
     */
	@Override
	protected void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);
		gfx.fillRect(0, 0, getWidth(), getHeight());
		
		for(RainDrop rainDrop : rain) {
            if (rainDrop.getY() > getHeight()) {
                rainDrop.setX((Math.abs(new Random().nextInt(1000))));
                rainDrop.setY(0);
                rainDrop.setSpeed(rainDrop.getNewVelocity());
            }
            rainDrop.drawToScreen(gfx);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
