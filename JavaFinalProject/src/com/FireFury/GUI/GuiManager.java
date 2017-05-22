package com.FireFury.GUI;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.FireFury.Utils.Handler;
import com.FireFury.primary.Game;

public class GuiManager {
	public static final int GUI_CLOCK = 1;
	public static final int GUI_CONSOLE = 0;
	
	private List<GuiComponent> guiComponents;
	private Handler handler;
	
	public GuiManager(Handler handler)
	{
		this.handler = handler;
		this.guiComponents = new ArrayList<GuiComponent>();
		
		GuiComponent console = new Console(Game.getGameWidth()-352, Game.getGameHeight()-192, 352, 192);
		add(console);
		GuiComponent clock = new Clock(Game.getGameWidth() - 352, 0, 352, 40);
		add(clock);
	}
	
	public void update()
	{
		for(GuiComponent comp: guiComponents)
		{
			comp.update();
		}
	}
	
	public void render(Graphics2D g2d)
	{
		for(GuiComponent comp: guiComponents)
		{
			comp.render(g2d);
		}
	}
	
	private void add(GuiComponent component)
	{
		guiComponents.add(component);
	}
	
	public Console getConsole()
	{
		return (Console) guiComponents.get(GUI_CONSOLE);
	}

}
