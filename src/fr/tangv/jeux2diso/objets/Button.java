package fr.tangv.jeux2diso.objets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import fr.tangv.jeux2diso.tools.ResourceFont;
import fr.tangv.jeux2diso.tools.ResourceImage;

public class Button {

	private float x;
	private float y;
	private int width;
	private int height;
	private Colide colide;
	
	private Image etatnull;
	private Image etatsurv;
	private Image etatpress;
	private ButtonAction action;
	private byte etat;
	private boolean pressed;
	private boolean dpressed;
	
	private Color color;
	private String name;
	private TrueTypeFont font;
	
	public Button(float x, float y, ResourceImage resimg, Color color, String name, ResourceFont font, ButtonAction action) {
		this.x = x;
		this.y = y;
		this.width = resimg.getImage().getWidth();
		this.height = resimg.getImage().getHeight()/3;
		SpriteSheet ss = new SpriteSheet(resimg.getImage(), width, height);
		this.etatnull = ss.getSprite(0, 0);
		this.etatsurv = ss.getSprite(0, 1);
		this.etatpress = ss.getSprite(0, 2);
		this.colide = new Colide(x, y, width, height, ColideMask.rectangle);
		this.etat = 0;
		this.pressed = false;
		this.dpressed = false;
		this.action = action;
		this.color = color;
		this.name = name;
		this.font = font.getFont();
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (etat == 2 && !pressed) {
			action.action(container, game, delta, this);
			pressed = true;
			dpressed = false;
		}
		Input input = container.getInput();
		Colide mouse = new Colide(input.getMouseX(), input.getMouseY());
		if (colide.colide(mouse)) {
			if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				if (!dpressed) {
					etat = 2;
				} else {
					etat = 1;
				}
			} else {
				etat = 1;
				pressed = false;
				dpressed = false;
			}
		} else {
			if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				dpressed = true;
			} else {
				dpressed = false;
			}
			etat = 0;
			pressed = false;
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		if (etat == 1) {
			etatsurv.draw(x, y);
		} else if (etat == 2) {
			etatpress.draw(x, y);
		} else {
			etatnull.draw(x, y);
		}
		if (!name.isEmpty()) {
			g.setColor(color);
			g.setFont(font);
			g.drawString(name, getX()+(getWidth()/2)-(g.getFont().getWidth(name)/2), getY()+(getHeight()/2)-(g.getFont().getHeight(name)/2));
		}
		action.render(container, game, g, this);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public byte getEtat() {
		return etat;
	}
	
	public Colide getColide() {
		return colide;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
