package com.FireFury.Tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	//Class
	public static final int TILEWIDTH = 32;
	public static final int TILEHEIGHT = 32;
	
	public static Tile[] tiles = new Tile[256];
	
	private int id;
	private BufferedImage texture;
	private String name;
	
	public static Tile grassCenterCenterCentral = new GrassCentralCentralCenter(0);
	public static final int GRASS_TILE = 0;
	public static Tile nullTile = new NullTile(1);
	public static final int NULL_TILE = 1;
	public static Tile waterTile = new WaterTile(2);
	public static final int WATER_TILE = 2;
	public static Tile stoneTile = new StoneTile(3);
	public static final int STONE_TILE = 3;
	public static Tile dirtTile = new DirtTile(4);
	public static final int DIRT_TILE = 4;
	public static Tile sandTile = new SandTile(5);
	public static final int SAND_TILE = 5;
	public static Tile plateauTile = new PlateauTile(6);
	public static final int PLATEAU_TILE = 6;
	public static Tile forestTile = new ForestTile(7);
	public static final int FOREST_TILE = 7;
	public static Tile grassTreeTile = new GrassTreeTile(8);
	public static final int GRASS_TREE_TILE = 8;
	public static Tile waterTreeTile = new WaterTreeTile(10);
	public static final int WATER_TREE_TILE = 10;
	public static Tile stoneTreeTile = new StoneTreeTile(11);
	public static final int STONE_TREE_TILE = 11;
	public static Tile dirtTreeTile = new DirtTreeTile(12);
	public static final int DIRT_TREE_TILE = 12;
	public static Tile sandTreeTile = new SandTreeTile(13);
	public static final int SAND_TREE_TILE = 13;
	public static Tile plateauTreeTile = new mountainTreeTile(14);
	public static final int PLATEAU_TREE_TILE = 14;
	public static Tile forestTreeTile = new ForestTreeTile(15);
	public static final int FOREST_TREE_TILE = 15;
	
	
	public Tile(BufferedImage texture, int id, String name)
	{
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
		this.name = name;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g2d, int x, int y)
	{
		g2d.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getId()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public static Tile getTile(int id)
	{
		switch(id)
		{
		case 0: return grassCenterCenterCentral;
		case 1: return nullTile;
		case 2: return waterTile;
		case 3: return stoneTile;
		case 4:	return dirtTile;
		case 5: return sandTile;
		case 6: return plateauTile;
		case 7: return forestTile;
		case 8: return grassTreeTile;
		case 9: return nullTile;
		case 10: return waterTreeTile;
		case 11: return stoneTreeTile;
		case 12: return dirtTreeTile;
		case 13: return sandTreeTile;
		case 14: return plateauTreeTile;
		case 15: return forestTreeTile;
		default: return nullTile;
		}
	}
	
	public boolean equals(Tile other)
	{
		if(this.id == other.getId())
		{
			return true;
		}
		return false;
	}
	
	public String getName()
	{
		return name;
	}

}
