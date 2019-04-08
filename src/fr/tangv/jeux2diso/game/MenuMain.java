package fr.tangv.jeux2diso.game;

import org.newdawn.slick.Color;
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
import fr.tangv.jeux2diso.tools.ResourceImage;

public class MenuMain extends BasicGameState {
	
	private World worldtest;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		worldtest = new World(10, 10, 10, "World_Test");
		Block block1 = new Block(null, Material.feriume_green, EtatBlock.normalblock);
		Block block2 = new Block(null, Material.feriume_orange, EtatBlock.normalblock);
		Block block3 = new Block(null, Material.feriume_blue, EtatBlock.normalblock);
		FormBlockWorld.setCube(block1, new Location(0, 0, 0, worldtest), new Location(3, 0, 3, worldtest));
		FormBlockWorld.setCubeArret(block2,  new Location(5, 0, 9, worldtest),  new Location(9, 0, 5, worldtest));
		worldtest.setBlock(block3, new Location(0, 0, 0, worldtest));
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		worldtest.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ResourceImage.menumainbackground.draw(g, 0, 0);
		worldtest.render(container, game, g);
		g.setColor(Color.white);
		g.fillRect(container.getWidth()/2-1, container.getHeight()/2-1, 2, 2);
	}

	@Override
	public int getID() {
		return StateId.menumain.getId();
	}
	
}
