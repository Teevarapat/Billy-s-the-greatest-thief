package billythethief;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BillyGame extends BasicGame{
	
	protected static int GAME_WIDTH = 960;
	protected static int GAME_HEIGHT = 640;
	
	public BillyGame(String title) {
		super(title);
	}

	public static void main(String[] args) {
		try {
			BillyGame game = new BillyGame("Billy Game");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.start();
	} catch (SlickException e) {
		e.printStackTrace();

		}
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		Color background = new Color(255, 255, 255);
	    container.getGraphics().setBackground(background); 
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}

}
