package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public interface EtatBlock {
	
	public static EtatBlock nullblock = new EtatBlock() {
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {}
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {}
	};
	
	public static EtatBlock normalblock = new EtatBlock() {
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			block.setRender(true);
		}
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			if(block.getRender()) {
				int mxs = container.getWidth()/2-25;
				int mys = container.getHeight()/2-25;
				int lx = block.getX();
				int ly = block.getY();
				int lz = block.getZ();
				float x = mxs-(21*lx)+(21*lz);
				float y = mys-(24*ly)+(12*lx)+(12*lz);
				block.getMaterial().getResourceImage().draw(g, x, y);
			}
		}
	};
	
	public void update(GameContainer container, StateBasedGame game, int delta, Block block);
	public void render(GameContainer container, StateBasedGame game, Graphics g, Block block);
	
}
