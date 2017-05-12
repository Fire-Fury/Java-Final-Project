package com.FireFury.Worlds;

import java.util.Random;

import com.FireFury.Tiles.Tile;

public class WorldBuilder {
	Random gen = new Random();

	private double[][] heights = new double[513][513];
	private int[][] worldMap = new int[heights.length][heights[0].length];
	
	public WorldBuilder() //True random generation
	{
		new WorldBuilder((long)(Math.random()*1000000000));
	}
	
	public WorldBuilder(long seed) //actual seeded generation
	{
		gen.setSeed(seed);
		new WorldBuilder(gen.nextDouble(), gen.nextDouble(), gen.nextDouble(), gen.nextDouble());
	}
	
	public WorldBuilder(double a, double b, double c, double d) //Non-specific constructor
	{
		heights[0][0] = a;
		heights[0][heights[0].length-1] = c;
		heights[heights.length-1][0] = b;
		heights[heights.length-1][heights[0].length-1] = d;
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
		double toReturn = (a + b + c + d)/4.0 + (gen.nextDouble()/5 - 0.1);
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
		double toReturn = (a + b + c)/3.0 + (gen.nextDouble()/5 - 0.1);
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
	
	private WorldBuilder createHeightMap()
	{
		DiamondStep(0, 0, heights[0].length-1, heights.length-1);
		return this;
	}
	
	private WorldBuilder determineTiles()
	{
		for(int i = 0; i < heights.length; i++)
		{
			for(int j = 0; j < heights[0].length; j++)
			{
				if(heights[i][j] < 0.15)
				{
					worldMap[i][j] = 2;
				}
				else if(heights[i][j] < 0.25)
				{
					worldMap[i][j] = 5;
				}
				else if(heights[i][j] < 0.5)
				{
					worldMap[i][j] = 0;
				}
				else if(heights[i][j] < 0.75)
				{
					worldMap[i][j] = 4;
				}
				else if(heights[i][j] < 0.9)
				{
					worldMap[i][j] = 3;
				}
				else
				{
					worldMap[i][j] = 6;
				}
			}
		}
		return this;
	}
	
	public WorldBuilder createWorld()
	{
		return createHeightMap()
				.determineTiles();
	}
	
	public World build()
	{
		return new World(worldMap);
	}
	
}
