package billythethief;

//import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ladders {
	
	public int positionX;
	public int positionY;
	public static int minX = 70;
	public static int maxX = 800;
	static int i = 0;
	public static boolean canmove = false;
	private static int [] check = new int [3];
	private Image image;
	
	public Ladders(){
	}
	
	public Ladders (int x ,int y) throws SlickException{
		this.positionX = x;
		this.positionY = y;
		image = new Image("res/bandai.png");
	}
	
	public void render() {
		image.draw( positionX, positionY);
	}
	
	public float getX(){
		return positionX;
	}
	public float getY(){
		return positionY;
	}
	
	public void print() {
		for(int j = 0; j < 3; j++) {
			System.out.println("check" + j + " " + check[j]);
		}
	}
	
}
