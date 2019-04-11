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
	
	public static boolean colide(Colide my, Colide colide) {
		int minx = (int) Math.min(my.getMinX(), colide.getMinX());
		int miny =  (int) Math.min(my.getMinY(), colide.getMinY());
		int mydifx = (int) (minx-my.getMinX());
		int mydify = (int) (miny-my.getMinY());
		int cdifx = (int) (minx-colide.getMinX());
		int cdify = (int) (miny-colide.getMinY());
		
		boolean[][] mymask = my.getColideMask().getMask((int) my.getWidth(), (int) my.getWidth());
		boolean[][] cmask = colide.getColideMask().getMask((int) colide.getWidth(), (int) colide.getWidth());
		for (int x = 0; x < my.getWidth(); x++) for (int y = 0; y < my.getHeight(); y++)
			if (mymask[x][y]) {
				int cx = x-mydifx+cdifx;
				int cy = y-mydify+cdify;
				if (cx >= 0 && colide.getWidth() > cx && cy >= 0 && colide.getHeight() > cy && cmask[cx][cy]) {
					return true;
				}
			}
		
		return false;
	};
	
	public boolean[][] getMask(int width, int height);
	
}
