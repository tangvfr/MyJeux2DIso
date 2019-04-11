package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.game.App;

public class World {
	
	private Block[][][] world;
	private Camera camera;
	private int maxx;
	private int maxy;
	private int maxz;
	private String name;
	
	public World(int maxx, int maxy, int maxz, String name) {
		world = new Block[maxx][maxy][maxz];
		this.maxx = maxx;
		this.maxy = maxy;
		this.maxz = maxz;
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++) {
			setBlock(Block.nullblock, new Location(x, y, z, this));
		}
		camera = new Camera(0.0, 0.0, 0.0, this);
		this.name = name;
	}
	
	public void setBlock(Block bblock, Location location) {
		Block block = bblock.copy();
		block.setLocation(location);
		world[location.getX()][location.getY()][location.getZ()] = block;
	}
	
	public Block getBlock(int x, int y, int z) {
		return world[x][y][z];
	}
	
	public Block getBlock(Location location) {
		return world[location.getX()][location.getY()][location.getZ()];
	}
	
	public float[] getCoord(Location location) {
		int mxs = App.width/2-25;
		int mys = App.height/2-25;
		double lx = location.getX()+getCamera().getX();
		double ly = location.getY()+getCamera().getY();
		double lz = location.getZ()+getCamera().getZ();
		float x = (float)(mxs-(21*lx)+(21*lz));
		float y = (float)(mys-(24*ly)+(12*lx)+(12*lz));
		return new float[]{x, y};
	}
	
	public Block getBlock(Colide colide) {
		for (int y = maxy-1; y >= 0; y--) for (int x = maxx-1; x >= 0; x--) for (int z = maxz-1; z >= 0; z--) {
			Block block = getBlock(x, y, z);
			if (block.getRender()) {
				Colide colideblock = new Colide(block.getXaf(), block.getYaf(), 50, 50, ColideMask.block);
				if (colide.colide(colideblock)) {
					return block;
				}
			}
		}
		return null;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++) {
			world[x][y][z].update(container, game, delta);
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++) {
			world[x][y][z].render(container, game, g);
		}
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxX() {
		return maxx;
	}
	
	public int getMaxY() {
		return maxy;
	}
	
	public int getMaxZ() {
		return maxz;
	}
	
}
