package fr.tangv.jeux2diso.tools;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.objets.Block;

public interface EtatBlock {

	public static EtatBlock normalblock = new EtatBlock() {
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			
		}
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			block.getMaterial().getResourceImage().draw(g, //calcule les coordonné en rappor de la map);
		}
	};
	
	public void update(GameContainer container, StateBasedGame game, int delta, Block block);
	public void render(GameContainer container, StateBasedGame game, Graphics g, Block block);
	
}
