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
    private Stopwatch rotationTimer = new Stopwatch();
	

//	public Coin(BufferedImage image, Point location, float scale, ImageEffect imageEffect) {
//        super(image, location.x, location.y, scale, imageEffect);
//    }
	public Coin(float x, float y) {
		super(x, y, new SpriteSheet(ImageLoader.load("Coin Sprite.png"), 32, 32), "FLAT");
		//super(x, y, new SpriteSheet(ImageLoader.load("Coin Sheet 10-15.png"), 64, 64), "FLAT");
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
	                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
	                            .withScale(3)
	                            .withBounds(15, 10, 10, 10)
	                            .build()
	            });
//	            put("SIDE", new Frame[]{
//			            new FrameBuilder(spriteSheet.getSprite(0, 1), 0)
//				                .withScale(3)
//				                .withBounds(1, 1, 5, 5)
//				                .build()
//	            });
	        }};
	    }
	 
	 
	 //if(rotationTimer.get()% 2 == 0);
}
