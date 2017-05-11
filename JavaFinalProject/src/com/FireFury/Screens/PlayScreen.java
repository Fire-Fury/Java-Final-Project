package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.GameCamera;
import com.FireFury.Worlds.World;
import com.FireFury.primary.Game;

public class PlayScreen implements Screen{
	
	private World world;
	private GameCamera camera;
	
	public PlayScreen()
	{
		world = new World("res/worlds/world1.txt");
		camera = new GameCamera(0, 0);
	}

	@Override
	public void update() {
		camera.update();
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.translate(camera.getX(), camera.getY());
		//Camera has been translated
		
		for(int i = 0; i < world.getWidth(); i++)
		{
			for(int j = 0; j < world.getHeight(); j++)
			{
				world.tileAt(i, j).render(g, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT);
			}
		}
		
		g2d.translate(-camera.getX(), -camera.getY());
		//Camera is at original position
		
	}

	@Override
	public Screen respondToUserInput(boolean[] keysPressed) {
		
		if(keysPressed[KeyEvent.VK_ESCAPE])
		{
			return new MenuScreen();
		}
		else if(keysPressed[KeyEvent.VK_UP])
		{
			camera.moveBy(0, 1);
		}
		else if(keysPressed[KeyEvent.VK_DOWN])
		{
			camera.moveBy(0, -1);
		}
		else if(keysPressed[KeyEvent.VK_LEFT])
		{
			camera.moveBy(1, 0);
		}
		else if(keysPressed[KeyEvent.VK_RIGHT])
		{
			camera.moveBy(-1, 0);
		}
		
		return this;
	}

	@Override
	public boolean after4Seconds() {
		// TODO Auto-generated method stub
		return false;
	}

}
