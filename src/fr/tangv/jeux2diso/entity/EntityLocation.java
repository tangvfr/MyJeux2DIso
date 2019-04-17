package fr.tangv.jeux2diso.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;

public class EntityLocation implements ConfigurationSerializable {

	private float x;
	private float y;
	private float z;
	private UUID worldid;
	
	public Location toLocation() {
		return new Location(Math.round(x), Math.round(y), Math.round(z), World.getWorld(worldid));
	}
	
	public EntityLocation copy() {
		return new EntityLocation(x, y, z, World.getWorld(worldid));
	}
	
	public EntityLocation(float x, float y, float z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.worldid = world.getUniqueId();
	}
	
	public World getWorld() {
		return World.getWorld(worldid);
	}
	
	public EntityLocation setWorld(World world) {
		this.worldid = world.getUniqueId();
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
		map.put("worldid", worldid.toString());
		return map;
	}
	
	public EntityLocation(Map<String, Object> map) {
		x = ((Double) map.get("x")).floatValue();
		y = ((Double) map.get("y")).floatValue();
		z = ((Double) map.get("z")).floatValue();
		this.worldid = UUID.fromString((String) map.get("worldid"));
	}
	
}
