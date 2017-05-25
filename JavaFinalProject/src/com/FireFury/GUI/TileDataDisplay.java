package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import com.FireFury.Utils.Handler;
import com.FireFury.primary.Game;

public class TileDataDisplay extends GuiComponent{
	
	private int width;
	private int height;
	private Handler handler;
	private boolean showComponent;
	private int selectedX, selectedY;

	public TileDataDisplay(Handler handler, int x, int y, int width, int height) {
		super(x, y);
		this.handler = handler;
		this.width = width;
		this.height = height;
		showComponent = true;
	}
	
	public void update()
	{
		selectedX = handler.getPlayScreen().getSelectedX();
		selectedY = handler.getPlayScreen().getSelectedY();
	}
	
	public void render(Graphics2D g2d)
	{
		if(showComponent)
		{
			g2d.setColor(Color.GRAY);
			g2d.fillRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
			g2d.setColor(Color.BLACK);
			g2d.drawRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
			
			g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
			g2d.setColor(Color.WHITE);
			
			g2d.drawString("X: " + handler.getPlayScreen().getSelectedX() + "   Y: " + handler.getPlayScreen().getSelectedY(), getRelativeScreenX() + 20, getRelativeScreenY() + 20);
			g2d.drawString("Tile Type: " + handler.getWorld().tileAt(selectedX, selectedY).getName(), getRelativeScreenX() + 20, getRelativeScreenY() + 40);
			if(handler.getWorld().creatureAt(selectedX, selectedY) != null)
			{
				g2d.drawString("Creature Selected: " + handler.getWorld().creatureAt(selectedX, selectedY).getType(), getRelativeScreenX() + 20, getRelativeScreenY() + 60);
			}
			else
			{
				g2d.drawString("Creature Selected: nothing", getRelativeScreenX() + 20, getRelativeScreenY() + 60);
			}
			
			//Button
			g2d.setColor(Color.GRAY);
			g2d.fillRect(getRelativeScreenX(), ((getRelativeScreenY()+height)/2)-25, 20, 50);
			g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
			g2d.setColor(Color.WHITE);
			g2d.drawString(">", getRelativeScreenX() + 6, ((getRelativeScreenY()+height)/2 + 4));
			g2d.setColor(Color.BLACK);
			g2d.drawRect(getRelativeScreenX(), ((getRelativeScreenY()+height)/2)-25, 20, 50);
		}
		else
		{
			g2d.setColor(Color.GRAY);
			g2d.fillRect(Game.getGameWidth()-20, ((getRelativeScreenY()+height)/2)-25, 20, 50);
			g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
			g2d.setColor(Color.WHITE);
			g2d.drawString("<", Game.getGameWidth()-16, ((getRelativeScreenY()+height)/2 + 6));
			g2d.setColor(Color.BLACK);
			g2d.drawRect(Game.getGameWidth()-20, ((getRelativeScreenY()+height)/2)-25, 20, 50);
		}
	}
	
	@Override
	public void respondToUserInput(MouseEvent e)
	{
		if(e.getX() > (Game.getGameWidth()-20) 
				&& (e.getY() > (((getRelativeScreenY()+height)/2)-25) 
				&& (e.getY() < (((getRelativeScreenY()+height)/2)+25))))
		{
			showComponent = true;
		}
		if((e.getX() > getRelativeScreenX() && e.getX() < getRelativeScreenX() + 20)
				&&(e.getY() > ((getRelativeScreenY()+height)/2)-25 && e.getY() < ((getRelativeScreenY()+height)/2)+25))
		{
			showComponent = false;
		}
	}

}
