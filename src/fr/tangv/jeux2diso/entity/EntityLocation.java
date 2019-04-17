package fr.tangv.jeux2diso.entity;

import java.util.HashMap;
import java.util.Map;

import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;

public class EntityLocation implements ConfigurationSerializable {

	private float x;
	private float y;
	private float z;
	private World world;
	
	public Location toLocation() {
		return new Location(Math.round(x), Math.round(y), Math.round(z), world);
	}
	
	public EntityLocation copy() {
		return new EntityLocation(x, y, z, world);
	}
	
	public EntityLocation(float x, float y, float z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	public World getWorld() {
		return world;
	}
	
	public EntityLocation setWorld(World world) {
		this.world = world;
		return this;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	public EntityLocation setX(float x) {
		this.x = x;
		return this;
	}
	
	public EntityLocation setY(float y) {
		this.y = y;
		return this;
	}
	
	public EntityLocation setZ(float z) {
		this.z = z;
		return this;
	}
	
	public EntityLocation addX(float x) {
		this.x += x;
		return this;
	}
	
	public EntityLocation addY(float y) {
		this.y += y;
		return this;
	}
	
	public EntityLocation addZ(float z) {
		this.z += z;
		return this;
	}
	
	public EntityLocation setCoord(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	public EntityLocation addCoord(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("z", z);
		map.put("world", world);
		return map;
	}
	
	public EntityLocation(Map<String, Object> map) {
		x = ((Double) map.get("x")).floatValue();
		y = ((Double) map.get("y")).floatValue();
		z = ((Double) map.get("z")).floatValue();
		world = (World) map.get("world");
	}
	
}
