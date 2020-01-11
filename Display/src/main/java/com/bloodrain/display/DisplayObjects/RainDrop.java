package com.bloodrain.display.DisplayObjects;

import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;
import org.apache.log4j.Logger;

public class RainDrop {

	private static final Logger logger = Logger.getLogger(RainDrop.class);

	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private float speed;
	private Color myColor;
	
	public RainDrop() {
		float velocity = new Random().nextFloat() + 1;
		positionX = (Math.abs(new Random().nextInt(1000)));
		positionY = -(Math.abs(new Random().nextInt(1000)));
		width = (Math.abs(new Random().nextInt(3)));
		height = (Math.abs(new Random().nextInt(15)));
		speed = (Math.abs(velocity*1.3F));
		myColor = Color.red;

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

	public void drawToScreen(Graphics g) {
		g.setColor(myColor);
		g.fillRect(this.positionX, this.positionY, this.width, this.height);
		this.positionY += this.speed;
	}
}