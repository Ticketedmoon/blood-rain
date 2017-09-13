import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Display 
{
	public JFrame frame;
	public RenderPanel renderPanel;
	
	public Display()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		renderPanel = new RenderPanel();
		renderPanel.setFocusable(true);
		
		frame = new JFrame("Blood Rain -- Created by Shane");
		frame.setSize(500, 520);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2 );
		frame.setVisible(true);
		
		frame.add(renderPanel);
	
	}
}
