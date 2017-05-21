package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Font;
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
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
		
		g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
		g2d.setColor(Color.WHITE);
		for(int i = 0; i < messages.size(); i++)
		{
			if(messages.get(i) != null)
				g2d.drawString(messages.get(i), getRelativeScreenX() + 15, getRelativeScreenY() + 182 - i*15);
		}
	}
	
	public void updateMessages()
	{
		for(int i = 11; i < messages.size(); i++)
		{
			if(messages.get(i) != null)
			{
				messages.remove(i);
				i--;
			}
		}
	}

	public void notify(String str, Object... Params)
	{
		messages.add(0, str);
		updateMessages();
	}
}
