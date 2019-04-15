package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public interface Gamemode {

	public boolean update(GameContainer container, StateBasedGame game, int delta);
	public boolean render(GameContainer container, StateBasedGame game, Graphics g);
	public boolean egal(Gamemode gamemode);
	
}
