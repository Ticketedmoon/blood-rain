import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

public class RainDrop 
{
	private int positionX;
	private int positionY = 0;
	private int width;
	private int height;
	private float speed;
	
	public Color myColor;
	
	public RainDrop()
	{
		positionX = (Math.abs(new Random().nextInt(500)));
		positionY = -(Math.abs(new Random().nextInt(1000)));
		Random rand = new Random();
		
		// RGB values for random multi-colored cells.
		// float r = rand.nextFloat(); 		
		// float g = rand.nextFloat();
		// float b = rand.nextFloat();

		this.speed = (Math.abs(new Random().nextInt(3)));
		
		width = (Math.abs(new Random().nextInt(3)));
		height = (Math.abs(new Random().nextInt(15)));
		myColor = Color.RED;
		
	}
	
	public void setX(int x)
	{
		this.positionX = x;
	}
	
	public int getY()
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
		g.fillRect(this.positionX, this.positionY, this.width, this.height);
		this.positionY += this.speed;
	}
}