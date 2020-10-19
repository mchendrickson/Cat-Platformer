package Level;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;
import GameObject.SpriteSheet;

public class Collectable extends MapEntity{

	 public Collectable(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
	        super(x, y, spriteSheet, startingAnimation);
	    }

	    public Collectable(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
	        super(x, y, animations, startingAnimation);
	    }

	    public Collectable(BufferedImage image, float x, float y, String startingAnimation) {
	        super(image, x, y, startingAnimation);
	    }

	    public Collectable(BufferedImage image, float x, float y) {
	        super(image, x, y);
	    }

	    public Collectable(BufferedImage image, float x, float y, float scale) {
	        super(image, x, y, scale);
	    }

	    public Collectable(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect) {
	        super(image, x, y, scale, imageEffect);
	    }

	    public Collectable(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect, Rectangle bounds) {
	        super(image, x, y, scale, imageEffect, bounds);
	    }

	    @Override
	    public void initialize() {
	        super.initialize();
	    }

	    public void update(Player player) {
	        super.update();
	        if (intersects(player)) {
	            touchedPlayer(player);
	        }
	    }

	    // A subclass can override this method to specify what it does when it touches the player
	    public void touchedPlayer(Player player) {
	        player.incrementCoin(this);
	    	
	    }
	

}

