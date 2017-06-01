package com.FireFury.Utils;

import com.FireFury.GUI.GuiManager;
import com.FireFury.Screens.PlayScreen;
import com.FireFury.Worlds.World;
import com.FireFury.entities.creatures.Colonist;
import com.FireFury.primary.Game;

public class Handler {
	
	private PlayScreen playScreen;
	private World world;
	private Colonist player;
	private GuiManager guiManager;
	
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
	
	public void setPlayer(Colonist c)
	{
		player = c;
	}
	
	public Colonist getPlayer()
	{
		return player;
	}

	public void setGuiManager(GuiManager guiManager) {
		this.guiManager= guiManager;	
	}
	
	public GuiManager getGuiManager()
	{
		return guiManager;
	}
	
	public int getTime()
	{
		return 1000;
	}

}
