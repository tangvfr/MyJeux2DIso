package fr.tangv.jeux2diso.game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import fr.tangv.jeux2diso.tools.Loader;
import fr.tangv.jeux2diso.tools.Loading;
import fr.tangv.jeux2diso.tools.Material;
import fr.tangv.jeux2diso.tools.ResourceFont;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class Load extends BasicGameState{
	
	private Image imageloadbackground;
	private Image imageloadcursor;
	private Loader loader;
	private TrueTypeFont font;
	private byte first;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		imageloadbackground = new Image("res/image/gui/load/background.png");
		imageloadcursor = new Image("res/image/gui/load/cursor.png");
		((App)game).agc.setMouseCursor(imageloadcursor, 0, 0);
		first = 0;
		
		loader = new Loader();
		loader.addLoading(ResourceImage.values());
		loader.addLoading(ResourceFont.values());
		loader.addLoading(Material.values());
		
		loader.addLoading(new Loading() {@Override public void ini() {
			game.addState(new MenuMain());
		}});
		
		loader.addLoading(new Loading() {@Override public void ini() {
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
		if (first == 0) {
			first = 1;
		} else if (first == 1) {
			first = 2;
			try {
				Font font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("res/font/Transformers_Movie.ttf"));
				this.font = new TrueTypeFont(font.deriveFont(60.0f), false);
			} catch (FontFormatException | IOException e1) {
				e1.printStackTrace();
			}
		} else if(!loader.next()) {
			((App)game).agc.reinit();
			container.sleep(500);
			((App)game).changeState(StateId.menumain);
		}
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(0, 0);
		g.setColor(Color.black);
		if(font != null) {
			g.setFont(font);
			String text = "Loading: "+((int)((loader.getCursor())/(double)loader.getMax()*1000)/10.)+"%";
			g.drawString(text, (container.getWidth()/2)-(g.getFont().getWidth(text)/2), container.getHeight()-(g.getFont().getHeight(text))-20);
			drawCercle(g, (container.getWidth()/2)-50, (container.getHeight()/2)-50, 100, loader.getCursor(), loader.getMax());
		}
	}
	
	private void drawCercle(Graphics g,int x, int y,int rayon, int value, int max) {
		g.setColor(Color.blue);
		double tpart = 100;
		double part = (Math.PI*2)/tpart;
		int maxpart = (int)(value/(double)max/tpart);
		for(int i = 0; i < maxpart; i++) {
			int xa = (int)(Math.cos(part*i)*rayon);
			int ya = (int)(Math.sin(part*i)*rayon);
			g.drawLine(x, y+ya, x+xa, y+ya);
		}
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
