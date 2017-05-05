package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	public static final int HEIGHT = 64;
	public static final int WIDTH = 64;
	
	public static BufferedImage testImage;
	
	public static void init()
	{
		SpriteSheet sheetA = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheetA.png"));
		
		testImage = sheetA.crop(1*WIDTH, 1*HEIGHT, WIDTH, HEIGHT);
	}
}
