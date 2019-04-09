package fr.tangv.jeux2diso.objets;

public class Camera {

	private double x;
	private double y;
	private double z;
	private World world;
	
	public Camera(double x, double y, double z, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	public World getWorld() {
		return world;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
}
