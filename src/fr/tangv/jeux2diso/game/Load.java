package fr.tangv.jeux2diso.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Load extends BasicGameState{
	
	private Image imageloadbackground;
	private Image imageloadcursor;
	private int i;
	private int load;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		imageloadbackground = new Image("res/image/gui/load/background.png");
		imageloadcursor = new Image("res/image/gui/load/cursor.png");
		((App)game).agc.setMouseCursor(imageloadcursor, 0, 0);
		i = 0;
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(i, i);
		i++;
		g.drawString("Loading: "+load, 10, 10);
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
