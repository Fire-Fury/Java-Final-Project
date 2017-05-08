package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.FireFury.primary.Game;

public class LoadingScreen implements Screen{
	
	public long timeStart = System.currentTimeMillis(); 

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		String dots = getDots();
		
		g.setColor(Color.LIGHT_GRAY );
		g.fillRect(0, 0, Game.getGameWidth(), Game.getGameHeight());
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Comic-Sans", Font.PLAIN, 24));
		g.drawString("Loading " + dots, Game.getGameWidth()/2, Game.getGameHeight()/2 );
		
		
	}

	private String getDots()
	{
		long time = System.currentTimeMillis()%3000;
		if(time < 1000)
		{
			return ".";
		}
		else if(time < 2000)
		{
			return "..";
		}
		else
		{
			return "...";
		}
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		// TODO Auto-generated method stub
		return this;
	}
	
	public boolean after4Seconds()
	{
		if(System.currentTimeMillis() - 4000 >= timeStart)
		{
			return true;
		}
		return false;
	}

}
