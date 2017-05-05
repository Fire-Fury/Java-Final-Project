package Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	BufferedImage sheet;
	
	public SpriteSheet(BufferedImage img)
	{
		sheet = img;
	}
	
	public BufferedImage crop(int dx, int dy, int width, int height)
	{
		return sheet.getSubimage(dx, dy, width, height);
	}
	
}
