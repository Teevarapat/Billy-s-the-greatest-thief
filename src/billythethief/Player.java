package billythethief;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private Image image;
	private static float pX;
	private static float pY;
	private float speedofbillyX = 5;
	private float speedofbillyY = 3;
	private float minX = 45;
	private float maxX = 885;
	
	public Player (float x ,float y) throws SlickException{
		pX = x;
		pY = y;
		image = new Image("res/stick.png");
	}

	public void render() {
		image.draw( pX, pY);
	}
	
	public void up() {
		pY -= speedofbillyY;
		if(pY + 100 < 100) {
			pY = 0;
		}
	}
	
	public void down() {
		pY += speedofbillyY;
		if(pY + 100 >= 610 ){
			pY = 510;
		}
	}
	
	public void left() {
		pX -= speedofbillyX;
			if(pX <= minX) {
				pX = minX;
		}
	}
	
	public void right(){
		pX += speedofbillyX;
			if(pX >= maxX){
				pX = maxX;
			}
	}
	
//	public static int floor() {
//		if(pY < 170) {
//			System.out.println("2");
//			return 2;
//		}
//		else if(pY > 340){
//			System.out.println("0");
//			return 0;
//		}
//		else {
//			System.out.println("1");
//			return 1;
//		}
//	}
	
	public static float getX() { return pX; }
	
	public static float getY() { return pY; }
}
