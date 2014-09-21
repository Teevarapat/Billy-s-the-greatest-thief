package billythethief;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private Image image;
	private float positionX;
	private float positionY;
	private float speedofbillyX;
	private float speedofbillyY;
	
	public Player (float x ,float y , float speedx , float speedy) throws SlickException{
		this.positionX = x;
		this.positionY = y;
		this.speedofbillyX = speedx;
		this.speedofbillyY = speedy;
		image = new Image("res/stick.jpg");
	}

	public void render() {
		image.draw( positionX, positionY);
	}
	
	public void updown(boolean up) {
		if(up == true){
			positionY -= speedofbillyY;
		}
		else {
			positionY += speedofbillyY;
		}
	}
	
	public void leftright (boolean left) {
		if(left == true){
			positionX -= speedofbillyX;
		}
		else {
			positionX += speedofbillyX;
		}
	}
}
