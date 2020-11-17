package Collectables;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;
//import Utils.AirGroundState;
//import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;
import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;

public class Coin extends Collectable{
	private float movementSpeed;
	

	public Coin(float x, float y) {
		super(x, y, new SpriteSheet(ImageLoader.load("Coin Sprite.png"), 32, 31), "FLAT");
    }
	
	public Coin(Point location) {
		super(location.x, location.y, new SpriteSheet(ImageLoader.load("Coin Sprite.png"), 32, 31), "FLAT");
    }
	public void initialize() {
		super.initialize();
	}
	
	@Override
	public void touchedPlayer(Player player) {
        // if coin touches player, it disappears
        super.touchedPlayer(player);
        this.mapEntityStatus = MapEntityStatus.REMOVED;
                
    }
	
	@Override
	 public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
	        return new HashMap<String, Frame[]>() {{
	            put("FLAT", new Frame[]{
	                    new FrameBuilder(spriteSheet.getSprite(1, 0), 300)
	                            .withScale(3)
	                            .withBounds(15, 10, 16, 16)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(0, 0), 300)
	                            .withScale(3)
	                            .withBounds(15, 10, 16, 16)
	                            .build(),
	            });
	            
	           
	        }};
	    }
	 
	 
}
