package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.MainPlayer;

public interface Gamemode {
	
	public boolean update(GameContainer container, StateBasedGame game, int delta, MainPlayer mainplayer);
	public boolean render(GameContainer container, StateBasedGame game, Graphics g, MainPlayer mainplayer);
	
}