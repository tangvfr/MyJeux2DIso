package fr.tangv.jeux2diso.objets;

public enum Direction {

	up("up"),
	down("down"),
	north("north"),
	south("south"),
	east("east"),
	west("west");
	
	private String direction;
	
	private Direction(String direction) {
		this.direction = direction;
	}
	
	public String toString() {
		return direction;
	}
	
}
 