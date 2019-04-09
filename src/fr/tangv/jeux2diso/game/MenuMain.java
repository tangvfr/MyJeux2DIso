package fr.tangv.jeux2diso.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.objets.Button;
import fr.tangv.jeux2diso.objets.ButtonAction;
import fr.tangv.jeux2diso.tools.ResourceFont;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class MenuMain extends BasicGameState {
	
	private Button buttonstartgame;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		buttonstartgame = new Button(50, 250, ResourceImage.menubutton, new ButtonAction() {
			@Override
			public void render(GameContainer container, StateBasedGame game, Graphics g, Button button) {
				g.setColor(Color.white);
				g.setFont(ResourceFont.techfont18.getFont());
				String text = "Start Game";
				g.drawString(text, button.getX()+(button.getWidth()/2)-(g.getFont().getWidth(text)/2), button.getY()+(button.getHeight()/2)-(g.getFont().getHeight(text)/2));
			}
			@Override
			public void action(GameContainer container, StateBasedGame game, int delta, Button button) {
				container.sleep(100);
				((App)game).changeState(StateId.game);
			}
		});
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		buttonstartgame.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ResourceImage.menumainbackground.draw(g, 0, 0);
		buttonstartgame.render(container, game, g);
	}

	@Override
	public int getID() {
		return StateId.menumain.getId();
	}
	
}
