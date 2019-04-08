package fr.tangv.jeux2diso.tools;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.util.ResourceLoader;

public enum ResourceFont implements Loading {

	magicfont("Elementary_Gothic_Bookhand.ttf"),
	numfont("alarm_clock.ttf"),
	techfont("ethnocentric_rg.ttf"),
	modernfont("Transformers_Movie.ttf"),
	
	magicfont20(ResourceFont.magicfont,20.0f),
	numfont20(ResourceFont.numfont,20.0f),
	techfont20(ResourceFont.techfont,20.0f),
	modernfont20(ResourceFont.modernfont,20.0f);
	
	private Font font;
	private float taile;
	private String ref;
	private boolean modelefont;
	
	private ResourceFont(String ref) {
		this.ref = ref;
		this.modelefont = true;
	}
	
	private ResourceFont(ResourceFont font, float taile) {
		this.taile = taile;
		this.font = font.getFont();
		this.modelefont = false;
	}
	
	@Override
	public void ini() {
		try {
			if (modelefont) {
				font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("res/font/"+ref));
				System.out.println("ini"+ref);
			} else {
				font = font.deriveFont(taile);
			}
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public Font getFont() {
		return font;
	}
	
}
