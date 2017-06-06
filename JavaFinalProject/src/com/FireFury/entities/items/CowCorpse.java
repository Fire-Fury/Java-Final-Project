package com.FireFury.entities.items;

import java.awt.image.BufferedImage;

import com.FireFury.Worlds.World;

import Graphics.Assets;

public class CowCorpse extends Item{

	public CowCorpse(World world, int x, int y) {
		super(world, Assets.nullTile, x, y, "cow corpse");
		setFoodValue(100);
	}
	
}
