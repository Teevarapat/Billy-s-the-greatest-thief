package billythethief;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private Image image;
	private float positionX;
	private float positionY;
	private float speedofbillyX;
	private float speedofbillyY;
	private float minX = 45;
	private float maxX = 885;
	
	public Player (float x ,float y , float speedx , float speedy) throws SlickException{
		this.positionX = x;
		this.positionY = y;
		this.speedofbillyX = speedx;
		this.speedofbillyY = speedy;
		image = new Image("res/stick.png");
	}

	public void render() {
		image.draw( positionX, positionY);
	}
	
	public void updown(boolean up) {
		if(up == true){
			//if(positionX == Ladders.checkplayer[0] + 22.5) {
				positionY -= speedofbillyY;
			//}
		}
		else {
			//if(positionX == Ladders.checkplayer[0] + 22.5) {
				positionY += speedofbillyY;
			//}
		}
	}
	
	public void leftright (boolean left) {
		if(left == true){
			positionX -= speedofbillyX;
			if(positionX <= minX) {
				positionX = minX;
			}
		}
		else {
			positionX += speedofbillyX;
			if(positionX >= maxX){
				positionX = maxX;
			}
		}
	}
}
