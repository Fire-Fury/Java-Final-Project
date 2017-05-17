package com.FireFury.GUI;

import java.awt.Graphics2D;

public class GuiComponent {
	
	private int relativeScreenX;
	private int relativeScreenY;
	
	public GuiComponent(int x, int y)
	{
		relativeScreenX = x;
		relativeScreenY = y;
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

}
