package billythethief;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BillyGame extends BasicGame{
	
	protected static int GAME_WIDTH = 960;
	protected static int GAME_HEIGHT = 640;
	protected static float speedx = 5;
	protected static float speedy = 3;
	private Player player;
	private MainStage stage;
	private boolean check = false;
	
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
	    player = new Player(50,500, speedx , speedy);
	    stage = new MainStage(30,100);
	    
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		stage.render();
		player.render();
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateMovement(input, delta);
	}
	
	public void updateMovement(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
			check = true;
			player.updown(check);
	    }
		if(input.isKeyDown( Input.KEY_DOWN ) || input.isKeyDown(Input.KEY_S)){
			check = false;
			player.updown(check);
		}
		if(input.isKeyDown(Input.KEY_LEFT ) || input.isKeyDown(Input.KEY_A)){
			check = true;
			player.leftright(check);
		}
		if(input.isKeyDown(Input.KEY_RIGHT ) || input.isKeyDown(Input.KEY_D)){
			check = false;
			player.leftright(check);
		}
	}

}
