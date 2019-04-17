package fr.tangv.jeux2diso.entity;

import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

import fr.tangv.jeux2diso.objets.Colide;
import fr.tangv.jeux2diso.objets.ColideMask;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class Player extends Entity implements ConfigurationSerializable {

	protected SpriteSheet spsh;
	protected static final int width = 50;
	protected static final int height = 50;
	protected static final float sizex = 1;
	protected static final float sizey = 1;
	protected static final float sizez = 1;
	protected String name;
	protected ResourceImage resimg;
	
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
		setCoordAf(getWorld().getCoord(getLocation(), width/2, height/2));
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		spsh.getSprite(direction.toInt(), 0).draw(xaf, yaf);
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = super.serialize();
		map.put("name", name);
		map.put("resimg", resimg.toString());
		return map;
	}
	
	public Player(Map<String, Object> map) {
		super(map);
		this.name = (String) map.get("name");
		this.resimg = ResourceImage.valueOf((String) map.get("resimg"));
		this.spsh = new SpriteSheet(resimg.getImage(), width, height);
	}
	
}
