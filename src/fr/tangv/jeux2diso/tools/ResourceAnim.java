package fr.tangv.jeux2diso.tools;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.ResourceLoader;
import org.simpleyaml.configuration.file.YamlConfiguration;

public enum ResourceAnim implements Loading {
	
	air("air"),
	devmode("devmode");
	
	private Animation anim;
	private String ref;
	
	private ResourceAnim(String ref) {
		this.ref = ref;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void ini() {
		try {
			if (ref.equalsIgnoreCase("air")) {
				anim = new Animation();
			} else {
				YamlConfiguration config = YamlConfiguration.loadConfiguration(ResourceLoader.getResourceAsStream("res/anim/"+ref));
				int height = config.getInt("height");
				int width = config.getInt("width");
				int time = config.getInt("time");
				Image img = new Image("res/anim/"+ref+".png");
				SpriteSheet sheet = new SpriteSheet(img, width, height);
				int nbimg = img.getHeight()/height;
				Image[] imganim = new Image[nbimg];
				for (int i = 0; i < nbimg ; i++) {
					imganim[i] = sheet.getSprite(0, i);
				}
				anim = new Animation(imganim, time);
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public Animation getAnim() {
		return anim;
	}
	
	public void draw(Graphics g, float x, float y) {
		g.drawAnimation(anim, x, y);
	}
	
}
