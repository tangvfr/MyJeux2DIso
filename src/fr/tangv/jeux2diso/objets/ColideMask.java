package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.Image;

public interface ColideMask {

	public static ColideMask rectangle = new ColideMask() {
		@Override
		public boolean colide(Colide colide, Colide colidetest) {
			if (colide.getMaxX() > colidetest.getMinX()) return true;
			if (colide.getMaxY() > colidetest.getMinY()) return true;
			if (colide.getMinX() < colidetest.getMaxX()) return true;
			if (colide.getMinY() < colidetest.getMaxX()) return true;
			return false;
		}
		
		@Override
		public Image getMask(int width, int height) {
			return null;
		}
		
	};
	
	public boolean colide(Colide colide, Colide colidetest);
	public Image getMask(int width, int height);
	
}
