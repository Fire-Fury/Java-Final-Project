package com.FireFury.entities.creatures;

import java.awt.image.BufferedImage;

import com.FireFury.Tiles.Tile;
import com.FireFury.Utils.Handler;
import com.FireFury.Worlds.World;
import com.FireFury.primary.Game;

import Graphics.Assets;

public class Player extends Creature{
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	
	private int gender;
	private String colonistName;
	private int age;
	private int lifeSpan;
	private int food;
	private int maxFood;
	
	private long lastMoveTime = 0;
	private long now;
	private Handler handler;

	public Player(World world, int x, int y, int attackVal, int defenseVal, int maxHp, String colonistName, int gender, Handler handler) {
		super(world, Assets.colonist1, x, y, "Colonist", attackVal, defenseVal, maxHp);
		
		this.handler = handler;
		this.colonistName = colonistName;
		this.gender = gender;
		this.xp = 0;
		this.maxXp = 10;
		this.maxFood = 200;
		this.food = maxFood;
	}

	
	public String getName()
	{
		return colonistName;
	}
	
	public void moveBy(int dx, int dy)
	{
		if(super.moveBy(dx, dy, 100)) // 100 is the delta time
			modifyFoodAmount(-1);
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int getYearsLeft()
	{
		return lifeSpan - age;
	}
	
	public int getFood()
	{
		return food;
	}
	
	public int getMaxFood()
	{
		return maxFood;
	}
	
	public void modifyFoodAmount(int amt)
	{
		food += amt;
		if(food > maxFood)
		{
			maxFood = (int)(maxFood + (0.5)*(amt));
			food = maxFood;
			handler.getGuiManager().getConsole().notify("Your stomach expanded");
		}
	}
	
	public void meleeAttack(Creature other)
	{
		int amt = (int)(this.getAttackValue()*Math.random()) - Math.max(0, (int)(0.5*Math.random()*other.getDefenseValue()));
		other.modifyHp(-amt);
		this.modifyHp((int)(-0.5*amt));
		handler.getGuiManager().getConsole().notify("You attack a %s for %d", other.getType(), amt);
		handler.getGuiManager().getConsole().notify("The %s attacks you for %d", other.getType(), (-0.5*amt));
		
	}
}
