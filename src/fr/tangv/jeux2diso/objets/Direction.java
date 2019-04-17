package fr.tangv.jeux2diso.objets;

public enum Direction {

	up(5),
	down(4),
	north(0),
	south(2),
	east(3),
	west(1);
	
	private int i;
	
	private Direction(int i) {
		this.i = i;
	}
	
	public int toInt() {
		return i;
	}
	
}
 