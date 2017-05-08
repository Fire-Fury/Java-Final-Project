package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.FireFury.Tiles.Tile;
import com.FireFury.Worlds.World;
import com.FireFury.primary.Game;

public class PlayScreen implements Screen{
	
	private World world;
	
	public PlayScreen()
	{
		world = new World("res/worlds/world1.txt");
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < world.getWidth(); i++)
		{
			for(int j = 0; j < world.getHeight(); j++)
			{
				world.tileAt(i, j).render(g, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT);
			}
		}
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		
		switch(key.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE: return new MenuScreen();
		default: return this;
		}
	}

	@Override
	public boolean after4Seconds() {
		// TODO Auto-generated method stub
		return false;
	}

}
