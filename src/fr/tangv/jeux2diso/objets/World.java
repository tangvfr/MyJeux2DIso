package fr.tangv.jeux2diso.objets;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.entity.Entity;
import fr.tangv.jeux2diso.entity.EntityLocation;
import fr.tangv.jeux2diso.entity.MainPlayer;
import fr.tangv.jeux2diso.main.App;

public class World {
	
	private Block[][][] world;
	private int maxx;
	private int maxy;
	private int maxz;
	private String name;
	public ArrayList<Entity> entitymap = new ArrayList<Entity>();
	private MainPlayer mainplayer;
	
	public MainPlayer getMainPlayer() {
		return mainplayer;
	}
	
	public World(int maxx, int maxy, int maxz, String name, MainPlayer mainplayer) {
		world = new Block[maxx][maxy][maxz];
		this.maxx = maxx;
		this.maxy = maxy;
		this.maxz = maxz;
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++) {
			setBlock(Block.nullblock, new Location(x, y, z, this));
		}
		this.name = name;
		mainplayer.setLocation(new EntityLocation(0.0f, 0.0f, 0.0f, this));
		this.mainplayer = mainplayer;
	}
	
	public void setBlock(Block bblock, Location location) {
		Block block = bblock.copy();
		block.setLocation(location);
		world[location.getX()][location.getY()][location.getZ()] = block;
	}
	
	public Block getBlock(int x, int y, int z) {
		if (x >= 0 && x < maxx && y >= 0 && y < maxy && z >= 0 && z < maxz)
			return world[x][y][z];
		else
			return null;
	}
	
	public Block getBlock(Location location) {
		return getBlock(location.getX(), location.getY(), location.getZ());
	}
	
	public float[] getCoord(Location location, int decalx, int decaly) {
		return getCoord(location.getX(), location.getY(), location.getZ(), decalx, decaly);
	}
	
	public float[] getCoord(EntityLocation location, int decalx, int decaly) {
		return getCoord(location.getX(), location.getY(), location.getZ(), decalx, decaly);
	}
	
	public float[] getCoord(float locx, float locy, float locz, int decalx, int decaly) {
		int mxs = App.width/2-decalx;
		int mys = App.height/2-decaly;
		float lx = locx-getCamera().getX();
		float ly = locy-getCamera().getY();
		float lz = locz-getCamera().getZ();
		float x = mxs-(21*lx)+(21*lz);
		float y = mys-(24*ly)+(12*lx)+(12*lz);
		return new float[]{x, y};
	}
	
	public Block getBlock(Colide colide) {
		for (int y = maxy-1; y >= 0; y--) for (int z = maxz-1; z >=0 ; z--) for (int x = maxx-1; x >= 0; x--) {
			Block block = getBlock(x, y ,z);
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
		//main player
		mainplayer.update(container, game, delta);
		//block go render
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++)
			getBlock(x, y ,z).update(container, game, delta);
		//all entity
		for (Entity entity : entitymap)
			entity.update(container, game, delta);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		//block go render
		for (int x = 0; x < maxx; x++) for (int z = 0; z < maxz; z++) for (int y = 0; y < maxy; y++)
			getBlock(x, y ,z).render(container, game, g);
		//all entity
		for (Entity entity : entitymap)
			entity.render(container, game, g);
		//main player
		mainplayer.render(container, game, g);
	}
	
	public EntityLocation getCamera() {
		return mainplayer.getLocation();
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
