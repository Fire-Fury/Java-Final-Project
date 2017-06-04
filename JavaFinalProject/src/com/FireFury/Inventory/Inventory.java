package com.FireFury.Inventory;
import java.util.ArrayList;
import java.util.List;

import com.FireFury.entities.items.Item;

public class Inventory {
	
	List<Item> items;
	int length;
	
	
	public Inventory(int length)
	{
		this.length = length;
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item i)
	{
		items.add(i);
	}

}
