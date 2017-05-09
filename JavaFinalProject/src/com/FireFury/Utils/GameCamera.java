package com.FireFury.Utils;

public class GameCamera {
	
	private float xOffset;
	private float yOffset;
	private int moveSpeed;
	private int viewPortWidth;
	private int viewPortHeight;
	
	public GameCamera(float x, float y)
	{
		xOffset = x;
		yOffset = y;
		moveSpeed = 6;
	}
	
	public void update()
	{
		
	}

	public float getX()
	{
		return xOffset;
	}
	
	public float getY()
	{
		return yOffset;
	}
	
	public void moveBy(float dx, float dy)
	{
		xOffset +=  dx;
		yOffset += dy;
	}
	
	public int getMoveSpeed()
	{
		return moveSpeed;
	}
	
}
