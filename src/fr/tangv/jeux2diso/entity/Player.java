package fr.tangv.jeux2diso.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.ResourceImage;

public class Player extends Entity {

	private ResourceImage resimg;
	
	public Player(EntityLocation location, ResourceImage resimg) {
		super(location);
		this.resimg = resimg;
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		
	}

}
