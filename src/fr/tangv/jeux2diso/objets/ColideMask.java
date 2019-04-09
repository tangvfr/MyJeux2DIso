package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.Image;

public interface ColideMask {

	public static ColideMask rectangle = new ColideMask() {
		@Override
		public boolean colide(Colide my, Colide colide) {
			if (colide.getMaxX() < my.getMinX()) return false;
			if (colide.getMaxY() < my.getMinY()) return false;
			if (colide.getMinX() >= my.getMaxX()) return false;
			if (colide.getMinY() >= my.getMaxY()) return false;
			return true;
		}
		
		@Override
		public Image getMask(int width, int height) {
			return null;
		}
		
	};
	
	public boolean colide(Colide my, Colide colide);
	public Image getMask(int width, int height);
	
}
