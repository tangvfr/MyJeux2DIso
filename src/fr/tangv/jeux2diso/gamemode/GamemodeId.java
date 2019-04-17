package fr.tangv.jeux2diso.gamemode;

public enum GamemodeId {

	creator(1),
	normal(0);
	
	private int id;
	
	private GamemodeId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
