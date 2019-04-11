package fr.tangv.jeux2diso.objets;

import fr.tangv.jeux2diso.tools.Mask;

public interface ColideMask {

	public static ColideMask rectangle = new ColideMask() {
		@Override
		public boolean[][] getMask(int width, int height) {
			boolean[][] mask = new boolean[width][height];
			for (int x = 0; x < width; x++) for (int y = 0; y < height; y++) {
				mask[x][y] = true;
			}
			return mask;
		}
		
	};
	
	public static ColideMask block = new ColideMask() {
		@Override
		public boolean[][] getMask(int width, int height) {
			return Mask.maskblockfull;
		}
	};
	
	public default boolean colide(Colide my, Colide colide) {
		int maxx =	(int) Math.max(my.getMaxX(), colide.getMaxX());
		int maxy = (int) Math.max(my.getMaxY(), colide.getMaxY());
		int minx = (int) Math.min(my.getMinX(), colide.getMinX());
		int miny =  (int) Math.min(my.getMinY(), colide.getMinY());
		/*int width = ;
		int height = ;
		boolean[][] talcomp = new boolean[][];*/
		
		
		//░▓█
		
		return true;
	};
	
	public boolean[][] getMask(int width, int height);
	
}
