package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.FireFury.Utils.Handler;

public class Stats extends GuiComponent{
	
	private int width, height;
	private Handler handler;

	public Stats(int x, int y, int width, int height, Handler handler) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.handler = handler;
		
	}
	
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.fillRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
		
		g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		g2d.setColor(Color.WHITE);
		
		g2d.drawString("HP: "+ handler.getPlayer().getHp() + "/" + handler.getPlayer().getMaxHp(), getRelativeScreenX() + 5, getRelativeScreenY() + 15);
		g2d.drawString("Food: " + handler.getPlayer().getFood() + "/" + handler.getPlayer().getMaxFood(), getRelativeScreenX() + 5, getRelativeScreenY() + 30);
		g2d.drawString("Lvl: " + handler.getPlayer().getLevel() + "  XP: " + handler.getPlayer().getXp() + "/" + handler.getPlayer().getMaxXp(), getRelativeScreenX() + 5, getRelativeScreenY() + 45);
	};
	
	public void update() {
		
	};


}
