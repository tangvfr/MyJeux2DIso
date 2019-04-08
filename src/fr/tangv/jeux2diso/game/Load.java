package fr.tangv.jeux2diso.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.Loader;
import fr.tangv.jeux2diso.tools.Material;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class Load extends BasicGameState{
	
	private Image imageloadbackground;
	private Image imageloadcursor;
	private Loader loader;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		imageloadbackground = new Image("res/image/gui/load/background.png");
		imageloadcursor = new Image("res/image/gui/load/cursor.png");
		((App)game).agc.setMouseCursor(imageloadcursor, 0, 0);
		
		loader = new Loader();
		loader.addLoading(ResourceImage.values());
		loader.addLoading(Material.values());
		
		loader.addRunnable(new Runnable() {@Override public void run() {
			game.addState(new MenuMain());
		}});
		
		loader.addRunnable(new Runnable() {@Override public void run() {
			try {
				((App)game).agc.setMouseCursor(ResourceImage.cursor.getImage(), 0, 0);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}});
		
		loader.start();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(!loader.next()) {
			container.sleep(1000);
			((App)game).changeState(StateId.menumain);
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(0, 0);
		g.setColor(Color.black);
		String text = "Loading: "+((int)((loader.getCursor())/(double)loader.getMax()*1000))/10.+"%";
		g.drawString(text, (container.getWidth()/2)-(g.getFont().getWidth(text)/2), (container.getHeight()/2)-(g.getFont().getHeight(text)/2));
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
