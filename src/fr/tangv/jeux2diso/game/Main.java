package fr.tangv.jeux2diso.game;

import org.newdawn.slick.SlickException;

public class Main {
	
	//comencé le 08/04/2019
	public static byte first = 0;
	
	public static void sendConsol(String string) {
		System.out.println("[Jeux2DIso] "+string);
	}
	
	public static void main(String args[]) {
		try {
			new App();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
}
