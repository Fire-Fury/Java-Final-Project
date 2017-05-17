package com.FireFury.GUI;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.FireFury.primary.Game;

public class GuiManager {
	
	private List<GuiComponent> guiComponents;
	
	public GuiManager()
	{
		this.guiComponents = new ArrayList<GuiComponent>();
		
		GuiComponent console = new Console(Game.getGameWidth()-256, Game.getGameHeight()-256, 256, 256);
		add(console);
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

}
