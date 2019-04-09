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
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public void addX(double x) {
		this.x += x;
	}
	
	public void addY(double y) {
		this.y += y;
	}
	
	public void addZ(double z) {
		this.z += z;
	}
	
	public void setCoord(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void addCoord(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
}
