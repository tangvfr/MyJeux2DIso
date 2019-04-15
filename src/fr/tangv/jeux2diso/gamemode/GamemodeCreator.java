package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GamemodeCreator implements Gamemode {

	@Override
	public boolean update(GameContainer container, StateBasedGame game, int delta) {
		return true;
	}

	@Override
	public boolean render(GameContainer container, StateBasedGame game, Graphics g) {
		return true;
	}

	@Override
	public boolean egal(Gamemode gamemode) {
		return true;
	}

}
