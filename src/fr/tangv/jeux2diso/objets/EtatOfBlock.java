package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.tools.Material;
import fr.tangv.jeux2diso.tools.ResourceImage;

public interface EtatOfBlock {
	
	public static boolean inScreen(Block block) {
		if (block.getXaf() > -50 && App.width+50 > block.getXaf() && block.getYaf() > -50 && App.height+50 > block.getYaf())
			return true;
		else
			return false;
	}
	
	public static EtatOfBlock nulletat = new EtatOfBlock() {
		@Override public void update(GameContainer container, StateBasedGame game, int delta, Block block) {}
		@Override public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {}
	};
	
	public static EtatOfBlock normalblock = new EtatOfBlock() {
		
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			if (block.getMaterial().equals(Material.air)) {
				block.setRender(false);
			} else {
				float[] coord = block.getWorld().getCoord(block.getLocation(), 25, 25);
				block.setXaf(coord[0]);
				block.setYaf(coord[1]);
				block.setRender(inScreen(block));
			}
		}
		
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			if(block.getRender()) {
				block.getMaterial().getResourceImage().draw(g, block.getXaf(), block.getYaf());
			}
		}
		
	};
	
	public static EtatOfBlock selectblock = new EtatOfBlock() {
		
		@Override
		public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
			float[] coord = block.getWorld().getCoord(block.getLocation(), 25, 25);
			block.setXaf(coord[0]);
			block.setYaf(coord[1]);
			block.setRender(inScreen(block));
		}
		
		@Override
		public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
			if(block.getRender()) {
				block.getMaterial().getResourceImage().draw(g, block.getXaf(), block.getYaf());
				ResourceImage.selectblock.draw(g, block.getXaf(), block.getYaf());
			}
		}
	};
	
	public void update(GameContainer container, StateBasedGame game, int delta, Block block);
	public void render(GameContainer container, StateBasedGame game, Graphics g, Block block);
	
}
