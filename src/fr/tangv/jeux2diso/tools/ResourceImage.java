package fr.tangv.jeux2diso.tools;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum ResourceImage implements Loading{
	
	air("air"),
	feriumegreen("block/feriume_green.png"),
	feriumeorange("block/feriume_orange.png"),
	feriumeblue("block/feriume_blue.png"),
	
	menumainbackground("gui/menumain/background.png"),
	cursor("gui/cursor.png"),
	menubutton("gui/buttonmenu.png");
	
	private Image image;
	private String ref;
	
	private ResourceImage(String ref) {
		this.ref = ref;
	}
	
	@Override
	public void ini() {
		try {
			if (ref.equalsIgnoreCase("air")) {
				image = new Image(0, 0);
			} else {
				image = new Image("res/image/"+ref);
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Image getImage() {
		return image;
	}
	
	public void draw(Graphics g, float x, float y) {
		g.drawImage(image, x, y);
	}
	
}
