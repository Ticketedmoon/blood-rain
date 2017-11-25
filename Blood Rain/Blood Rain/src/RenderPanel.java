import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RenderPanel extends JPanel implements ActionListener
{	
	RainDrop [] rain = new RainDrop[400];
	Timer t = new Timer(3, this);
	
	public RenderPanel()
	{
		createRain();
	}
	
	public void createRain()
	{
		for(int i = 0; i < rain.length; i++)
			this.rain[i] = new RainDrop();
	}
	
	public void paintComponent(Graphics gfx)
	{
		super.paintComponent(gfx);
		gfx.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(RainDrop r : rain)
		{
			if(r.getY() > this.getHeight())
			{
				r.setX((Math.abs(new Random().nextInt(1000))));
				r.setY(0);
			}
			
			r.drawToScreen(gfx);	
		}
		t.start();		
	}

	public void actionPerformed(ActionEvent e) 
	{
		repaint();
		
	}


}
