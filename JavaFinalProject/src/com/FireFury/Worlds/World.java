package com.FireFury.Worlds;

public class World {

	int width, height;
	int spawnX, spawnY;
	double[][] heightMap;
	//Tile[][] tiles;
	
	public World(double[][] heightMap, int spawnX, int spawnY)
	{
		this.heightMap = heightMap;
		this.width = heightMap[0].length;
		this.height = heightMap.length;
	}
	
}
