package fr.tangv.jeux2diso.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.ResourceImage;

public class Load extends BasicGameState{
	
	private boolean first = true;
	private Image imageloadbackground;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		imageloadbackground = new Image("res/image/gui/loadbackground.png");
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(0, 0);
		if (first) {
			first = false;
		} else {
			for (ResourceImage resimg : ResourceImage.values()) {
				resimg.getImage();
			}
			
			game.addState(new MenuMain());
			((App)game).agc.setMouseCursor(ResourceImage.cursor.getImage(), 0, 0);
			((App)game).changeState(StateId.menumain);
		}
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
