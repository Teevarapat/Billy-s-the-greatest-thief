package billythethief;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {
	
	private static Random rand = new Random();
//	private int minposition = 45;
//	private int maxposition = 885;
	private Image image;
	private int positionY;
	private int positionX = 50;
	private int vx;
	public static int firstenemy = 0;
	public static int secondenemy = 1;
	
	public Enemy(int y) throws SlickException{
		this.positionY = y;
		image = new Image("res/Enemy.png");
	}
	
	public void render() {
		image.draw( positionX, positionY);
		
	}
	
	public void update() { 
		positionX += randomvelocity();
			if(positionX >= 885) {
				positionX = 45;
				positionY = 170 + 170*randompositionY();
			}
			
	}

	private int randompositionY() {
		int i;
		i = rand.nextInt(2);
		return i;
		
	}

	private int randomvelocity() {
		this.vx = 10+rand.nextInt(5);
		return vx;
	}
	
//	private int RandomEnemy() {
//		this.positionX = rand.nextInt(maxposition - minposition) + minposition;
//		return positionX;
//	}
	public float getX(){
		return positionX;
	}
	public float getY(){
		return positionY;
	}

}
