package com.FireFury.Screens;

import java.awt.event.KeyEvent;

public interface Screen {

	void update();
	
	void displayOutput();
	
	Screen respondToUserInput(KeyEvent key);
}
