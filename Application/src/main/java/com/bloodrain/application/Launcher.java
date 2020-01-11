package com.bloodrain.application;

import com.bloodrain.display.DisplayConfiguration.Display;

public class Launcher {
	public static void main(String[] args) {
		Display display = Display.createDisplay();
		display.showDisplay();
	}
}
