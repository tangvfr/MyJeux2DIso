package fr.tangv.jeux2diso.game;

public enum StateId {

	load(0),
	menumain(1);
	
	private int id;
	
	private StateId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
