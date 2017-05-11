package com.FireFury.primary;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.FireFury.Screens.LoadingScreen;
import com.FireFury.Screens.MenuScreen;
import com.FireFury.Screens.Screen;

import Graphics.Assets;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {
	private static final long serialVersionUID = 1L;

	public static int width = 360, height = width / 16 * 9; // 16:9 resolution
	public static int scale = 4;

	private Thread gameThread;
	private boolean isRunning = false;

	private JFrame frame;

	private Screen currentScreen;

	private int lastFPS = 0;
	
	private boolean keysPressed[] = new boolean[256];

	//private BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

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
		
		frame.addKeyListener(this);
		
		currentScreen = new LoadingScreen();

		Assets.init();
		start();
	}

	
	
	public void update() {

		if(currentScreen != null)
		{
			currentScreen.update();
			currentScreen = currentScreen.respondToUserInput(keysPressed);
		}
		
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
			g.fillRect(0, 0, getWidth(), getHeight()); // Remove the scale for epilepsy attack.
			
			if(currentScreen.after4Seconds())
			{
				currentScreen = new MenuScreen();
			}
				
			if(currentScreen != null)
			{
				currentScreen.render(g);
			}
			
			//FPS Counter
			//g.setColor(Color.WHITE);
			//g.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
			//g.drawString("FPS:" + lastFPS, 0, 20);
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
		int updatesPerSec = 1000;
		
		double timePerRender = 1000000000 / framesPerSec;
		double timePerUpdate = 1000000000 / updatesPerSec;
		long lastTime = System.nanoTime();
		long currentTime;
		double delta = 0;
		double delta2 = 0;

		int updates = 0;
		int updates2 = 0;
		long timer = 0;

		while (isRunning) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / timePerRender;
			delta2 += (currentTime - lastTime) / timePerUpdate;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if(delta2 >= 1)
			{
				update();
				updates2++;
				delta2--;
			}
			
			if (delta >= 1) {
				render();
				updates++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Fps: " + updates + "    Updates: " + updates2);
				lastFPS = updates;
				timer = 0;
				updates = 0;
				updates2 = 0;
			}

		}

	}

	// Getters Setters and Helpers
	public static int getGameHeight() {
		return height * scale;
	}

	public static int getGameWidth() {
		return width * scale;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			keysPressed[KeyEvent.VK_ENTER] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			keysPressed[KeyEvent.VK_ESCAPE] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			keysPressed[KeyEvent.VK_UP] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keysPressed[KeyEvent.VK_DOWN] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keysPressed[KeyEvent.VK_LEFT] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keysPressed[KeyEvent.VK_RIGHT] = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			keysPressed[KeyEvent.VK_ENTER] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			keysPressed[KeyEvent.VK_ESCAPE] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			keysPressed[KeyEvent.VK_UP] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keysPressed[KeyEvent.VK_DOWN] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keysPressed[KeyEvent.VK_LEFT] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keysPressed[KeyEvent.VK_RIGHT] = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent ae) { }

}
