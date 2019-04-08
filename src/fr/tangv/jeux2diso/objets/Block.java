package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.EtatBlock;
import fr.tangv.jeux2diso.tools.Material;

public class Block {

	private int x;
	private int y;
	private int z;
	private Map map;
	private Material material;
	private EtatBlock etat;
	
	public Block(int x, int y, int z, Map map, Material material, EtatBlock etat) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.map = map;
		this.material = material;
		this.etat = etat;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		etat.update(container, game, delta, this);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		etat.render(container, game, g, this);
	}
	
	public void setEtatBlock(EtatBlock etat) {
		this.etat = etat;
	}
	
	public void setMaterial(Material material, boolean defaultetat) {
		this.material = material;
		if (defaultetat) {
			setEtatBlock(EtatBlock.normalblock);
		}
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public Map getMap() {
		return map;
	}
	
}
