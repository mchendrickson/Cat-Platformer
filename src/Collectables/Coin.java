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
        
        //Audio.playAudio("C:\\Users\\andre\\eclipse-workspace\\SER-225-Game-Master\\Resources\\coincollect.wav");
        Audio.playAudio("coincollect.wav");

     
    }
	
//	private void playAudio(String string) {
//		playAudio(string);
//		
//	}

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
	 
//	 public static void playAudio(String filename)
//		{
//			try {
//				audioFile = new File(filename);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				//System.exit(1);
//			}
//			try
//			{
//				inputStream = AudioSystem.getAudioInputStream(audioFile);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				//System.exit(1);
//			}
//			
//			format = inputStream.getFormat();
//			
//			DataLine.Info dataInfo = new DataLine.Info(SourceDataLine.class, format);
//			try {
//				dLine = (SourceDataLine) AudioSystem.getLine(dataInfo);
//				dLine.open(format);
//			} 
//			catch (LineUnavailableException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				//System.exit(1);
//			}
//			
//			dLine.start();
//			
//			int nBytesRead = 0;
//	        byte[] abData = new byte[BUFFER_SIZE];
//	        while (nBytesRead != -1) {
//	            try {
//	                nBytesRead = inputStream.read(abData, 0, abData.length);
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	            if (nBytesRead >= 0) {
//	                @SuppressWarnings("unused")
//	                int nBytesWritten = dLine.write(abData, 0, nBytesRead);
//	            }
//		}
//
//		}
	 
	 
}
