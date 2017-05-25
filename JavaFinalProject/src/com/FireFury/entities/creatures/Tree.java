package com.FireFury.entities.creatures;

import java.awt.image.BufferedImage;

import com.FireFury.Worlds.World;

import Graphics.Assets;

public class Tree extends Creature{

	public Tree(World world, int x, int y, String type, int defenseVal, int maxHp) {
		super(world, Assets.tree , x, y, "Tree", 0, defenseVal, maxHp);
	}
	
	
}
