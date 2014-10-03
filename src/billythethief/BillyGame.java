package billythethief;

import java.util.Random;

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
	private static int playerpositionX = 50;
	private static int playerpositionY = 510;
	private static float stagepositionX = 30;
	private static float stagepositionY = 100;
	private static Ladders[] ladders;
	private static int laddersposition = 440;
	private static final int countladders = 3;
	private Player player;
	private MainStage stage;
	private static Random rand = new Random();
	private int rangeoffloor = 170;
	
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
	    player = new Player(playerpositionX,playerpositionY);
	    stage = new MainStage(stagepositionX,stagepositionY);
	    initladders();
	    
	}
	
	private void initladders() throws SlickException {
		ladders = new Ladders[countladders];
		for(int i = 0; i < countladders; i++) {
			ladders[i] = new Ladders(RandomXLadders(),laddersposition);
	    	laddersposition -= rangeoffloor;
		}
	}
	
	
	private int RandomXLadders() {
		return rand.nextInt(Ladders.maxX - Ladders.minX) + Ladders.minX;
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		stage.render();
		player.render();
		for(int i = 0; i < countladders; i++) {
			ladders[i].render();
		}
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateMovement(input, delta);
		System.out.println(""+Player.getY());
	}
	
	public void updateMovement(Input input, int delta) {
		if(moveableup()) {
			if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
				player.up();
			}
		}
		
		if(moveabledown()){
			if(input.isKeyDown( Input.KEY_DOWN ) || input.isKeyDown(Input.KEY_S)){
				player.down();
			}
		}
		
//		if(Player.getY()+100 >= 439 && Player.getY()+100 <= 460){
//			if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
//				player.up();
//			}
//			if(input.isKeyDown( Input.KEY_DOWN ) || input.isKeyDown(Input.KEY_S)){
//				player.down();
//			}
//			System.out.println("yo");
//		}
		if(canMoveLR()) {
			if(input.isKeyDown(Input.KEY_LEFT ) || input.isKeyDown(Input.KEY_A)){
				player.left();
			}
			if(input.isKeyDown(Input.KEY_RIGHT ) || input.isKeyDown(Input.KEY_D)){
				player.right();
			}
		}
	}
	
	public boolean moveableup() {
		
		for(int i = 0; i < countladders; i++) {
			if(Player.getY()+100>=ladders[i].getY()+ 5 && Player.getY()+100<=ladders[i].getY()+170) {
				return true;
			}
		}
		return false;
	}
	
	public boolean moveabledown(){
		
		for(int i=0; i<3; i++){
			if(Player.getX()>=ladders[i].getX() && Player.getX()+30<=ladders[i].getX()+90){
				if(Player.getY()+100>=ladders[i].getY()-20 && Player.getY()+100<=ladders[i].getY()+165){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean canMoveLR() {
		for(int i=2; i>=0; i--){
			if(Player.getY() == 150 + 170*i){
				return true;
			}
		}
		return false;
	}
	
}
