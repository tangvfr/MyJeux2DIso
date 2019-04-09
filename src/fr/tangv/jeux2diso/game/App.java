package fr.tangv.jeux2diso.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class App extends StateBasedGame {
	
	public static final int width = 1024;
	public static final int height = 768;
	
	public AppGameContainer agc;
	
	public App() throws SlickException {
		super("Jeux Iso 2D Test");
		agc = new AppGameContainer(this);
		agc.setDisplayMode(width, height, false);
		agc.setShowFPS(false);
		agc.start();
	}
	
	@Override
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		if (key == Input.KEY_F3) {
			agc.setShowFPS(!agc.isShowingFPS());
		}
	}
	
	public void exit() {
		agc.destroy();
		System.exit(0);
	}
	
	public void changeState(StateId id) {
		this.enterState(id.getId());
	}
	
	@Override
	public void initStatesList(GameContainer game) throws SlickException {
		this.addState(new Load());
		changeState(StateId.load);
	}

	
}
