package com.FireFury.primary;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 360, height  = width/16 * 9; //16:9 resolution
	public static int scale = 4;
	
	private Thread gameThread;
	private boolean isRunning = false;
	
	private JFrame frame;
	
	public Game()
	{
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("[Name of Game]");
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
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(isRunning)
		{
			 now = System.nanoTime();
			 delta += (now - lastTime)/timePerTick;
			 timer += (now - lastTime);
			 lastTime = now;
			 if(delta >= 1)
			 {
				 update();
				 render();
				 ticks++;
				 delta--;
			 }
			 if(timer >= 1000000000)
			 {
				 System.out.println("FPS: " + ticks);
				 ticks = 0;
				 timer = 0;
			 }
		}
	}
	
}
