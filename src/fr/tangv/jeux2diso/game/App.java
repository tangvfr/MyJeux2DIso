package fr.tangv.jeux2diso.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class App extends StateBasedGame {
	
	public AppGameContainer agc;
	
	public App() throws SlickException {
		super("Jeux Iso 2D Test");
		agc = new AppGameContainer(this);
		agc.setDisplayMode(1024, 768, false);
		agc.setShowFPS(false);
		agc.start();
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
