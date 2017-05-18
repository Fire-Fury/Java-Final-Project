package com.FireFury.Worlds;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Utils;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(String path)
	{
		loadWorld(path);
	}
	
	public World(int[][] tiles)
	{
		this.tiles = tiles;
		width = tiles[0].length;
		height = tiles.length;
	}
	
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				tiles[y][x] = Utils.parseInt(tokens[(x+y * width) + 4]);
			}
		}
	}
	
	public Tile tileAt(int x, int y)
	{
		if(x >= 0 && x < tiles[0].length && y >= 0 && y < tiles.length)
			return Tile.getTile(tiles[y][x]);
		else
			return null;
	}
	
	public boolean tileExistsAt(int x, int y)
	{
		if(tileAt(y, x) == null)
		{
			return false;
		}
		return true;
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
}
