package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.FireFury.primary.Game;

public class MenuScreen implements Screen{

	@Override
	public void update() { 
		
	}

	@Override
	public void render(Graphics g) { 
		g.setColor(Color.RED);
		g.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
		g.fillRect(0, 0, Game.getGameWidth(), Game.getGameHeight());
		g.setColor(Color.WHITE);
		g.drawString("Menu Screen", Game.getGameWidth()/2 - 50, Game.getGameHeight()/2);
		g.drawString("Press [Enter] to play!", Game.getGameWidth()/2 - 100, Game.getGameHeight()/2 + 20);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch(key.getKeyCode())
		{
			case KeyEvent.VK_ENTER: return new PlayScreen(); 
			default: return this;
		}
	}

	@Override
	public boolean after4Seconds() {
		// TODO Auto-generated method stub
		return false;
	}

}
