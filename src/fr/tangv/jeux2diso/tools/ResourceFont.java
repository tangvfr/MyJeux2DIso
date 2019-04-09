package fr.tangv.jeux2diso.tools;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public enum ResourceFont implements Loading {

	magicfont20("Elementary_Gothic_Bookhand.ttf", 20.0f),
	numfont20("alarm_clock.ttf", 20.0f),
	techfont20("ethnocentric_rg.ttf", 20.0f),
	
	magicfont16("Elementary_Gothic_Bookhand.ttf", 16.0f),
	numfont16("alarm_clock.ttf", 16.0f),
	techfont16("ethnocentric_rg.ttf", 16.0f);
	
	private TrueTypeFont truefont;
	private float taile;
	private String ref;
	
	private ResourceFont(String ref, float taile) {
		this.ref = ref;
		this.taile = taile;
	}
	
	@Override
	public void ini() {
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("res/font/"+ref));
			truefont = new TrueTypeFont(font.deriveFont(taile), false);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public TrueTypeFont getFont() {
		return truefont;
	}
	
}
