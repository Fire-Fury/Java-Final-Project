package com.FireFury.entities.creatures;

import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;

import Graphics.Assets;

public class Cow extends Creature {
	private Handler handler;
	private long now, lastTime;

	public Cow(World world, int x, int y, Handler handler) {
		super(world, Assets.cow, x, y, "cow", 3, 10, 50); // atk, def, hp
		this.handler = handler;
		lastTime = 0;
		now = System.currentTimeMillis();
		
	}
	
	@Override
	public void update() {
		takeAction();
	}
	
	public void takeAction()
	{
		double decider = Math.random();
		if(decider < 0.4)
		{
			wander();
		}
	}
	
	public void wander()
	{
		int dx;
		int dy;
		do
		{
			dx = (int)(Math.random() * 3) - 1;
			dy = (int)(Math.random() * 3) - 1;
		}while(world.tileAt(x+dx, y+dy).getId() == Tile.PLATEAU_TILE || world.tileAt(x+dx, y+dy).getId() == Tile.WATER_TILE);
		
		super.moveBy(dx, dy, 1000);
	}

}
