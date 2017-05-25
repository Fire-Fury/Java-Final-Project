package com.FireFury.GUI;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class GuiComponent {
	
	private int relativeScreenX;
	private int relativeScreenY;
	private boolean showComponent;
	
	public GuiComponent(int x, int y)
	{
		relativeScreenX = x;
		relativeScreenY = y;
		showComponent = true;
	}
	
	public void render(Graphics2D g2d) { };
	
	public void update() { };
	
	public int getRelativeScreenX()
	{
		return relativeScreenX;
	}
	
	public int getRelativeScreenY()
	{
		return relativeScreenY;
	}
	
	public void respondToUserInput(MouseEvent e)
	{
		//To be implemented for each sub-class
	}

}
