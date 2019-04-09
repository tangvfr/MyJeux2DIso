package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.Material;
import fr.tangv.jeux2diso.tools.ResourceImage;

public interface EtatBlock {
	
	public static EtatBlock nulletat = new EtatBlock() {
		@Override public void update(GameContainer container, StateBasedGame game, int delta, Block block) {}
		@Override public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {}
	};
	
	public static EtatBlock normalblock = new EtatBlock() {
		
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			if (block.getMaterial().equals(Material.air)) {
				block.setRender(false);
			} else {
				float[] coord = block.getWorld().getCoord(block.getLocation());
				block.setXaf(coord[0]);
				block.setYaf(coord[1]);
				block.setRender(true);
			}
		}
		
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			if(block.getRender()) {
				block.getMaterial().getResourceImage().draw(g, block.getXaf(), block.getYaf());
			}
		}
		
	};
	
	public static EtatBlock selectblock = new EtatBlock() {
		
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			if (block.getMaterial().equals(Material.air)) {
				block.setRender(false);
			} else {
				float[] coord = block.getWorld().getCoord(block.getLocation());
				block.setXaf(coord[0]);
				block.setYaf(coord[1]);
				block.setRender(true);
			}
		}
		
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			if(block.getRender()) {
				block.getMaterial().getResourceImage().draw(g, block.getXaf(), block.getYaf());
			}
			ResourceImage.selectblock.draw(g, block.getXaf(), block.getYaf());
		}
	};
	
	public void update(GameContainer container, StateBasedGame game, int delta, Block block);
	public void render(GameContainer container, StateBasedGame game, Graphics g, Block block);
	
}
