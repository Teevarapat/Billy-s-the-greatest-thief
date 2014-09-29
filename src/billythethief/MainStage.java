package billythethief;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MainStage {

	private float positionX;
	private float positionY;
	private Image imagestage;
	
	public MainStage (float x , float y) throws SlickException{
		this.positionX = x;
		this.positionY = y;
		imagestage = new Image("res/MainStage.png");
	}
	
	public void render () {
		imagestage.draw(positionX ,positionY);
	}
}
