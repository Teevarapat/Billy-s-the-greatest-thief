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
	private static int countladders = 3;
	private Player player;
	private MainStage stage;
	private static Random rand = new Random();
	private int rangeoffloor = 170;
	private int widthladder = 90;
	private Enemy [] enemys;
	private int countenemy = 1;
	public int enemypositionY = 340;
	private boolean isgameover;
	private boolean restart;
	public static boolean youwin;
	
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
	    initenemys();
	    isgameover = false;
	    restart = false;
	    youwin = false;
	    
	}
	
	private void initenemys() throws SlickException {
		enemys = new Enemy[countenemy];
		for(int i = 0; i < countenemy; i++) {
		
			enemys[i] = new Enemy(enemypositionY);
			enemypositionY -= rangeoffloor;
		}
		
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
		for(Enemy enemy : enemys) {
			enemy.render();
		}
		for(int i = 0; i < countladders; i++) {
			ladders[i].render();
		}
		if(isgameover == true) {
			stage.lose();
		}
		if(youwin == true) {
			stage.win();
		}
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(isgameover == false){
			Input input = container.getInput();
			updateMovement(input, delta);
			for(int i = 0; i < countenemy; i++) {
				enemys[i].update();
			}
			for(int i = 0; i < countenemy; i++) {
				if(player.isCollide(enemys[i]) == true) {
					isgameover = true;
				}
			}
			System.out.println(""+player.getY());
		}
		
		if(restart) {
			container.reinit();
		}
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
		
		if(canMoveLR()) {
			if(input.isKeyDown(Input.KEY_LEFT ) || input.isKeyDown(Input.KEY_A)){
				player.left();
			}
			if(input.isKeyDown(Input.KEY_RIGHT ) || input.isKeyDown(Input.KEY_D)){
				player.right();
			}
		}
		
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ENTER) {
			restart = true;
			laddersposition = 440;
		}
	}
	
	public boolean moveableup() {
		
		for(int i = 0; i < countladders; i++) {
			
			if(player.getX()>=ladders[i].getX() && player.getX()+30 <= ladders[i].getX()+widthladder){
				if(player.getY()+100>=ladders[i].getY()+ 5 && player.getY()+100<=ladders[i].getY()+170) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean moveabledown(){
		
		for(int i=0; i<3; i++){
			if(player.getX()>=ladders[i].getX() && player.getX()+30<=ladders[i].getX()+90){
				if(player.getY()+100 >= ladders[i].getY()-20 && player.getY()+100 <= ladders[i].getY()+165) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean canMoveLR() {
		for(int i= 0; i <= 3; i++){
			if(player.getY() >= 150 + 170*i){
				return true;
			}
		}
		return false;
	}
	
}
