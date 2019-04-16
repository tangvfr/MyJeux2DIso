package fr.tangv.jeux2diso.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.MainPlayer;
import fr.tangv.jeux2diso.objets.Block;
import fr.tangv.jeux2diso.objets.Colide;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.objets.EtatBlock;
import fr.tangv.jeux2diso.tools.Parametre;

public class GamemodeCreator implements Gamemode {

	private Block blockselect;
	private EtatBlock acetat;
	
	@Override
	public boolean update(GameContainer container, StateBasedGame game, int delta, MainPlayer mainplayer) {
		Input input = container.getInput();
		float cof = 0.5f;
		if (input.isKeyPressed(Parametre.parametre.getKeyForWard())) {
			mainplayer.getLocation().addZ(-cof);
			mainplayer.setDirection(Direction.east);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyBack())) {
			mainplayer.getLocation().addZ(cof);
			mainplayer.setDirection(Direction.west);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyLeft())) {
			mainplayer.getLocation().addX(cof);
			mainplayer.setDirection(Direction.south);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyRight())) {
			mainplayer.getLocation().addX(-cof);
			mainplayer.setDirection(Direction.north);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyDown())) {
			mainplayer.getLocation().addY(-cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyUp())) {
			mainplayer.getLocation().addY(cof);
		}
		
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			Colide mouse = new Colide(input.getMouseX(), input.getMouseY());
			Block block = mainplayer.getWorld().getBlock(mouse);
			if (block != null) {
				if (blockselect != null) blockselect.setEtatBlock(acetat);
				acetat = block.getEtat();
				block.setEtatBlock(EtatBlock.selectblock);
				blockselect = block;
			} else {
				if (blockselect != null) blockselect.setEtatBlock(acetat);
				blockselect = null;
			}
			
		}
		return true;
	}

	@Override
	public boolean render(GameContainer container, StateBasedGame game, Graphics g, MainPlayer mainplayer) {
		return true;
	}

}
