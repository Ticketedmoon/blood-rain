import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

public class RainDrop 
{
	private int positionX;
	private float positionY = 0;
	private int width;
	private int height;
	private float speed;
	
	public Color myColor;
	
	public RainDrop()
	{
		positionX = (Math.abs(new Random().nextInt(1000)));
		positionY = -(Math.abs(new Random().nextInt(1000)));
		Random speed = new Random();
		
		// RGB values for random multi-colored cells.
		// float r = speed.nextFloat(); 		
		// float g = speed.nextFloat();
		// float b = speed.nextFloat();

		float velocity = speed.nextFloat() + 1;
		this.speed = (Math.abs(velocity*1.3F));
		System.out.println(this.speed);
		
		width = (Math.abs(new Random().nextInt(3)));
		height = (Math.abs(new Random().nextInt(15)));
		myColor = Color.red;
		
	}
	
	public void setX(int x)
	{
		this.positionX = x;
	}
	
	public float getY()
	{
		return this.positionY;
	}
	
	public void setY(int x)
	{
		this.positionY = x;
	}

	public void drawToScreen(Graphics g)
	{
		g.setColor(myColor);
		g.fillRect(this.positionX, (int) this.positionY, this.width, this.height);
		this.positionY += this.speed;
	}
}