package com.FireFury.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.FireFury.GUI.GuiManager;
import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.GameCamera;
import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;
import com.FireFury.Worlds.WorldBuilder;
import com.FireFury.entities.EntityFactory;
//import com.FireFury.entities.creatures.Colonist;
import com.FireFury.entities.creatures.Creature;
import com.FireFury.entities.creatures.Player;
import com.FireFury.primary.Game;

public class PlayScreen implements Screen{
	
	private World world;
	private GameCamera camera;
	private Handler handler;
	private WorldBuilder worldBuilder;
	private GuiManager guiManager;
	private Player player;
	
	private int selectedX = -1;
	private int selectedY = -1;
	
	public PlayScreen()
	{
		handler = new Handler(this);
		worldBuilder = new WorldBuilder();
		//worldBuilder = new WorldBuilder(0.99, 0.99, 0.99, 0.99); // seeded generation
		//worldBuilder = new WorldBuilder(0.3, 0.5, 0.9, 0); // seeded generation
		// Seed 12345 : largely an ocean world, not too interesting
		world = worldBuilder.createWorld().build();
		handler.setWorld(world);
		camera = new GameCamera(handler);
		guiManager = new GuiManager(handler);
		handler.setGuiManager(guiManager);
		
		EntityFactory factory = new EntityFactory(world, handler);
		createCreatures(factory);
		handler.setPlayer(player);
		createItems(factory);
		
		camera.focus(player.getPixelX(), player.getPixelY());
	}
	
	public void createCreatures(EntityFactory factory)
	{
		player = factory.newColonist();
		factory.addTrees();
		
		for(int i = 0; i < 100; i++)
		{
			factory.newCow();
		}
	}
	
	public void createItems(EntityFactory factory)
	{
		
	}
	
	public void selectTile(int x, int y)
	{
		if(world.creatureAt(x, y) != null)
		{
			//console says creature type: each has its own return based on general and specific details ie health; age; moves; hunger; good or bad etc
			//creature.actions ~ buttons in console listed based on return of creature.actions(none is applicable)
			//
		}
		if(world.tileExistsAt(x, y))
		{
			guiManager.getConsole().notify("Selected: " + x + "," + y);
			selectedX = x;
			selectedY = y;
		}
	}

	@Override
	public void update() {
		camera.update();
		guiManager.update();
		world.updateEntities();
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
				Creature c = world.creatureAt(i, j);
				if(c != null)
				{
					c.render(g2d);
				}
			}
		}
		renderSelectedTile(g2d);
		
		g2d.translate(-camera.getX(), -camera.getY());
		//Camera is at original position
		//Do things here if you want it to remain static even while player is moving.
		guiManager.render(g2d);
	}
	
	public void renderSelectedTile(Graphics2D g2d)
	{
		if(selectedX >= 0 && selectedX < world.getWidth() && selectedY >= 0 && selectedY < world.getHeight())
		{
			g2d.setColor(new Color(109, 242, 254));
			g2d.drawRect(selectedX*Tile.TILEWIDTH, selectedY*Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
			
		}
	}

	@Override
	public Screen respondToUserInput(boolean[] keysPressed) {
		
		if(keysPressed[KeyEvent.VK_ESCAPE])
		{
			return new MenuScreen();
		}
		else if(keysPressed[KeyEvent.VK_UP])
		{
			player.moveBy(0, -1);
		}
		else if(keysPressed[KeyEvent.VK_DOWN])
		{
			player.moveBy(0, 1);
		}
		else if(keysPressed[KeyEvent.VK_LEFT])
		{
			player.moveBy(-1, 0);
		}
		else if(keysPressed[KeyEvent.VK_RIGHT])
		{
			player.moveBy(1, 0);
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

	@Override
	public Screen respondToUserInput(MouseEvent e) {
		guiManager.respondToUserInput(e);
		if(e.getX() < Game.getGameWidth()-320)
		{
			selectTile((int)(((e.getX() + camera.getTrueX())/Tile.TILEWIDTH)),
					   (int)(((e.getY() + camera.getTrueY())/Tile.TILEHEIGHT)));
		}
		
		
		return this;
	}
	
	public int getSelectedX()
	{
		return selectedX;
	}
	
	public int getSelectedY()
	{
		return selectedY;
	}

}
