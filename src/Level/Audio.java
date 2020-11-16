package Level;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.exit(1);
		}
		try
		{
			inputStream = AudioSystem.getAudioInputStream(audioFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.exit(1);
		}
		
		format = inputStream.getFormat();
		
		DataLine.Info dataInfo = new DataLine.Info(SourceDataLine.class, format);
		try {
			dLine = (SourceDataLine) AudioSystem.getLine(dataInfo);
			dLine.open(format);
		} 
		catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.exit(1);
		}
		
		dLine.start();
		
		int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = inputStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = dLine.write(abData, 0, nBytesRead);
            }
	}

	}
	
}
