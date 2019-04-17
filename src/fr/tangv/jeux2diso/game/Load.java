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
import org.simpleyaml.configuration.serialization.ConfigurationSerialization;

import fr.tangv.jeux2diso.entity.Entity;
import fr.tangv.jeux2diso.entity.Player;
import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.main.Main;
import fr.tangv.jeux2diso.tools.Loader;
import fr.tangv.jeux2diso.tools.Loading;
import fr.tangv.jeux2diso.tools.Mask;
import fr.tangv.jeux2diso.tools.Material;
import fr.tangv.jeux2diso.tools.Parametre;
import fr.tangv.jeux2diso.tools.ResourceAnim;
import fr.tangv.jeux2diso.tools.ResourceFont;
import fr.tangv.jeux2diso.tools.ResourceImage;
import fr.tangv.jeux2diso.tools.ResourceLangue;

public class Load extends BasicGameState{
	
	private Image imageloadbackground;
	private Image imageloadneon;
	private Image imageloadcursor;
	private Loader loader;
	private TrueTypeFont font;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		if (Main.first == 0) {
			imageloadbackground = new Image("res/image/gui/load/background.png");
			imageloadneon = new Image("res/image/gui/load/neon.png");
			imageloadcursor = new Image("res/image/gui/load/cursor.png");
			((App)game).setCursor(imageloadcursor, 0, 0);
			
			loader = new Loader();
			loader.addLoading(new Loading() {
				@Override
				public void ini() {
					ConfigurationSerialization.registerClass(Entity.class);
					ConfigurationSerialization.registerClass(Player.class);
					ConfigurationSerialization.registerClass(MainPlayer.class);
					ConfigurationSerialization.registerClass(EntityLocation.class);
					ConfigurationSerialization.registerClass(Location.class);
					ConfigurationSerialization.registerClass(Block.class);
					ConfigurationSerialization.registerClass(World.class);
				}
			});
			loader.addLoading(ResourceImage.values());
			loader.addLoading(ResourceFont.values());
			loader.addLoading(Material.values());
			loader.addLoading(Parametre.loading());
			loader.addLoading(ResourceAnim.values());
			loader.addLoading(ResourceLangue.values());
			loader.addLoading(Mask.values());
			
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
			((App)game).setCursor(ResourceImage.cursor.getImage(), 0, 0);
			((App)game).changeState(StateId.menumain);
			((App)game).load = true;
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		imageloadbackground.draw(0, 0);
		
		int rayonmax = 124;
		int rayonmin = 114;
		double cof = 1/0.0006;
		double part = (Math.PI*2)/cof;
		int dx = container.getWidth()/2;
		int dy = container.getHeight()/2;
		int dix = imageloadneon.getWidth()/2;
		int diy = imageloadneon.getHeight()/2;
		double max = cof*(loader.getCursor()/(double)loader.getMax());
		for (int i = 0; i < max; i++) {
			double cx = Math.cos(part*(i-cof/4.0));
			double cy = Math.sin(part*(i-cof/4.0));
			for (int rayon = rayonmin; rayon < rayonmax; rayon++) {
				int x = ((int)(cx*rayon))+dx;
				int y = ((int)(cy*rayon))+dy;
				int ix = ((int)(cx*rayon))+dix;
				int iy = ((int)(cy*rayon))+diy;
				Color color = imageloadneon.getColor(ix, iy);
				g.setColor(color);
				g.drawLine(x, y, x, y);
			}
		}
		if(font != null) {
			g.setColor(Color.black);
			g.setFont(font);
			String text = ((int)((loader.getCursor())/(double)loader.getMax()*1000)/10.)+"%";
			g.drawString(text, (container.getWidth()/2)-(g.getFont().getWidth(text)/2), (container.getHeight()/2)-(g.getFont().getHeight(text)/2));
		}
	}

	@Override
	public int getID() {
		return StateId.load.getId();
	}

}
