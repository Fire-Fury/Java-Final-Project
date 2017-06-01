package com.FireFury.entities.creatures;

import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;
import com.FireFury.primary.Game;

import Graphics.Assets;

public class Colonist extends Creature{
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	
	private int gender;
	private String colonistName;
	private int age;
	private int lifeSpan;
	
	private long lastMoveTime = 0;
	private long now;
	private Handler handler;

	public Colonist(World world, int x, int y, int attackVal, int defenseVal, int maxHp, String colonistName, int gender, Handler handler) {
		super(world, Assets.colonist1, x, y, "Colonist", attackVal, defenseVal, maxHp);
		
		this.handler = handler;
		this.colonistName = colonistName;
		this.gender = gender;
	}
	
	public String getName()
	{
		return colonistName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int getYearsLeft()
	{
		return lifeSpan - age;
	}
	
	public void moveBy(int dx, int dy)
	{
		if(x + dx < 0 || x + dx > world.getWidth() || y + dy < 0 || y + dy > world.getHeight())
			return;
		
		now = System.currentTimeMillis();
		if(now - lastMoveTime > 100)
		{
			if(world.tileAt(x + dx, y + dy).getId() == Tile.WATER_TILE)
				return;
			
			lastMoveTime = now;
			x += dx;
			y += dy;
		}
	}
}
