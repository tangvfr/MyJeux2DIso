package fr.tangv.jeux2diso.objets;

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
		public boolean[][] getMask(int width, int height) {
			boolean[][] mask = new boolean[width][height];
			for (int x = 0; x < width; x++) for (int y = 0; y < height; y++) {
				mask[x][y] = true;
			}
			return mask;
		}
		
	};
	
	public boolean colide(Colide my, Colide colide);
	public boolean[][] getMask(int width, int height);
	
}
