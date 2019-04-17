package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.MainPlayer;

public interface Gamemode {
	
	public static Gamemode createGamemode(int id) {
		if (id == GamemodeId.normal.getId())
			return new GamemodeNormal();
		else if (id == GamemodeId.creator.getId())
			return new GamemodeCreator();
		else
			return null;
	}
	
	public boolean update(GameContainer container, StateBasedGame game, int delta, MainPlayer mainplayer);
	public boolean render(GameContainer container, StateBasedGame game, Graphics g, MainPlayer mainplayer);
	public int getId();
	
}
