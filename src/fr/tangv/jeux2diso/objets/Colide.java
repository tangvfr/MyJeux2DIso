package fr.tangv.jeux2diso.objets;

public class Colide {

	private float maxx;
	private float maxy;
	private float minx;
	private float miny;
	private ColideMask colidemask;
	
	private void setColide(float x, float y, float width, float height, ColideMask colidemask) {
		float sx = x+width;
		float sy = y+height;
		maxx = Math.max(x, sx);
		maxy = Math.max(y, sy);
		minx = Math.min(x, sx);
		miny = Math.min(y, sy);
		this.colidemask = colidemask;
	}
	
	public Colide (float x, float y, float width, float height, ColideMask colidemask) {
		setColide(x, y, width, height, colidemask);
	}
	
	public Colide (float x, float y) {
		setColide(x, y, 1, 1, ColideMask.rectangle);
	}
	
	public float getMaxX() {
		return maxx;
	}
	
	public float getMaxY() {
		return maxy;
	}
	
	public float getMinX() {
		return minx;
	}
	
	public float getMinY() {
		return miny;
	}
	
	public float getWidth() {
		return maxx-minx;
	}
	
	public float getHeight() {
		return maxy-miny;
	}
	
	public boolean colide(Colide colide) {
		if (colide.getMaxX() <= minx) return false;
		if (colide.getMaxY() <= miny) return false;
		if (colide.getMinX() >= maxx) return false;
		if (colide.getMinY() >= maxy) return false;
		return ColideMask.colide(this, colide);
	}
	
	public ColideMask getColideMask() {
		return colidemask;
	}
	
}
