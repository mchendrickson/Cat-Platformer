package Collectables;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.spi.AudioFileReader;

import Level.Audio;
//import com.sun.tools.javac.Main;
//import
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
	
	
	private final static int BUFFER_SIZE = 128000;
	private static File audioFile;
	private static AudioInputStream inputStream;
	private static AudioFormat format;
	private static SourceDataLine dLine;

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
        
        Audio.playAudio("coincollect.wav");

     
    }
	


	@Override
	 public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
	        return new HashMap<String, Frame[]>() {{
	            put("FLAT", new Frame[]{
	                    new FrameBuilder(spriteSheet.getSprite(1, 0), 100)
	                            .withScale(3)
	                            .withBounds(15, 10, 16, 16)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(0, 0), 100)
	                            .withScale(3)
	                            .withBounds(15, 10, 16, 16)
	                            .build(),
	            });
	            
	           
	        }};
	    }
	 
	 
}
