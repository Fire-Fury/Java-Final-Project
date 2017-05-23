package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.FireFury.Utils.Handler;

public class TileDataDisplay extends GuiComponent{
	
	private int width;
	private int height;
	private Handler handler;

	public TileDataDisplay(Handler handler, int x, int y, int width, int height) {
		super(x, y);
		this.handler = handler;
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
		
		g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		g2d.setColor(Color.WHITE);
		
		g2d.drawString("X: " + handler.getPlayScreen().getSelectedX() + "   Y: " + handler.getPlayScreen().getSelectedY(), getRelativeScreenX() + 20, getRelativeScreenY() + 20);
		g2d.drawString("Tile Type: " + handler.getWorld().tileAt(handler.getPlayScreen().getSelectedX(), handler.getPlayScreen().getSelectedY()).getName(), getRelativeScreenX() + 20, getRelativeScreenY() + 40);
	}

}
