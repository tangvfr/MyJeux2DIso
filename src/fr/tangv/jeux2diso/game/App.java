package fr.tangv.jeux2diso.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.Loading;
import fr.tangv.jeux2diso.tools.Parametre;
import fr.tangv.jeux2diso.tools.ResourceImage;
import fr.tangv.jeux2diso.tools.ResourceLangue;

public class App extends StateBasedGame {
	
	public static final int width = 1024;
	public static final int height = 768;
	
	public AppGameContainer agc;
	
	public App(String name) throws SlickException {
		super(name);
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
		} else if (key == Input.KEY_F1) {
			if (Parametre.parametre.getLangue().equals("en")) {
				Parametre.parametre.setLangue("fr");
			} else {
				Parametre.parametre.setLangue("en");
			}
			for (Loading load : ResourceLangue.values()) {
				load.ini();
			}
			try {
				int id = this.getCurrentStateID();
				this.agc.reinit();
				this.agc.setMouseCursor(ResourceImage.cursor.getImage(), 0, 0);
				this.enterState(id);
			} catch (SlickException e) {
				e.printStackTrace();
			}
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
