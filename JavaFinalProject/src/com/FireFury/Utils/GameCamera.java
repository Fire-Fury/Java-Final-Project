package com.FireFury.Utils;

import com.FireFury.primary.Game;

public class GameCamera {
	
	private float xPos;
	private float yPos;
	private int moveSpeed;
	private float xGoal, yGoal;
	private float lerp = 0.01f;
	private double acceleration = 1.2539307407882264061;
	
	public GameCamera(float x, float y)
	{
		xPos = x;
		yPos = y;
		xGoal = Game.getGameWidth() / 2;
		yGoal = Game.getGameHeight() / 2;
		moveSpeed = 6;
	}
	
	public void update()
	{
		xPos += (xGoal - xPos) * lerp * Game.getUpdateDeltaTime() * acceleration;
		yPos += (yGoal - yPos) * lerp * Game.getUpdateDeltaTime() * acceleration;
	}

	public float getX()
	{
		return xPos;
	}
	
	public float getY()
	{
		return yPos;
	}
	
	public void moveBy(float dx, float dy)
	{	
		xGoal += dx;
		yGoal += dy;
	}
	
	public double lerp(float a, float b, double lerp)
	{
		return (a * lerp) + ((1.0 - lerp) * b);
	}
	
	public int getMoveSpeed()
	{
		return moveSpeed;
	}
	
}
