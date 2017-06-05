package com.FireFury.entities;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;
import com.FireFury.entities.creatures.Cow;
//import com.FireFury.entities.creatures.Colonist;
import com.FireFury.entities.creatures.Creature;
import com.FireFury.entities.creatures.Player;
import com.FireFury.entities.creatures.Tree;

public class EntityFactory {
	
	private World world;
	private Handler handler;
	
	public EntityFactory(World world, Handler handler)
	{
		this.world = world;
		this.handler = handler;
	}
	
	public Player newColonist()
	{
		Player colonist1 = new Player(world, 0, 0, 20, 10, 100, "Player", Player.MALE, handler);
		world.addAtEmptyLocation(colonist1);

		return colonist1;
	}
	
	public Cow newCow()
	{
		Cow cow = new Cow(world, 0, 0, handler);
		world.addAtEmptyLocation(cow);
		
		return cow;
	}
	
	public void addTrees()
	{
		for(int i = 0; i < world.getWidth(); i++)
		{
			for(int j = 0; j < world.getHeight(); j++)
			{
				if(world.tileAt(i, j).equals(Tile.dirtTile) && Math.random() < .127)
				{
					world.replaceTile(12, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.forestTile) && Math.random() < .634)
				{
					world.replaceTile(15, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.plateauTile) && Math.random() < .174)
				{
					world.replaceTile(14, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.sandTile) && Math.random() < .0002)
				{
					world.replaceTile(13, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.grassCenterCenterCentral) && Math.random() < .182)
				{
					world.replaceTile(8, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.stoneTile) && Math.random() < .138)
				{
					world.replaceTile(11, i, j);
				}
			}
		}
		
	}

}
