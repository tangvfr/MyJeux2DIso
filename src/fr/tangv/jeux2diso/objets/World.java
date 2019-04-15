package fr.tangv.jeux2diso.objets;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.Entity;
import fr.tangv.jeux2diso.entity.EntityLocation;
import fr.tangv.jeux2diso.entity.Player;
import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class World {
	
	private Block[][][] world;
	private EntityLocation camera;
	private int maxx;
	private int maxy;
	private int maxz;
	private String name;
	private ArrayList<Entity> entitymap = new ArrayList<Entity>();
	protected ArrayList<Block> blockrender = new ArrayList<Block>();
	private Player mainplayer;
	
	public World(int maxx, int maxy, int maxz, String name) {
		world = new Block[maxx][maxy][maxz];
		this.maxx = maxx;
		this.maxy = maxy;
		this.maxz = maxz;
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++) {
			setBlock(Block.nullblock, new Location(x, y, z, this));
		}
		camera = new EntityLocation(0.0f, 0.0f, 0.0f, this);
		this.name = name;
		mainplayer = new Player(camera, Direction.south, "", ResourceImage.playermainsheet);
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
		float lx = location.getX()+getCamera().getX();
		float ly = location.getY()+getCamera().getY();
		float lz = location.getZ()+getCamera().getZ();
		float x = mxs-(21*lx)+(21*lz);
		float y = mys-(24*ly)+(12*lx)+(12*lz);
		return new float[]{x, y};
	}
	
	public Block getBlock(Colide colide) {
		for (Block block : blockrender) {
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
		blockrender.clear();
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++) {
			world[x][y][z].update(container, game, delta);
		}
		
		for (Entity entity : entitymap) {
			entity.update(container, game, delta);
		}
		mainplayer.update(container, game, delta);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		for (Block block : blockrender) {
			block.render(container, game, g);
		}
		
		for (Entity entity : entitymap) {
			entity.render(container, game, g);
		}
		mainplayer.render(container, game, g);
	}
	
	public EntityLocation getCamera() {
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
