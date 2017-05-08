package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	public static final int LENGTH = 64;
	
	public static BufferedImage grassUpperLeftCorner;
	public static BufferedImage grassUpperCentralSide;
	public static BufferedImage grassUpperRightCorner;
	public static BufferedImage grassCentralLeftSide;
	public static BufferedImage grassCentralCentralCenter;
	public static BufferedImage grassCentralRightSide;
	public static BufferedImage grassLowerLeftCorner;
	public static BufferedImage grassLowerCentralSide;
	public static BufferedImage grassLowerRightCorner;
	public static BufferedImage nullTile;
	
	public static void init()
	{
		SpriteSheet sheetA = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheetA.png"));
		
		grassUpperLeftCorner = sheetA.crop(0, 0, LENGTH, LENGTH);
		grassUpperCentralSide = sheetA.crop(1*LENGTH, 0, LENGTH, LENGTH);
		grassUpperRightCorner = sheetA.crop(2*LENGTH, 0, LENGTH, LENGTH);
		grassCentralLeftSide = sheetA.crop(0, 1*LENGTH, LENGTH, LENGTH);
		grassCentralCentralCenter = sheetA.crop(1*LENGTH, 1*LENGTH, LENGTH, LENGTH);
		grassCentralRightSide = sheetA.crop(2*LENGTH, 1*LENGTH, LENGTH, LENGTH);
		grassLowerLeftCorner = sheetA.crop(0, 2*LENGTH, LENGTH, LENGTH);
		grassLowerCentralSide = sheetA.crop(1*LENGTH, 2*LENGTH, LENGTH, LENGTH);
		grassLowerRightCorner = sheetA.crop(2*LENGTH, 2*LENGTH, LENGTH, LENGTH);
		
		nullTile = sheetA.crop(4*LENGTH, 0, LENGTH, LENGTH);
		
	}
}
