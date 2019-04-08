package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.Material;

public class Block {

	private int x;
	private int y;
	private int z;
	private Map map;
	private Material material;
	//etat
	
	public Block(int x, int y, int z, Map map, Material material) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.map = map;
		this.material = material;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		
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
