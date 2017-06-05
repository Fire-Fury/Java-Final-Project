package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.FireFury.primary.Game;

public class Console extends GuiComponent{
	
	private List<String> messages = new ArrayList<String>();
	private int width;
	private int height;
	private boolean showComponent;

	public Console(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
		showComponent = true;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g2d)
	{
		if(showComponent)
		{
			g2d.setColor(Color.GRAY);
			g2d.fillRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
			g2d.setColor(Color.BLACK);
			g2d.drawRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
			
			g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
			g2d.setColor(Color.WHITE);
			
			g2d.drawString("Things that are happening in the world:", getRelativeScreenX() + 15, getRelativeScreenY()+15);
			
			for(int i = 0; i < messages.size(); i++)
			{
				if(messages.get(i) != null)
					g2d.drawString(messages.get(i), getRelativeScreenX() + 25, getRelativeScreenY() + 182 - i*15);
			}
			
			//Button
			g2d.setColor(Color.GRAY);
			g2d.fillRect(getRelativeScreenX(), ((getRelativeScreenY()+Game.getGameHeight())/2)-25, 20, 50);
			g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
			g2d.setColor(Color.WHITE);
			g2d.drawString(">", getRelativeScreenX() + 6, ((getRelativeScreenY()+Game.getGameHeight())/2 + 4));
			g2d.setColor(Color.BLACK);
			g2d.drawRect(getRelativeScreenX(), ((getRelativeScreenY()+Game.getGameHeight())/2)-25, 20, 50);
		}
		else
		{
			g2d.setColor(Color.GRAY);
			g2d.fillRect(Game.getGameWidth()-20, ((getRelativeScreenY()+Game.getGameHeight())/2)-25, 20, 50);
			g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
			g2d.setColor(Color.WHITE);
			g2d.drawString("<", Game.getGameWidth()-16, ((getRelativeScreenY()+Game.getGameHeight())/2 + 6));
			g2d.setColor(Color.BLACK);
			g2d.drawRect(Game.getGameWidth()-20, ((getRelativeScreenY()+Game.getGameHeight())/2)-25, 20, 50);
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

	public void notify(String message, Object... params)
	{
		messages.add(0, String.format(message, params));
		updateMessages();
	}
	
	@Override
	public void respondToUserInput(MouseEvent e)
	{
		if(e.getX() > (Game.getGameWidth()-20) 
				&& (e.getY() > (((getRelativeScreenY()+Game.getGameHeight())/2)-25) 
				&& (e.getY() < (((getRelativeScreenY()+Game.getGameHeight())/2)+25))))
		{
			showComponent = true;
		}
		if((e.getX() > getRelativeScreenX() && e.getX() < getRelativeScreenX() + 20)
				&&(e.getY() > ((getRelativeScreenY()+Game.getGameHeight())/2)-25 && e.getY() < ((getRelativeScreenY()+Game.getGameHeight())/2)+25))
		{
			showComponent = false;
		}
	}
}
