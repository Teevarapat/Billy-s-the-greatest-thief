package billythethief;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ladders {
	
	public static int positionX;
	public int positionY;
	private int minX = 70;
	private int maxX = 800;
	public static int [] checkplayer;
	int i = 0;
	//private int [] check = new int [3];
	private Image image;
	private static Random rand = new Random();
	public Ladders (int y) throws SlickException{
		this.positionY = y;
		image = new Image("res/bandai.png");
		RandomPosition();
	}
	
	public void render() {
		image.draw( positionX, positionY);
	}
	
	public void RandomPosition() {
		positionX = rand.nextInt(maxX - minX) + minX;
		//Check();
//		for(int i = 1; i < check.length; i++) {
//			if(check[i-1] >= check[i] + 10 || check[i-1] <= check[i]) {
//				check[i] += 10;
//				if(check[i] >= 880){
//					check[i] -= 20; 
//				}
//			}
//		}
	}
	
	public void Check(){
		checkplayer[i] = positionX;
	
	}
}
