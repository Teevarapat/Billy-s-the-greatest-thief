package billythethief;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MainStage {

	private float positionX;
	private float positionY;
	private float positioncopterX = 45;
	private float positioncopterY = 35;
	private Image imagestage;
	private Image helicopter;
	private Image gameover;
	
	public MainStage (float x , float y) throws SlickException{
		this.positionX = x;
		this.positionY = y;
		imagestage = new Image("res/MainStage.png");
		helicopter = new Image("res/helicopter2.png");
		
	}
	
	public void render () {
		imagestage.draw(positionX ,positionY);
		helicopter.draw(positioncopterX,positioncopterY);
	}
	public void lose() {
		
	}
}
