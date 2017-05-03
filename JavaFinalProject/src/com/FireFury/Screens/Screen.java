package com.FireFury.Screens;

import java.awt.event.KeyListener;

public abstract class Screen implements KeyListener{

	public void update() {}
	
	public void respondToUserInput() {}
	
	public void onEnter() {} //To be implemented in subclasses
	
}
