package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public interface ButtonAction {

	public void action(GameContainer container, StateBasedGame game, int delta, Button button);
	public void render(GameContainer container, StateBasedGame game, Graphics g, Button button);
	
}
