package fr.tangv.jeux2diso.entity;

import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;

public class EntityLocation {

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
	
}
