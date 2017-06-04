package com.FireFury.entities.creatures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Worlds.World;
import com.FireFury.entities.Entity;

public class Creature extends Entity{
	private int attackVal;
	private int defenseVal;
	private int hp;
	private int maxHp;
	protected int xp;
	protected int maxXp;
	protected int level;

	public Creature(World world, BufferedImage img, int x, int y, String type, int attackVal, int defenseVal, int maxHp) {
		super(world, img, x, y, type);
		this.attackVal = attackVal;
		this.defenseVal = defenseVal;
		this.maxHp = maxHp;
		this.hp = maxHp;
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(getTexture(), getX()*Tile.TILEWIDTH, getY()*Tile.TILEWIDTH, null);
		
	}

	public int getAttackVal() {
		return attackVal;
	}

	public void setAttackVal(int attackVal) {
		this.attackVal = attackVal;
	}

	public int getDefenseVal() {
		return defenseVal;
	}

	public void setDefenseVal(int defenseVal) {
		this.defenseVal = defenseVal;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public int getMaxHp()
	{
		return maxHp;
	}
	
	public void modifyHp(int amt)
	{
		hp += amt;
		if(hp > maxHp)
		{
			hp = maxHp;
		}
		if(hp < 1)
		{
			//creature dies
		}
	}
	
	public int getXp()
	{
		return xp;
	}
	
	public int getMaxXp()
	{
		return maxXp;
	}
	
	public void modifyXp(int amt)
	{
		xp += amt;
		if(xp > maxXp)
		{
			xp = xp - maxXp;
			maxXp = (int)(maxXp * (Math.log10(maxXp) / Math.log10(3))); // calculate leveling algoritm;
		}
	}
	
	public int getLevel()
	{
		return level;
	}
	

}
