package fr.tangv.jeux2diso.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.objets.Block;
import fr.tangv.jeux2diso.objets.Colide;
import fr.tangv.jeux2diso.objets.EtatBlock;
import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;
import fr.tangv.jeux2diso.tools.FormBlockWorld;
import fr.tangv.jeux2diso.tools.Material;

public class Game extends BasicGameState {

	private World worldtest;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		worldtest = new World(20, 10, 20, "World_Test");
		
		Block block1 = new Block(null, Material.feriume_green, EtatBlock.normalblock);
		Block block2 = new Block(null, Material.feriume_orange, EtatBlock.normalblock);
		Block block3 = new Block(null, Material.feriume_blue, EtatBlock.normalblock);
		
		FormBlockWorld.setCube(block1, new Location(8, 1, 1, worldtest), new Location(7, 2, 2, worldtest));
		FormBlockWorld.setCubeArret(block2,  new Location(0, 1, 9, worldtest),  new Location(4, 1, 5, worldtest));
		FormBlockWorld.setCube(block3, new Location(19, 0, 0, worldtest), new Location(0, 0, 19, worldtest));
	
	}
	
	private Block blockselect;
	private EtatBlock acetat;
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			((App)game).changeState(StateId.menumain);
		}
		
		double cof = 0.5f;
		if (input.isKeyPressed(Input.KEY_UP)) {
			worldtest.getCamera().addZ(cof);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			worldtest.getCamera().addZ(-cof);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			worldtest.getCamera().addX(-cof);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			worldtest.getCamera().addX(cof);
		}
		if (input.isKeyPressed(Input.KEY_NEXT)) {
			worldtest.getCamera().addY(cof);
		}
		if (input.isKeyPressed(Input.KEY_PRIOR)) {
			worldtest.getCamera().addY(-cof);
		}
		
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			Colide mouse = new Colide(input.getMouseX(), input.getMouseY());
			Block block = worldtest.getBlock(mouse);
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
		
		worldtest.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		worldtest.render(container, game, g);
		g.fillRect(container.getWidth()/2-1, container.getHeight()/2-1, 2, 2);
	}

	@Override
	public int getID() {
		return StateId.game.getId();
	}
	
}
