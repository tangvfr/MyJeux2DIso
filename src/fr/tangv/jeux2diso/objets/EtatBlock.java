package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public enum EtatBlock {
	
	nulletat(EtatOfBlock.nulletat),
	normalblock(EtatOfBlock.normalblock),
	selectblock(EtatOfBlock.selectblock);
	
	private EtatOfBlock etat;
	
	private EtatBlock(EtatOfBlock etat) {
		this.etat = etat;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta, Block block) {
		etat.update(container, game, delta, block);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g, Block block) {
		etat.render(container, game, g, block);
	}
	
}
