package com.FireFury.Worlds;

import java.util.ArrayList;
import java.util.Random;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Utils;
import com.FireFury.entities.Entity;
import com.FireFury.entities.creatures.Creature;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//private Item[][] items;
	private Random gen;
	
	private ArrayList<Creature> creatures;
	
	private int selectedTileTemp = 1;
	
	public World(int[][] tiles, Random gen)
	{
		this.tiles = tiles;
		width = tiles[0].length;
		height = tiles.length;
		creatures = new ArrayList<Creature>();
		this.gen = gen;
	}
	
	public void updateEntities()
	{
		for(Creature c: creatures)
		{
			c.update();
		}
	}
	
	public void addAtEmptyLocation(Creature c)
	{
		int x,y;
		do
		{
			x = (int)(gen.nextDouble() * width);
			y = (int)(gen.nextDouble() * height);
		}while(tileAt(x, y).equals(Tile.waterTile) || tileAt(x, y).equals(Tile.plateauTile) || creatureAt(x,y) != null);
		
		c.setX(x);
		c.setY(y);
		creatures.add(c);
		
	}
	
	public Creature creatureAt(int x, int y){
		for (Creature c : creatures){
			if (c.getX() == x && c.getY() == y)
				return c;
		}
		return null;
	}
	
	public Tile tileAt(int x, int y)
	{
		if(x >= 0 && x < tiles[0].length && y >= 0 && y < tiles.length)
			return Tile.getTile(tiles[y][x]);
		else
			return Tile.nullTile;
	}
	
	public boolean tileExistsAt(int x, int y)
	{
		if(tileAt(y, x) == null)
		{
			return false;
		}
		return true;
	}
	
	public void replaceTile(int replacement, int x, int y)
	{
		tiles[y][x] = replacement;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getPixelWidth()
	{
		return width*Tile.TILEWIDTH;
	}
	
	public int getPixelHeight()
	{
		return height*Tile.TILEHEIGHT;
	}
	
	public int getNumberOfColonists()
	{
		int total = 0;
		for(Creature c: creatures)
		{
			if(c.getType().equals("colonist"))
			{
				total++;
			}
		}
		
		return total;
	}
}
