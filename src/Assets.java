import java.awt.image.BufferedImage;

public class Assets{

	public static BufferedImage background, obstacle1, obstacle2, box, bomb;
	
	public static void init() {
		background = ImageLoader.loadImage("/images/last_map.png");
		obstacle1 = ImageLoader.loadImage("/images/obstacle1.png");
		obstacle2 = ImageLoader.loadImage("/images/obstacle2.png");
		box = ImageLoader.loadImage("/images/box.png");
		bomb = ImageLoader.loadImage("images/player_bomb.png");
	}
	
}
