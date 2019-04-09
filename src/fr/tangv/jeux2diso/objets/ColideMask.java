package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.Image;

public interface ColideMask {

	public static ColideMask rectangle = new ColideMask() {
		@Override
		public boolean colide(Colide colide, Colide colidetest) {
			if (colidetest.getMaxX() > colide.getMinX()) return false;
			if (colidetest.getMaxY() > colide.getMinY()) return false;
			if (colidetest.getMinX() < colide.getMaxX()) return false;
			if (colidetest.getMinY() < colide.getMaxY()) return false;
			return true;
		}
		
		@Override
		public Image getMask(int width, int height) {
			return null;
		}
		
	};
	
	public boolean colide(Colide colide, Colide colidetest);
	public Image getMask(int width, int height);
	
}
