package fr.tangv.jeux2diso.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.objets.Colide;
import fr.tangv.jeux2diso.objets.ColideMask;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class Player extends Entity {

	protected SpriteSheet spsh;
	protected int width = 50;
	protected int height = 50;
	protected String name;
	
	public void setCoord() {
		int mxs = App.width/2-25;
		int mys = App.height/2-25;
		float lx = location.getX()+location.getWorld().getCamera().getX();
		float ly = location.getY()+location.getWorld().getCamera().getY();
		float lz = location.getZ()+location.getWorld().getCamera().getZ();
		xaf = mxs-(21*lx)+(21*lz);
		yaf = mys-(24*ly)+(12*lx)+(12*lz);
	}
	
	public Colide getColide() {
		if (getRender())
			return new Colide(xaf, yaf, width, height, ColideMask.player);
		else
			return null;
	}
	
	public Player(EntityLocation location, Direction direction,String name, ResourceImage resimg) {
		super(location, direction);
		this.spsh = new SpriteSheet(resimg.getImage(), width, height);
		this.name = name;
	}

    public String getName() {
		return name;
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		setCoord();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		spsh.getSprite(direction.toInt(), 0).draw(xaf, yaf);
	}
	
}
