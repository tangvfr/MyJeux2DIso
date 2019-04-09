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
import fr.tangv.jeux2diso.tools.ResourceAnim;
import fr.tangv.jeux2diso.tools.ResourceFont;
import fr.tangv.jeux2diso.tools.ResourceImage;
import fr.tangv.jeux2diso.tools.ResourceLangue;

public class Load extends BasicGameState{
	
	private Image imageloadbackground;
	private Image imageloadcursor;
	private Loader loader;
	private TrueTypeFont font;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		if (Main.first == 0) {
			imageloadbackground = new Image("res/image/gui/load/background.png");
			imageloadcursor = new Image("res/image/gui/load/cursor.png");
			((App)game).agc.setMouseCursor(imageloadcursor, 0, 0);
			
			loader = new Loader();
			loader.addLoading(ResourceImage.values());
			loader.addLoading(ResourceFont.values());
			loader.addLoading(Material.values());
			loader.addLoading(ResourceAnim.values());
			loader.addLoading(ResourceLangue.values());
			
			loader.addLoading(new Loading() {@Override public void ini() {
				game.addState(new MenuMain());
			}});
			
			loader.addLoading(new Loading() {@Override public void ini() {
				game.addState(new Game());
			}});
			
			loader.start();
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (Main.first == 0) {
			Main.first = 1;
		} else if (Main.first == 1) {
			Main.first = 2;
			try {
				Font font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("res/font/ethnocentric_rg.ttf"));
				this.font = new TrueTypeFont(font.deriveFont(36.0f), false);
			} catch (FontFormatException | IOException e1) {
				e1.printStackTrace();
			}
		} else if(!loader.next()) {
			((App)game).agc.reinit();
			container.sleep(500);
			((App)game).agc.setMouseCursor(ResourceImage.cursor.getImage(), 0, 0);
			((App)game).changeState(StateId.menumain);
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(0, 0);
		
		fillCercle(g ,(container.getWidth()/2), (container.getHeight()/2), 208, Color.darkGray);
		fillCercle(g ,(container.getWidth()/2), (container.getHeight()/2), 198, Color.gray);
		drawEvolution(g, (container.getWidth()/2), (container.getHeight()/2), 200, loader.getCursor(), loader.getMax(), Color.decode("0x0094c7"));
		fillCercle(g ,(container.getWidth()/2), (container.getHeight()/2), 190, Color.darkGray);
		fillCercle(g ,(container.getWidth()/2), (container.getHeight()/2), 180, Color.decode("0x909090"));
		
		if(font != null) {
			g.setColor(Color.black);
			g.setFont(font);
			String text = ((int)((loader.getCursor())/(double)loader.getMax()*1000)/10.)+"%";
			g.drawString(text, (container.getWidth()/2)-(g.getFont().getWidth(text)/2), (container.getHeight()/2)-(g.getFont().getHeight(text)/2));
		}
	}
	
	private void fillCercle(Graphics g ,int x, int y, int diametre, Color color) {
		g.setColor(color);
		g.fillOval(x-diametre/2, y-diametre/2, diametre, diametre);
	}
	
	private void drawEvolution(Graphics g,int x, int y,int diametre, int value, int max, Color color) {
		g.setColor(color);
		g.fillArc(x-diametre/2,y-diametre/2, diametre, diametre, -90, (float)(value/(double)max*360)-90);
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
