package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Console extends GuiComponent{
	
	private List<String> messages = new ArrayList<String>();
	private int width;
	private int height;

	public Console(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g2d)
	{
		g2d.setColor(Color.GRAY);
		g2d.fillRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
	}

}
