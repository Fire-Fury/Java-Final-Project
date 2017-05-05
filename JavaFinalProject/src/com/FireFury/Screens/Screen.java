package com.FireFury.Screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface Screen {

	void update();
	
	void render(Graphics g);
	
	Screen respondToUserInput(KeyEvent key);
}
