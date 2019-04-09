package fr.tangv.jeux2diso.objets;

public class Colide {

	private double maxx;
	private double maxy;
	private double minx;
	private double miny;
	private ColideMask colidemask;
	
	private void setColide(double x, double y, double width, double height, ColideMask colidemask) {
		double sx = x+width;
		double sy = y+height;
		maxx = Math.max(x, sx);
		maxy = Math.max(y, sy);
		minx = Math.min(x, sx);
		miny = Math.min(y, sy);
		this.colidemask = colidemask;
	}
	
	public Colide (double x, double y, double width, double height, ColideMask colidemask) {
		setColide(x, y, width, height, colidemask);
	}
	
	public Colide (double x, double y) {
		setColide(x, y, 0, 0, );
	}
	
	public double getMaxX() {
		return maxx;
	}
	
	public double getMaxY() {
		return maxy;
	}
	
	public double getMinX() {
		return minx;
	}
	
	public double getMinY() {
		return miny;
	}
	
}
