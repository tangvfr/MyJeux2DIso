package fr.tangv.jeux2diso.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.main.App;
import fr.tangv.jeux2diso.objets.Button;
import fr.tangv.jeux2diso.objets.ButtonAction;
import fr.tangv.jeux2diso.tools.ResourceFont;
import fr.tangv.jeux2diso.tools.ResourceImage;
import fr.tangv.jeux2diso.tools.ResourceLangue;

public class MenuMain extends BasicGameState {
	
	private Button buttonstartgame;
	private Button buttonexit;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		buttonstartgame = new Button(50, 250, ResourceImage.menubutton, Color.white, ResourceLangue.buttonmenustartgame.getString(), ResourceFont.techfont20, new ButtonAction() {
			@Override public void render(GameContainer container, StateBasedGame game, Graphics g, Button button) {}
			@Override public void action(GameContainer container, StateBasedGame game, int delta, Button button) {
				container.sleep(150);
				((Game)game.getState(StateId.game.getId())).reset();
				((App)game).changeState(StateId.game);
			}
		}); 
		buttonexit = new Button(50, 320, ResourceImage.menubutton, Color.white, ResourceLangue.buttonmenuquit.getString(), ResourceFont.techfont20, new ButtonAction() {
			@Override public void render(GameContainer container, StateBasedGame game, Graphics g, Button button) {}
			@Override public void action(GameContainer container, StateBasedGame game, int delta, Button button) {
				container.sleep(150);
				((App)game).exit();
			}
		});
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		buttonstartgame.update(container, game, delta);
		buttonexit.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ResourceImage.menumainbackground.draw(g, 0, 0);
		buttonstartgame.render(container, game, g);
		buttonexit.render(container, game, g);
	}

	@Override
	public int getID() {
		return StateId.menumain.getId();
	}
	
}
