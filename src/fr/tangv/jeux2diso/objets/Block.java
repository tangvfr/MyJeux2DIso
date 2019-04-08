package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.EtatBlock;
import fr.tangv.jeux2diso.tools.Location;
import fr.tangv.jeux2diso.tools.Material;

public class Block {

	private World world;
	private Material material;
	private EtatBlock etat;
	private Location location;
	
	public Block(Location location, World world, Material material, EtatBlock etat) {
		this.location = location;
		this.world = world;
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
	
	public Location getLocation() {
		return location;
	}
	
	public int getX() {
		return location.get;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public World getWorld() {
		return world;
	}
	
}
