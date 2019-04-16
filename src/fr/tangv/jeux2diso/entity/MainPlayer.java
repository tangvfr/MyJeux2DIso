package fr.tangv.jeux2diso.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.gamemode.Gamemode;
import fr.tangv.jeux2diso.gamemode.GamemodeNormal;
import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class MainPlayer extends Player {

	public Gamemode gamemode;
	
	public MainPlayer(EntityLocation location, Direction direction, String name, ResourceImage resimg) {
		super(location, direction, name, resimg);
		gamemode = new GamemodeNormal();
	}
	
	public void setGamemode(Gamemode gamemode) {
		this.gamemode = gamemode;
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		if (gamemode.update(container, game, delta, this))
			super.update(container, game, delta);
		setCoordAf(App.width/2-25, App.height/2-25);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		if (gamemode.render(container, game, g, this))
			super.render(container, game, g);
		if(container.isShowingFPS() && ((App)game).devmode) {
			g.resetFont();
			g.setColor(Color.white);
			g.drawString("world: "+getWorld().getName()+"\nx: "+getX()+"\ny: "+getY()+"\nz: "+getZ(), 10, 30);
		}
	}
	
}
