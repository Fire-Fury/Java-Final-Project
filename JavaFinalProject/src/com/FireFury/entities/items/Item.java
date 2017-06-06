package com.FireFury.entities.items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Worlds.World;
import com.FireFury.entities.Entity;

public class Item extends Entity{
	
	int foodValue;
	int healthValue;
	int attackboost;
	int defenseboost;

	public Item(World world, BufferedImage img, int x, int y, String type) {
		super(world, img, x, y, type);
	}
	
	@Override
	public void update() {
		
	}
	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(getTexture(), getX()*Tile.TILEWIDTH, getY()*Tile.TILEWIDTH, null);
	}
	
	public int getFoodValue() {
		return foodValue;
	}

	public void setFoodValue(int foodValue) {
		this.foodValue = foodValue;
	}

	public int getHealthValue() {
		return healthValue;
	}

	public void setHealthValue(int healthValue) {
		this.healthValue = healthValue;
	}

	public int getAttackboost() {
		return attackboost;
	}

	public void setAttackboost(int attackboost) {
		this.attackboost = attackboost;
	}

	public int getDefenseboost() {
		return defenseboost;
	}

	public void setDefenseboost(int defenseboost) {
		this.defenseboost = defenseboost;
	}

}
