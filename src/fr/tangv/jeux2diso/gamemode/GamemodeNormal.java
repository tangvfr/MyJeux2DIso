package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.MainPlayer;
import fr.tangv.jeux2diso.objets.Block;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.Parametre;

public class GamemodeNormal implements Gamemode {

	@Override
	public boolean update(GameContainer container, StateBasedGame game, int delta, MainPlayer mainplayer) {
		Input input = container.getInput();
		float cof = 0.5f;
		if (input.isKeyPressed(Parametre.parametre.getKeyForWard())) {
			mainplayer.setDirection(Direction.east);
			Block apb = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(0f, -1f, -cof).toLocation());
			Block ap = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(0f, 0f, -cof).toLocation());
			if (!ap.getMaterial().isSolid() && apb.getMaterial().isSolid())
				mainplayer.getLocation().addZ(-cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyBack())) {
			mainplayer.setDirection(Direction.west);
			Block apb = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(0f, -1f, cof).toLocation());
			Block ap = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(0f, 0f, cof).toLocation());
			if (!ap.getMaterial().isSolid() && apb.getMaterial().isSolid())
				mainplayer.getLocation().addZ(cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyLeft())) {
			mainplayer.setDirection(Direction.south);
			Block apb = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(cof, -1f, 0f).toLocation());
			Block ap = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(cof, 0f, 0f).toLocation());
			if (!ap.getMaterial().isSolid() && apb.getMaterial().isSolid())	
				mainplayer.getLocation().addX(cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyRight())) {
			mainplayer.setDirection(Direction.north);
			Block apb = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(cof, -1f, 0f).toLocation());
			Block ap = mainplayer.getWorld().getBlock(mainplayer.getLocation().copy().addCoord(cof, 0f, 0f).toLocation());
			if (!ap.getMaterial().isSolid() && apb.getMaterial().isSolid())
				mainplayer.getLocation().addX(-cof);
		}
		
		if (input.isKeyPressed(Parametre.parametre.getKeyDown())) {
			
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyUp())) {
			
		}
		
		return false;
	}

	@Override
	public boolean render(GameContainer container, StateBasedGame game, Graphics g, MainPlayer mainplayer) {
		
		return false;
	}

}