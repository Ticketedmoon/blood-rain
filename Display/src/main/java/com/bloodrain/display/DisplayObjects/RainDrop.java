package com.bloodrain.display.DisplayObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/** Represents a raindrop.
 *
 * @author Shane Creedon
 * @author www.skybreak.cf
 * @version 0.0.1
 * @since 0.0.1
 */
public class RainDrop {

	// Rain drop private class member attributes
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private double speed;
	private Color myColor;

	/**
	 * Raindrop constructor.
	 *
	 * Generates a raindrop with preset attributes, some randomised between some range.
	 */
	public RainDrop() {
		positionX = (Math.abs(new Random().nextInt(1000)));
		positionY = -(Math.abs(new Random().nextInt(1000)));
		width = (Math.abs(new Random().nextInt(2)));
		height = (Math.abs(new Random().nextInt(10)));
		speed = getNewVelocity();
		myColor = Color.red;
	}

	/**
	 * Method which returns a new velocity for this raindrop.
	 *
	 * Uses ThreadLocalRandom to generate a random float between 0 - 1 and multiple such a value by 5.
	 *
	 * @return Returns a double representing a new velocity.
	 */
	public double getNewVelocity() {
		float velocity = ThreadLocalRandom.current().nextFloat() + 1;
		return Math.abs(velocity * 4F);
	}

	public void setSpeed(double speed) {
		this.speed = speed;
    }
	
	public void setX(int positionX) {
		this.positionX = positionX;
	}
	
	public float getY() {
		return this.positionY;
	}
	
	public void setY(int positionY) {
		this.positionY = positionY;
	}

	/**
	 * Sets the colour and draws the rectangle rain particle to the screen.
	 *
	 * @param g Graphics object that we can use to show colour and iterate the position of the rain particle.
	 */
	public void drawToScreen(Graphics g) {
		g.setColor(myColor);
		g.fillRect(this.positionX, this.positionY, this.width, this.height);
		this.positionY += (int) Math.ceil(this.speed);
		this.positionX += (int) (Math.floor(this.speed / 7));
	}
}