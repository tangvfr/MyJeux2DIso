package fr.tangv.jeux2diso.game;

import org.newdawn.slick.SlickException;

public class Main {
	
	public static void sendConsol(String string) {
		System.out.println("[Jeux2DIso] "+string);
	}
	
	public static void error(String string) {
		sendConsol("Error: "+string);
	}
	
	public static void main(String[] args) {
		try {
			new App();
		} catch (SlickException e) {
			Main.error(e.getMessage());
		}
	}
	
}
