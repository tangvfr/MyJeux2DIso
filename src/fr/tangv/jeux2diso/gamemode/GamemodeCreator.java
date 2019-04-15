package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.MainPlayer;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.Parametre;

public class GamemodeCreator implements Gamemode {

	@Override
	public boolean update(GameContainer container, StateBasedGame game, int delta, MainPlayer mainplayer) {
		Input input = container.getInput();
		float cof = 0.5f;
		if (input.isKeyPressed(Parametre.parametre.getKeyForWard())) {
			mainplayer.getLocation().addZ(cof);
			mainplayer.setDirection(Direction.west);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyBack())) {
			mainplayer.getLocation().addZ(-cof);
			mainplayer.setDirection(Direction.east);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyLeft())) {
			mainplayer.getLocation().addX(-cof);
			mainplayer.setDirection(Direction.south);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyRight())) {
			mainplayer.getLocation().addX(cof);
			mainplayer.setDirection(Direction.north);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyDown())) {
			mainplayer.getLocation().addY(cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyUp())) {
			mainplayer.getLocation().addY(-cof);
		}
		return true;
	}

	@Override
	public boolean render(GameContainer container, StateBasedGame game, Graphics g, MainPlayer mainplayer) {
		return true;
	}

}
