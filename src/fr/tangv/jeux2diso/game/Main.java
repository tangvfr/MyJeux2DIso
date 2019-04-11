package fr.tangv.jeux2diso.game;

import org.newdawn.slick.SlickException;

public class Main {
	
	//comencé le 08/04/2019
	public static byte first = 0;
	public static final String rep = System.getenv("APPDATA")+"\\.Myjeuxtest\\";
	public static String repparametre;
	
	public static void sendConsol(String string) {
		System.out.println("[Jeux2DIso] "+string);
	}
	
	public static void main(String args[]) {
		try {
			repparametre = rep+"\\para";
			sendConsol(rep);
			new App();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
}
