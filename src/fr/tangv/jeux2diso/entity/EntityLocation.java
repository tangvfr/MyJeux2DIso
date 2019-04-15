package fr.tangv.jeux2diso.entity;

import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;

public class EntityLocation {

	private float x;
	private float y;
	private float z;
	private World world;
	
	public Location convertLocation() {
		return new Location(Math.round(x), Math.round(y), Math.round(z), world);
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
	
	public void setWorld(World world) {
		this.world = world;
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
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setZ(float z) {
		this.z = z;
	}
	
	public void addX(float x) {
		this.x += x;
	}
	
	public void addY(float y) {
		this.y += y;
	}
	
	public void addZ(float z) {
		this.z += z;
	}
	
	public void setCoord(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void addCoord(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
}
