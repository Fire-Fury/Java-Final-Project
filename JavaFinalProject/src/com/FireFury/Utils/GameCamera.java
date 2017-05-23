package com.FireFury.Utils;

import com.FireFury.primary.Game;

public class GameCamera {
	
	private float xPos;
	private float yPos;
	private float xGoal, yGoal;
	private float lerp = 0.01f;
	private double acceleration = 1.2539307407882264061;
	private Handler handler;
	private int moveSpeed = 5;
	
	public GameCamera(Handler handler)
	{
		this.handler = handler;
		xPos = 0;
		yPos = 0;
		xGoal = 0;
		yGoal = 0;
	}
	
	public void update()
	{
		xPos += (xGoal - xPos) * lerp * (Game.getUpdateDeltaTime() * 0.75);
		yPos += (yGoal - yPos) * lerp * (Game.getUpdateDeltaTime() * 0.75);
		//System.out.println("xGoal: " + xGoal + "\tyGoal: " + yGoal); //Prints out xGoal and yGoals
	}

	public float getX()
	{
		return -xPos;
	}
	
	public float getY()
	{
		return -yPos;
	}
	
	public void moveBy(float dx, float dy)
	{	
		if(xGoal + dx < 0)
		{
			xGoal = 0;
			return;
		}
		else if(xGoal + dx + Game.getGameWidth() > handler.getWorld().getPixelWidth())
		{
			xGoal = handler.getWorld().getPixelWidth() - Game.getGameWidth();
			return;
		}
		if(yGoal + dy < 0)
		{
			yGoal = 0;
			return;
		}
		else if(yGoal + dy + Game.getGameHeight() > handler.getWorld().getPixelHeight())
		{
			yGoal = handler.getWorld().getPixelHeight() - Game.getGameHeight();
			return;
		}
		
		xGoal += dx * moveSpeed;
		yGoal += dy * moveSpeed;
	}
	
	public double lerp(float a, float b, double lerp)
	{
		return (a * lerp) + ((1.0 - lerp) * b);
	}

	public void focus(int x, int y) {
		if(x-(Game.getGameWidth()/2)-32 < 0)
		{
			xGoal = 0;
		}
		else
		{
			xGoal = x-(Game.getGameWidth()/2)-32;
		}
		if(y-(Game.getGameHeight()/2)-32 <0)
		{
			yGoal = 0;
		}
		else
		{
			yGoal = y-(Game.getGameHeight()/2)-32;
		}
		
		update();
		update();
		update();
	}
	
}
