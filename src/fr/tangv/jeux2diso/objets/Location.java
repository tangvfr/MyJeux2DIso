package fr.tangv.jeux2diso.objets;

public class Location {

	protected int x;
	protected int y;
	protected int z;
	protected World world;
	
	public Location toEntityLocation() {
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
	
}
