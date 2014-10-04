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
	private int orderenemy;
	public static int firstenemy = 0;
	public static int secondenemy = 1;
	
	public Enemy(int y,int order) throws SlickException{
		this.positionY = y;
		this.orderenemy = order;
		image = new Image("res/Enemy.png");
	}
	
	public void render() {
		if(orderenemy == firstenemy)
			image.draw(885,positionY);
		else
			image.draw( positionX, positionY);
		
	}
	
	public void update() {
		if(orderenemy == firstenemy) {
			System.out.println("Ready to move first");
			positionX -= randomvelocity();
			if(positionX >= 885) {
				positionX = 885;
			}
		if(orderenemy == secondenemy) {
			System.out.println("Ready to move second");
			positionX += randomvelocity();
			if(positionX <= 45) {
				positionX = 45;
			}
		}
//			check++;
//			if(positionX <= 45){
//				check = 0;
//			}
		}
	}

	private int randomvelocity() {
		this.vx = 5+rand.nextInt(5);
		return vx;
	}
	
//	private int RandomEnemy() {
//		this.positionX = rand.nextInt(maxposition - minposition) + minposition;
//		return positionX;
//	}

}
