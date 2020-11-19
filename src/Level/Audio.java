package Level;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Audio {
	
	private static final int BUFFER_SIZE = 128000;
	private static File audioFile;
	private static AudioInputStream inputStream;
	private static AudioFormat format;
	private static SourceDataLine dLine;
	
	public static void playAudio(String filename)
	{
		try {
			audioFile = new File(filename);
			//audioFileName = .getClass().getResourceAsStream(filename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.exit(1);
		}
		try
		{
			//inputStream = AudioSystem.getAudioInputStream(audioFile);
			inputStream = AudioSystem.getAudioInputStream(audioFile);
			Clip c = AudioSystem.getClip();
			c.open(inputStream);
			c.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.exit(1);
		}
		


	}
	
}
