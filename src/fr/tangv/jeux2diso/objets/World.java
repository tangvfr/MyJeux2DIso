package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class World {
	
	private Block[][][] world;
	private Location camera;
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
		camera = new Location(0, 0, 0, this);
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
	
	public Location getCamera() {
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
