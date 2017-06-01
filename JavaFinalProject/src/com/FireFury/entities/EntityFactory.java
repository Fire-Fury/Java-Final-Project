package com.FireFury.entities;

import com.FireFury.Tiles.Tile;
import com.FireFury.Worlds.World;
import com.FireFury.entities.creatures.Colonist;
import com.FireFury.entities.creatures.Creature;
import com.FireFury.entities.creatures.Tree;

public class EntityFactory {
	
	private World world;
	
	public EntityFactory(World world)
	{
		this.world = world;
	}
	
	public Colonist newColonist()
	{
		Colonist colonist = new Colonist(world, 0, 0, 10, 10, 100, "Ben Balster", Colonist.MALE, null);
		world.addAtEmptyLocation(colonist);

		return colonist;
	}
	
	public void addTrees()
	{
		for(int i = 0; i < world.getWidth(); i++)
		{
			for(int j = 0; j < world.getHeight(); j++)
			{
				if(world.tileAt(i, j).equals(Tile.dirtTile))
				{
					world.replaceTile(8, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.forestTile))
				{
					world.replaceTile(7, i, j);
				}
				else if(world.tileAt(i, j).equals(Tile.plateauTile))
				{
					
				}
				else if(world.tileAt(i, j).equals(Tile.sandTile))
				{
					
				}
				else if(world.tileAt(i, j).equals(Tile.grassCenterCenterCentral))
				{
					
				}
				else if(world.tileAt(i, j).equals(Tile.stoneTile))
				{
					
				}
			}
		}
		
	}

}
