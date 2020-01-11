package com.bloodrain.display.DisplayPanels;

import com.bloodrain.display.DisplayObjects.RainDrop;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RenderPanel extends JPanel implements ActionListener {

	private RainDrop[] rain;
	private Timer timer;
	
	public RenderPanel(int raindropAmount) {
		this.rain = new RainDrop[raindropAmount];
		this.timer = new Timer(3, this);
		createRain();
	}
	
	private void createRain() {
		for(int i = 0; i < rain.length; i++)
			this.rain[i] = new RainDrop();
	}
	
	protected void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);
		gfx.fillRect(0, 0, getWidth(), getHeight());
		
		for(RainDrop r : rain) {
			if(r.getY() > getHeight()) {
				r.setX((Math.abs(new Random().nextInt(1000))));
				r.setY(0);
			}
			r.drawToScreen(gfx);	
		}

		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
