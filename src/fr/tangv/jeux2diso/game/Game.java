package fr.tangv.jeux2diso.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.objets.Block;
import fr.tangv.jeux2diso.objets.EtatBlock;
import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;
import fr.tangv.jeux2diso.tools.FormBlockWorld;
import fr.tangv.jeux2diso.tools.Material;

public class Game extends BasicGameState {

	private World worldtest;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		worldtest = new World(10, 10, 10, "World_Test");
		
		Block block1 = new Block(null, Material.feriume_green, EtatBlock.normalblock);
		Block block2 = new Block(null, Material.feriume_orange, EtatBlock.normalblock);
		Block block3 = new Block(null, Material.feriume_blue, EtatBlock.normalblock);
		
		FormBlockWorld.setCube(block1, new Location(8, 1, 1, worldtest), new Location(7, 2, 2, worldtest));
		FormBlockWorld.setCubeArret(block2,  new Location(0, 1, 9, worldtest),  new Location(4, 1, 5, worldtest));
		FormBlockWorld.setCube(block3, new Location(9, 0, 0, worldtest), new Location(0, 0, 9, worldtest));
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		worldtest.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		worldtest.render(container, game, g);
	}

	@Override
	public int getID() {
		return StateId.game.getId();
	}
	
}
