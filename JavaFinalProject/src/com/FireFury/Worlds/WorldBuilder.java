package com.FireFury.Worlds;

public class WorldBuilder {

	private double[][] heights = new double[513][513];
	
	public WorldBuilder() //random generation
	{
		heights[0][0] = Math.random();
		heights[0][heights[0].length-1] = Math.random();
		heights[heights.length-1][0] = Math.random();
		heights[heights.length-1][heights[0].length-1] = Math.random();
	}
	
	public WorldBuilder(double a, double b, double c, double d) // seeded generation
	{
		heights[0][0] = a;
		heights[0][heights[0].length-1] = c;
		heights[heights.length-1][0] = b;
		heights[heights.length-1][heights[0].length-1] = d;
	}
	
	public double[][] buildWorld()
	{
		DiamondStep(0, 0, heights[0].length-1, heights.length-1);
		return heights;
	}
	
	private void SquareStep(double C, int rX, int rY, int lX, int lY)
	{
			//Top
			if(rY == 0)
			{
				heights[rY][(rX+lX)/2] = avg3(heights[rY][rX], heights[rY][lX], C);
			}
			else
			{
				heights[rY][(rX+lX)/2] = avg4(heights[rY][rX], heights[rY][lX], heights[rY+Math.abs((lY-rY)/2)][(rX+lX)/2], C);
			}
			//R Side
			if(rX == 0)
			{
				heights[(rY+lY)/2][rX] = avg3(heights[rY][rX], heights[lY][rX], C);
			}
			else
			{
				heights[(rY+lY)/2][rX] = avg4(heights[rY][rX], heights[lY][rX], heights[(rY+lY)/2][rX-Math.abs((lX-rX)/2)], C);
			}
			//Bot
			if(lY == heights.length-1)
			{
				heights[lY][(rX+lX)/2] = avg3(heights[lY][rX], heights[lY][lX], C);
			}
			else
			{
				heights[lY][(rX+lX)/2] = avg4(heights[lY][rX], heights[lY][lX], heights[lY-Math.abs((lY-rY)/2)][(rX+lX)/2], C);
			}
			//L Side
			if(lX == heights[0].length-1)
			{
				heights[(rY+lY)/2][lX] = avg3(heights[rY][lX], heights[lY][lX], C);
			}
			else
			{
				heights[(rY+lY)/2][lX] = avg4(heights[rY][lX], heights[lY][lX], heights[(rY+lY)/2][lX+Math.abs((lX-rX)/2)], C);
			}
			DiamondStep(rX, rY, (rX+lX)/2, (rY+lY)/2);
			DiamondStep((rX+lX)/2, rY, lX, (rY+lY)/2);
			DiamondStep(rX, (rY+lY)/2, (rX+lX)/2, lY);
			DiamondStep((rX+lX)/2, (rY+lY)/2, lX, lY);
			
			
		}
	
	private void DiamondStep(int rX, int rY, int lX, int lY)
	{
		if(Math.abs(lX-rX) <= 1)
		{
			return;
		}
		
		heights[(rY+lY)/2][(rX+lX)/2] = (heights[rY][rX] + heights[rY][lX] + heights[lY][rX] +heights[lX][lY])/4.0;
		SquareStep(heights[(rY+lY)/2][(rX+lX)/2], rX, rY, lX, lY);
	}
	
	private double avg4(double a, double b, double c, double d)
	{
		double toReturn = (a + b + c + d)/4.0 + (Math.random()/3.0 - .15);
		if(toReturn > 1.0)
		{
			return 1.0;
		}
		else if(toReturn < 0)
		{
			return 0;
		}
		return toReturn;
	}
	
	private double avg3(double a, double b, double c)
	{
		double toReturn = (a + b + c)/3.0 + (Math.random()/3.0 - .15);
		if(toReturn > 1.0)
		{
			return 1.0;
		}
		else if(toReturn < 0)
		{
			return 0;
		}
		return toReturn;
	}
	
}
