package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.Material;

public interface EtatBlock {
	
	public static EtatBlock nullblock = new EtatBlock() {
		@Override public void update(GameContainer container, StateBasedGame game, int delta, Block block) {}
		@Override public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {}
	};
	
	public static EtatBlock normalblock = new EtatBlock() {
		
		public void renderImage(GameContainer container, StateBasedGame game, Graphics g, Block block, Image image) {
			int mxs = container.getWidth()/2-25;
			int mys = container.getHeight()/2-25;
			double lx = block.getX()+block.getWorld().getCamera().getX();
			double ly = block.getY()+block.getWorld().getCamera().getY();
			double lz = block.getZ()+block.getWorld().getCamera().getZ();
			float x = (float)(mxs-(21*lx)+(21*lz));
			float y = (float)(mys-(24*ly)+(12*lx)+(12*lz));
			g.drawImage(image, x, y);
		}
		
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			if (block.getMaterial().equals(Material.air)) {
				block.setRender(false);
			} else {
				block.setRender(true);
			}
		}
		
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			if(block.getRender()) {
				renderImage(container, game, g, block, block.getMaterial().getResourceImage().getImage());
			}
		}
		
	};
	
	public void update(GameContainer container, StateBasedGame game, int delta, Block block);
	public void render(GameContainer container, StateBasedGame game, Graphics g, Block block);
	
}
