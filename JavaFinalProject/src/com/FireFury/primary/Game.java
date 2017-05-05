package com.FireFury.primary;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.FireFury.Screens.Screen;

import Graphics.Assets;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 360, height = width / 16 * 9; // 16:9 resolution
	public static int scale = 4;

	private Thread gameThread;
	private boolean isRunning = false;

	private JFrame frame;

	private Screen currentScreen;

	private int lastFPS = 0;

	private BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

	public Game() {
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
		
		Assets.init();

		start();
	}

	public void update() {

	}

	public void render() {

		BufferStrategy bufferStrategy = getBufferStrategy();

		if (bufferStrategy == null) {
			// Creates a buffer strategy with 3 frames.
			createBufferStrategy(3);
			return;
		}

		Graphics g = bufferStrategy.getDrawGraphics();

		// Block of code that draws literally everything in this game.
		{
			// DRAW EVERYTHING HERE;
			g.setColor(new Color(90, 30, 100));
			g.fillRect(0, 0, getWidth(), getHeight()); // Remove the scale for
														// epilepsy attack.

			if(currentScreen != null)
			{
				currentScreen.render(g);
			}
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
			g.drawString("FPS:" + lastFPS, 0, 20);
		}

		g.dispose();
		// Swap the buffers to the next one
		bufferStrategy.show();
	}

	public synchronized void start() {
		isRunning = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();
	}

	public synchronized void stop() {
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
		double timePerUpdate = 1000000000 / framesPerSec;
		long lastTime = System.nanoTime();
		long currentTime;
		double delta = 0;

		int updates = 0;
		long timer = 0;

		while (isRunning) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / timePerUpdate;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				render();
				updates++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Fps: " + updates);
				lastFPS = updates;
				timer = 0;
				updates = 0;
			}

		}

	}

	// Getters Setters and Helpers
	public int getHeight() {
		return height * scale;
	}

	public int getWidth() {
		return width * scale;
	}

}
