package com.FireFury.Worlds;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Utils;

public class World {

	int width, height;
	int spawnX, spawnY;
	double[][] heightMap;
	int[][] tiles;
	
	public World(String path)
	{
		loadWorld(path);
	}
	
	public World(double[][] heightMap, int spawnX, int spawnY)
	{
		this.heightMap = heightMap;
		this.width = heightMap[0].length;
		this.height = heightMap.length;
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
				tiles[x][y] = Utils.parseInt(tokens[(x+y * width) + 4]);
			}
		}
	}
	
	public Tile tileAt(int x, int y)
	{
		return Tile.getTile(tiles[x][y]);
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
