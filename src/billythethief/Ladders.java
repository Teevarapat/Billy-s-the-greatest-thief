package billythethief;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ladders {
	
	private int positionX = 45;
	private float positionY = 440;
	private int minX = 45;
	private int maxX = 885;
	private Image image;
	private static Random rand = new Random();
	
	public Ladders () throws SlickException{
		image = new Image("res/bandai.png");
		RandomPosition();
	}
	
	public void render() {
		image.draw( positionX, positionY);
	}
	
	public void RandomPosition() {
		positionX = rand.nextInt(maxX - minX) + minX;
	}
}
