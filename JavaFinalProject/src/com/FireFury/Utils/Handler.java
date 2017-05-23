package com.FireFury.Utils;

import com.FireFury.Screens.PlayScreen;
import com.FireFury.Worlds.World;
import com.FireFury.primary.Game;

public class Handler {
	
	private PlayScreen playScreen;
	private World world;
	
	public Handler(PlayScreen playScreen)
	{
		this.playScreen = playScreen;
	}
	
	public GameCamera getGameCamera()
	{
		return playScreen.getCamera();
	}
	
	public void setWorld(World world)
	{
		this.world = world;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public PlayScreen getPlayScreen()
	{
		return playScreen;
	}

}
