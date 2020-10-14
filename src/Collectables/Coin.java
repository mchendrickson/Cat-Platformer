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
    private Stopwatch RotationTimer = new Stopwatch();
	

//	public Coin(BufferedImage image, Point location, float scale, ImageEffect imageEffect) {
//        super(image, location.x, location.y, scale, imageEffect);
//    }
	public Coin(float x, float y) {
		super(x, y, new SpriteSheet(ImageLoader.load("Coin Sprite.png"), 32, 32), "DEFAULT");
		
    }
	public void initialize() {
		super.initialize();
	}
	
	public void touchedPlayer(Player player) {
        // if coin touches player, it disappears
        super.touchedPlayer(player);
        //this.mapEntityStatus = MapEntityStatus.REMOVED;
    }
	
	 public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
	        return new HashMap<String, Frame[]>() {{
	            put("DEFAULT", new Frame[]{
	                    new FrameBuilder(spriteSheet.getSprite(0, 0), 100)
	                            .withScale(3)
	                            .withBounds(1, 1, 5, 5)
	                            .build()
	            });
	        }};
	    }
}
