package com.FireFury.Tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	//Class
	public static final int TILEWIDTH = 64;
	public static final int TILEHEIGHT = 64;
	
	public static Tile[] tiles = new Tile[256];
	
	private int id;
	private BufferedImage texture;
	
	public static Tile grassCenterCenterCentral = new GrassCentralCentralCenter(0);
	public static Tile nullTile = new NullTile(1);
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
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
		default: return nullTile;
		}
	}

}
