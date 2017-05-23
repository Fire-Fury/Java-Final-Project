package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	public static final int LENGTH = 32;
	
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
	public static BufferedImage sandTile;
	public static BufferedImage stoneTile;
	public static BufferedImage plateauTile;
	public static BufferedImage waterTile;
	public static BufferedImage dirtTile;
	public static BufferedImage forestTile;
	
	public static BufferedImage colonist1;
	public static BufferedImage tree;
	
	public static void init()
	{
		SpriteSheet sheetA = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheetA.png"));
		SpriteSheet sheetB = new SpriteSheet(ImageLoader.loadImage("/textures/ModernForestArt.png"));
		SpriteSheet character1 = new SpriteSheet(ImageLoader.loadImage("/textures/Char1.png"));
		SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Tree.png"));
		
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
		sandTile = sheetA.crop(3*LENGTH, 1*LENGTH, LENGTH, LENGTH);
		stoneTile = sheetA.crop(4*LENGTH, 1*LENGTH, LENGTH, LENGTH);
		dirtTile = sheetA.crop(5*LENGTH, 0, LENGTH, LENGTH);
		plateauTile = sheetA.crop(3*LENGTH, 2*LENGTH, LENGTH, LENGTH);
		waterTile = sheetA.crop(4*LENGTH, 2*LENGTH, LENGTH, LENGTH);
		forestTile = sheetB.crop(0, 0, LENGTH, LENGTH);
		
		colonist1 = character1.crop(0, 0, LENGTH, LENGTH);
		tree = treeSheet.crop(0, 0, LENGTH, LENGTH);
		
	}
}
