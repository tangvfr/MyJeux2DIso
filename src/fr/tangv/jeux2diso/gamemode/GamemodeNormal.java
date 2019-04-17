package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.EntityLocation;
import fr.tangv.jeux2diso.entity.MainPlayer;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.Parametre;

public class GamemodeNormal implements Gamemode {

	@Override
	public boolean update(GameContainer container, StateBasedGame game, int delta, MainPlayer mainplayer) {
		Input input = container.getInput();
		float cof = 1f;
		EntityLocation location = mainplayer.getLocation();
		if (input.isKeyPressed(Parametre.parametre.getKeyForWard())) {
			mainplayer.setDirection(Direction.west);
			
			location.addZ(-cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyBack())) {
			mainplayer.setDirection(Direction.east);
			
			location.addZ(cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyLeft())) {
			mainplayer.setDirection(Direction.south);
			
			location.addX(cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyRight())) {
			mainplayer.setDirection(Direction.north);
			
			location.addX(-cof);
		}
		
		if (input.isKeyPressed(Parametre.parametre.getKeyDown())) {
			
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyUp())) {
			
		}
		
		return true;
	}

	@Override
	public boolean render(GameContainer container, StateBasedGame game, Graphics g, MainPlayer mainplayer) {
		return true;
	}

	@Override
	public int getId() {
		return GamemodeId.normal.getId();
	}

}
