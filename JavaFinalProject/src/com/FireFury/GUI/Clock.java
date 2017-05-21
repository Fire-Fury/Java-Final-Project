package com.FireFury.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Clock extends GuiComponent{
	
	private int width;
	private int height;
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	private long lastTime;
	private long now;

	public Clock(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.year = 1;
		this.month = 1;
		this.day = 1;
		this.hour = 0;
		this.minute = 0;
		
		lastTime = System.currentTimeMillis();
	}
	
	public void update()
	{
		now = System.currentTimeMillis();
		if(now - lastTime >= 1000)
		{
			minute++;
			lastTime = now;
		}
		updateClockTimes();
	}
	
	public void render(Graphics2D g2d)
	{
		g2d.setColor(Color.GRAY);
		g2d.fillRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(getRelativeScreenX(), getRelativeScreenY(), width, height, 10, 10);
		
		g2d.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		g2d.setColor(Color.WHITE);
		String formattedTime = String.format("%02d", hour) + ":" + String.format("%02d", minute);
		g2d.drawString("Year: " + year + " Month: " + month + " Day: " + day + "   " + formattedTime, getRelativeScreenX() + 30, getRelativeScreenY() + 25);
	}
	
	private void updateClockTimes()
	{
		if(minute >= 60)
		{
			hour++;
			minute = minute % 60;
		}
		if(hour >= 24)
		{
			day++;
			hour = hour % 24;
		}
		if(day >= 30)
		{
			month++;
			day = day % 30;
		}
		if(month >= 12)
		{
			year++;
			month = month % 12;
		}
	}

}
