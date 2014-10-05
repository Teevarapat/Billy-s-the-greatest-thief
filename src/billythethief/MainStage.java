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
	private Image youwin;
	
	public MainStage (float x , float y) throws SlickException{
		this.positionX = x;
		this.positionY = y;
		imagestage = new Image("res/MainStage.png");
		helicopter = new Image("res/helicopter2.png");
		gameover = new Image("res/gameover.jpg");
		youwin = new Image("res/youwin.png");
	}
	
	public void render () {
		imagestage.draw(positionX ,positionY);
		helicopter.draw(positioncopterX,positioncopterY);
	}
	public void lose() {
		gameover.draw(230,270);
	}
	
	public void win() {
		youwin.draw(230,270);
	}
	
}
