package com.FireFury.entities;

import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;
import com.FireFury.entities.creatures.Colonist;
import com.FireFury.entities.creatures.Creature;
import com.FireFury.entities.creatures.Tree;

public class EntityFactory {
	
	private World world;
	private Handler handler;
	
	public EntityFactory(World world, Handler handler)
	{
		this.world = world;
	}
	
	public Colonist newColonist()
	{
		Colonist colonist = new Colonist(world, 0, 0, 10, 10, 100, "Ben Balster", Colonist.MALE, handler);
		world.addAtEmptyLocation(colonist);

		return colonist;
	}
	
	public void addTrees()
	{
		Tree tree = new Tree(world, 0, 0, "Tree", 3, 10);
		//add at certain instances of each tile
		
		
	}

}
