package fr.tangv.jeux2diso.objets;

public enum Direction {

	up("up", 5),
	down("down", 4),
	north("north", 0),
	south("south", 2),
	east("east", 3),
	west("west", 1);
	
	private String direction;
	private int i;
	
	private Direction(String direction, int i) {
		this.direction = direction;
		this.i = i;
	}
	
	public String toString() {
		return direction;
	}
	
	public int toInt() {
		return i;
	}
	
}
 