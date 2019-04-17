package fr.tangv.jeux2diso.objets;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

import fr.tangv.jeux2diso.entity.EntityLocation;

public class Location implements ConfigurationSerializable {

	protected int x;
	protected int y;
	protected int z;
	protected UUID worldid;
	
	public EntityLocation toEntityLocation() {
		return new EntityLocation(x, y, z, World.getWorld(worldid));
	}
	
	public Location copy() {
		return new Location(x, y, z, World.getWorld(worldid));
	}
	
	public Location(int x, int y, int z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.worldid = world.getUniqueId();
	}
	
	public World getWorld() {
		return World.getWorld(worldid);
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
		map.put("worldid", worldid.toString());
		return map;
	}
	
	public Location(Map<String, Object> map) {
		x = (int) map.get("x");
		y = (int) map.get("y");
		z = (int) map.get("z");
		this.worldid = UUID.fromString((String) map.get("worldid"));
	}
	
}
