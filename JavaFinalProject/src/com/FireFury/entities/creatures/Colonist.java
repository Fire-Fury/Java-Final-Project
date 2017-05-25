package com.FireFury.entities.creatures;

import java.awt.image.BufferedImage;

import com.FireFury.Worlds.World;

import Graphics.Assets;

public class Colonist extends Creature{
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	
	private int gender;
	private String colonistName;
	private int age;
	private int lifeSpan;

	public Colonist(World world, int x, int y, int attackVal, int defenseVal, int maxHp, String colonistName, int gender) {
		super(world, Assets.colonist1, x, y, "Colonist", attackVal, defenseVal, maxHp);
		
		this.colonistName = colonistName;
		this.gender = gender;
	}
	
	public String getName()
	{
		return colonistName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int getYearsLeft()
	{
		return lifeSpan - age;
	}
}
