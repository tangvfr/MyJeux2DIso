package fr.tangv.jeux2diso.tools;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public enum ResourceAnim implements Loading {
	
	air("air");
	
	private Animation anim;
	private String ref;
	
	private ResourceAnim(String ref) {
		this.ref = ref;
	}
	
	@Override
	public void ini() {
		//try {
			if (ref.equalsIgnoreCase("air")) {
				anim = new Animation();
			} else {
				//"res/image/"+ref+".png"
				//"res/image/"+ref+"."
			}
		/*} catch (SlickException e) {
			e.printStackTrace();
		}*/
	}
	
	public Animation getAnim() {
		return anim;
	}
	
	public void draw(Graphics g, float x, float y) {
		g.drawAnimation(anim, x, y);
	}
	
}
