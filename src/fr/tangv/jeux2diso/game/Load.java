package fr.tangv.jeux2diso.game;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Load extends BasicGameState{
	
	private Image imageloadbackground;
	private Image imageloadcursor;
	private int i;
	String lastLoaded;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		imageloadbackground = new Image("res/image/gui/load/background.png");
		imageloadcursor = new Image("res/image/gui/load/cursor.png");
		((App)game).agc.setMouseCursor(imageloadcursor, 0, 0);
		i = 0;
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		/*for (ResourceImage resimg : ResourceImage.values()) {
			resimg.ini();
		}
		
		for (Material material : Material.values()) {
			material.getId();
		}
		game.addState(new MenuMain());
		((App)game).agc.setMouseCursor(ResourceImage.cursor.getImage(), 0, 0);
		((App)game).changeState(StateId.menumain);*/
		if (LoadingList.get().getRemainingResources() > 0) { 
	        DeferredResource nextResource = LoadingList.get().getNext(); 
	        try {
				nextResource.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        lastLoaded = nextResource.getDescription();
	    } else { 
	        // loading is complete, do normal update here      
	    }
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(i, i);
		g.drawString("Loading: "+lastLoaded, 10, 10);
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
