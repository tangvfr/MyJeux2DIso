package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.Material;

public class Block {
	
	public static Block nullblock = new Block(null, Material.air, EtatBlock.nullblock);
	
	private Material material;
	private EtatBlock etat;
	private Location location;
	private boolean render;
	private float xaf;
	private float yaf;
	
	public void setXaf(float xaf) {
		this.xaf= xaf;
	}
	
	public void setYaf(float yaf) {
		this.yaf= yaf;
	}
	
	public float getXaf() {
		return xaf;
	}
	
	public float getYaf() {
		return yaf;
	}
	
	public Block(Location location, Material material, EtatBlock etat) {
		this.location = location;
		this.material = material;
		this.etat = etat;
		this.render = false;
	}
	
	public Block copy() {
		Block block = new Block(location, material, etat);
		block.setRender(render);
		return block;
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
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public EtatBlock getEtat() {
		return etat;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public int getX() {
		return location.getX();
	}
	
	public int getY() {
		return location.getY();
	}
	
	public int getZ() {
		return location.getZ();
	}
	
	public World getWorld() {
		return location.getWorld();
	}
	
	public boolean getRender() {
		return render;
	}
	
	public void setRender(boolean render) {
		this.render = render;
	}
	
}
