package fr.tangv.jeux2diso.objets;

import java.util.HashMap;
import java.util.Map;

import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

import fr.tangv.jeux2diso.entity.EntityLocation;

public class Location implements ConfigurationSerializable {

	protected int x;
	protected int y;
	protected int z;
	protected World world;
	
	public EntityLocation toEntityLocation() {
		return new EntityLocation(x, y, z, world);
	}
	
	public Location copy() {
		return new Location(x, y, z, world);
	}
	
	public Location(int x, int y, int z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	public World getWorld() {
		return world;
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
	
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("z", z);
		map.put("world", world);
		return map;
	}
	
	public Location(Map<String, Object> map) {
		x = (int) map.get("x");
		y = (int) map.get("y");
		z = (int) map.get("z");
		world = (World) map.get("world");
	}
	
}
