import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RainDrop 
{
	private int positionX;
	private int positionY = 0;
	private int width;
	private int height;
	
	public Color myColor;
	
	public RainDrop()
	{
		positionX = (Math.abs(new Random().nextInt(500)));
		positionY = -(Math.abs(new Random().nextInt(1000)));

		width = 2;
		height = 15;
		myColor = Color.red;
		
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
		this.positionY ++;
	}
}