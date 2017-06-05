package com.FireFury.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Worlds.World;


public abstract class Entity {
	protected World world;
	private String type;
	private BufferedImage texture;
	protected int x;
	protected int y;
	
	public Entity(World world, BufferedImage img, int x, int y, String type)
	{
		this.world = world;
		this.type = type;
		this.x = x;
		this.y = y;
		this.texture = img;
	}
	
	public abstract void update();
	public abstract void render(Graphics2D g2d);

	public String getType() {
		return type;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getPixelX() {
		return x*Tile.TILEWIDTH;
	}

	public int getPixelY() {
		return y*Tile.TILEHEIGHT;
	}
	
}
