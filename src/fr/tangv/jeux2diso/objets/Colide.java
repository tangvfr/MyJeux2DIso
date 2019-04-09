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
		setColide(x, y, 0, 0, ColideMask.rectangle);
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
	
	public boolean colide(Colide colide) {
		while (true) {
			if (colide.getMaxX() > minx) break;
			if (colide.getMaxY() > miny) break;
			if (colide.getMinX() < maxx) break;
			if (colide.getMinY() < maxx) break;
			return false;
		}
		return colidemask.colide(this, colide);
	}
	
}
