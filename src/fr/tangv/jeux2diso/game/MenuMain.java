package fr.tangv.jeux2diso.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.ResourceImage;

public class MenuMain extends BasicGameState {
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ResourceImage.menumainbackground.draw(g, 0, 0);
	}

	@Override
	public int getID() {
		return StateId.menumain.getId();
	}
	
}
