package fr.tangv.jeux2diso.entity;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.objets.World;

public abstract class Entity implements ConfigurationSerializable {
		
	protected EntityLocation location;
	protected Direction direction;
	protected boolean render;
	protected float xaf;
	protected float yaf;
	
	public abstract float[] getSize();
	
	public void setCoordAf(float xaf, float yaf) {
		setXaf(xaf);
		setYaf(yaf);
	}
	
	public void setCoordAf(float[] af) {
		setXaf(af[0]);
		setYaf(af[1]);
	}
	
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
	
	public Entity(EntityLocation location, Direction direction) {
		this.location = location;
		this.direction = direction;
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
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public boolean getRender() {
		return render;
	}
	
	public void setRender(boolean render) {
		this.render = render;
	}
		
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("location", location);
		map.put("direction", direction.toString());
		map.put("render", render);
		return map;
	}
	
	public Entity(Map<String, Object> map) {
		this.location = (EntityLocation) map.get("location");
		this.direction = Direction.valueOf((String) map.get("direction"));
		this.render = (boolean) map.get("render");
	}
	
}
