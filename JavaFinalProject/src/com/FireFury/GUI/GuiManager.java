package com.FireFury.GUI;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
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
		
		GuiComponent console = new Console(Game.getGameWidth()-320, Game.getGameHeight()-192, 320, 192);
		add(console);
		GuiComponent clock = new Clock(Game.getGameWidth() - 320, 0, 320, 40);
		add(clock);
		GuiComponent dataDisplay = new TileDataDisplay(handler, Game.getGameWidth() - 320, 40, 320, 300);
		add(dataDisplay);
		GuiComponent actionMenu = new ActionMenu(handler, Game.getGameWidth()-320, 340, 320, 368);
		add(actionMenu);
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
	
	public Clock getClock()
	{
		return (Clock) guiComponents.get(GUI_CLOCK);
	}
	
	public void respondToUserInput(MouseEvent e)
	{
		for(GuiComponent comp: guiComponents)
		{
			comp.respondToUserInput(e);
		}
	}

}
