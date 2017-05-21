package com.FireFury.Screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Screen {

	void update();
	
	void render(Graphics g);
	
	Screen respondToUserInput(boolean[] keysPressed);
	
	Screen respondToUserInput(MouseEvent e);

	boolean after4Seconds();
}
