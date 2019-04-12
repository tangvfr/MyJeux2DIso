package fr.tangv.jeux2diso.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.objets.World;

public abstract class Entity {
		
	private EntityLocation location;
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
	
	public Entity(EntityLocation location) {
		this.location = location;
		this.render = false;
	}
	
	public abstract void update(GameContainer container, StateBasedGame game, int delta);
	
	public abstract void render(GameContainer container, StateBasedGame game, Graphics g);
	
	public void setLocation(EntityLocation location) {
		this.location = location;
	}
	
	public EntityLocation getLocation() {
		return location;
	}
	
	public float getX() {
		return location.getX();
	}
	
	public float getY() {
		return location.getY();
	}
	
	public float  getZ() {
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
