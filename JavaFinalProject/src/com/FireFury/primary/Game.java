package com.FireFury.primary;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.FireFury.Screens.Screen;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 360, height  = width/16 * 9; //16:9 resolution
	public static int scale = 4;
	
	private Thread gameThread;
	private boolean isRunning = false;
	
	private JFrame frame;
	
	private Screen screen;
	
	public Game()
	{
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Discount Discounted Dwarf Fortress");
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		start();
	}
	
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
	
	public synchronized void start()
	{
		isRunning = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();
	}

	public synchronized void stop()
	{
		isRunning = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		int framesPerSec = 60;
		double timePerUpdate = 1000000000/framesPerSec;
		long lastTime = System.nanoTime();
		long currentTime;
		double delta = 0;
		
		int updates = 0;
		long timer = 0;
		
		while(isRunning)
		{
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/timePerUpdate;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1)
			{
				update();
				render();
				updates++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("Fps: " + updates);
				timer = 0;
				updates = 0;
			}
			
		}
		
	}
	
}
