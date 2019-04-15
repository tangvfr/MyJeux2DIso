package fr.tangv.jeux2diso.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.objets.Direction;
import fr.tangv.jeux2diso.tools.Parametre;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class MainPlayer extends Player {

	public MainPlayer(EntityLocation location, Direction direction, String name, ResourceImage resimg) {
		super(location, direction, name, resimg);
	}
	
	@Override
	public void setCoord() {
		xaf = App.width/2-25;
		yaf = App.height/2-25;
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		Input input = container.getInput();
		float cof = 0.5f;
		if (input.isKeyPressed(Parametre.parametre.getKeyForWard())) {
			getLocation().addZ(cof);
			setDirection(Direction.west);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyBack())) {
			getLocation().addZ(-cof);
			setDirection(Direction.east);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyLeft())) {
			getLocation().addX(-cof);
			setDirection(Direction.south);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyRight())) {
			getLocation().addX(cof);
			setDirection(Direction.north);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyDown())) {
			getLocation().addY(cof);
		}
		if (input.isKeyPressed(Parametre.parametre.getKeyUp())) {
			getLocation().addY(-cof);
		}
		super.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		super.render(container, game, g);
	}
	
}
