package com.FireFury.Worlds;

import java.util.Random;

import com.FireFury.Tiles.Tile;

public class WorldBuilder {
	private Random gen = new Random();
	private long seed;

	private double[][] heights = new double[513][513];
	private int[][] worldMap = new int[heights.length][heights[0].length];
	
	public WorldBuilder() //True random generation
	{
		heights[0][0] = Math.random();
		heights[0][heights[0].length-1] = Math.random();
		heights[heights.length-1][0] = Math.random();
		heights[heights.length-1][heights[0].length-1] = Math.random();
	}
	
	public WorldBuilder(long seed) //actual seeded generation
	{
		gen.setSeed(seed);
		heights[0][0] = gen.nextDouble();
		heights[0][heights[0].length-1] = gen.nextDouble();
		heights[heights.length-1][0] = gen.nextDouble();
		heights[heights.length-1][heights[0].length-1] = gen.nextDouble();
	}
	
	public WorldBuilder(double a, double b, double c, double d) //Non-specific constructor
	{
		heights[0][0] = a;
		heights[0][heights[0].length-1] = c;
		heights[heights.length-1][0] = b;
		heights[heights.length-1][heights[0].length-1] = d;
		System.out.println("Top Left: " + heights[0][0]);
		System.out.println("Top Right: " + heights[0][heights[0].length-1]);
		System.out.println("Bottom Left: " + heights[heights.length-1][0]);
		System.out.println("Bottom Right: " + heights[heights.length-1][heights[0].length-1]);
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
				heights[rY][(rX+lX)/2] = avg4(heights[rY][rX], heights[rY][lX], heights[rY-Math.abs((lY-rY)/2)][(rX+lX)/2], C);
			}
			//L Side
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
				heights[lY][(rX+lX)/2] = avg4(heights[lY][rX], heights[lY][lX], heights[lY+Math.abs((lY-rY)/2)][(rX+lX)/2], C);
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
		if(Math.abs(lX-rX) <= 1 || Math.abs(lY-rY) <= 1)
		{
			return;
		}
		
		heights[(rY+lY)/2][(rX+lX)/2] = (heights[rY][rX] + heights[rY][lX] + heights[lY][rX] +heights[lX][lY])/4.0;
		SquareStep(heights[(rY+lY)/2][(rX+lX)/2], rX, rY, lX, lY);
	}
	
	private double avg4(double a, double b, double c, double d)
	{
		double toReturn = (a + b + c + d)/4.0 + (gen.nextDouble()/5 - 0.08);
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
		double toReturn = (a + b + c)/3.0 + (gen.nextDouble()/5 - 0.08);
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
		System.out.println("Top Left: " + heights[0][0]);
		System.out.println("Top Right: " + heights[0][heights[0].length -1]);
		System.out.println("Bottom Left: " + heights[heights.length-1][0]);
		System.out.println("Bottom Right: " + heights[heights.length-1][heights[0].length-1]);
		DiamondStep(0, 0, heights.length-1, heights[0].length-1);
		return this;
	}
	
	private WorldBuilder determineTiles()
	{
		for(int i = 0; i < heights.length; i++)
		{
			for(int j = 0; j < heights[0].length; j++)
			{
				if(heights[i][j] < 0.307) //.25
				{
					worldMap[i][j] = 2;
				}
				else if(heights[i][j] < 0.342) //.37
				{
					worldMap[i][j] = 5;
				}
				else if(heights[i][j] < 0.392) //.37
				{
					worldMap[i][j] = 0;
				}
				else if(heights[i][j] < 0.474)
				{
					worldMap[i][j] = 7;
				}
				else if(heights[i][j] < 0.535) //.587
				{
					int decider = gen.nextInt(3);
					if(decider == 0)
					{
						worldMap[i][j] = 0;
					}
					else
					{
						worldMap[i][j] = 4;
					}
				}
				else if(heights[i][j] < 0.611)
				{
					worldMap[i][j] = 5;
				}
				else if(heights[i][j] < 0.667) //.743
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
	
	public WorldBuilder smoothWorld(int times)
	{
		
		for(int i = 0; i < times; i++)
		{
			for(int x = 0; x < worldMap.length; x++)
			{
				for(int y = 0; y < worldMap[0].length; y++)
				{
					int water = 0;
					int sand = 0;
					int grass = 0;
					int plateau = 0;
					int dirt = 0;
					int stone = 0;
					int forest = 0;
					for (int ox = -2; ox < 3; ox++) {
						for (int oy = -2; oy < 3; oy++) {
							if (x + ox < 0 || x + ox >= worldMap[0].length || y + oy < 0
									|| y + oy >= worldMap.length)
								continue;

							if (worldMap[x + ox][y + oy] == 0)
								grass++;
							else if(worldMap[x + ox][y + oy] == 2)
								water++;
							else if(worldMap[x + ox][y + oy] == 3)
								stone++;
							else if(worldMap[x + ox][y + oy] == 4)
								dirt++;
							else if(worldMap[x + ox][y + oy] == 5)
								sand++;
							else if(worldMap[x + ox][y + oy] == 6)
								plateau++;
							else if(worldMap[x + ox][y + oy] == 7)
								forest++;
						}
					}
					int[] types = {water, sand, grass, dirt, stone, plateau, forest};
					int maxIndex = 0;
					for(int p = 1; p < types.length; p++)
					{
						if(types[p] > types[maxIndex])
						{
							maxIndex = p;
						}
					}
					
					if(maxIndex == 0) // mostly water
					{
						worldMap[x][y] = 2;
					}
					else if(maxIndex == 1) // mostly sand
					{
						worldMap[x][y] = 5;
					}
					else if(maxIndex == 2) // mostly grass
					{
						worldMap[x][y] = 0;
					}
					else if(maxIndex == 3) // mostly dirt
					{
						worldMap[x][y] = 4;
					}
					else if(maxIndex == 4) // mostly stone
					{
						worldMap[x][y] = 3;
					}
					else if(maxIndex == 5) //mostly plateau
					{
						worldMap[x][y] = 6;
					}
					else if(maxIndex == 6) //mostly forest
					{
						worldMap[x][y] = 7;
					}
				}
			}
		}
		
		return this;
	}
	
	public WorldBuilder createWorld()
	{
		return createHeightMap()
				.determineTiles()
				.smoothWorld(1);//1-2 is enough; try to see full screen
	}
	
	public World build()
	{
		return new World(worldMap, gen);
	}
	
}
