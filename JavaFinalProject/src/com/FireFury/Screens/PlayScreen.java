package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.FireFury.primary.Game;

public class PlayScreen implements Screen{

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Game.getGameWidth(), Game.getGameHeight());
		g.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
		g.setColor(Color.WHITE);
		g.drawString("You are having fun!" , Game.getGameWidth()/2, Game.getGameHeight()/2);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		switch(key.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE: return new MenuScreen();
		default: return this;
		}
	}

}
