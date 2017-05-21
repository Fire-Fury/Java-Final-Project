package com.FireFury.entities;

import com.FireFury.Worlds.World;
import com.FireFury.entities.creatures.Colonist;
import com.FireFury.entities.creatures.Creature;

public class EntityFactory {
	
	private World world;
	
	public EntityFactory(World world)
	{
		this.world = world;
	}
	
	public Colonist newColonist()
	{
		Colonist colonist = new Colonist(world, 0, 0, 10, 10, 100, "Ben Balster", Colonist.MALE);
		world.addAtEmptyLocation(colonist);

		return colonist;
	}

}
