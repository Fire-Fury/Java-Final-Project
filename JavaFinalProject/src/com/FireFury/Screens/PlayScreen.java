package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.GameCamera;
import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;
import com.FireFury.primary.Game;

public class PlayScreen implements Screen{
	
	private World world;
	private GameCamera camera;
	private Handler handler;
	
	public PlayScreen()
	{
		handler = new Handler(this);
		world = new World("res/worlds/world1.txt");
		handler.setWorld(world);
		camera = new GameCamera(handler);
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
		
		//The complex statements of the nested for loop is to ensure that we only render what is necessary. For example, if a tile is outside
		//of out viewing box (camera) we don't need to render it to the frame.
		for(int i = (int)(-camera.getX() / Tile.TILEWIDTH); i < (int)((-camera.getX() + Game.getGameWidth())/Tile.TILEWIDTH)+1; i++)
			//Insert +1 and -1 to see results
		{
			for(int j = (int)(-camera.getY() / Tile.TILEHEIGHT); j < (int)((-camera.getY() + Game.getGameHeight())/Tile.TILEWIDTH)+1; j++)
			{
				if(world.tileExistsAt(i, j))
				{
					world.tileAt(i, j).render(g2d, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT);
				}
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
			camera.moveBy(0, -1);
		}
		else if(keysPressed[KeyEvent.VK_DOWN])
		{
			camera.moveBy(0, 1);
		}
		else if(keysPressed[KeyEvent.VK_LEFT])
		{
			camera.moveBy(-1, 0);
		}
		else if(keysPressed[KeyEvent.VK_RIGHT])
		{
			camera.moveBy(1, 0);
		}
		
		return this;
	}

	@Override
	public boolean after4Seconds() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Getters and Setters
	public GameCamera getCamera()
	{
		return camera;
	}

}
