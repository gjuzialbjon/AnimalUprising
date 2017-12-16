/*
 * Author: Bora Ecer
 * Date: 16.12.2017
 * Class for background music
 */
package dev.animaluprising.GameControl;

import java.io.InputStream;
import sun.audio.*;

public class SoundManager 
{
	public InputStream backgroundStream;
    public AudioStream backgroundMusic;
	public SoundManager()
	{
		try {
			backgroundStream = getClass().getResourceAsStream("/Sounds/music.wav");
			backgroundMusic = new AudioStream(backgroundStream);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void play()
	{
		AudioPlayer.player.start(backgroundMusic);
	}
	public void stop()
	{
		AudioPlayer.player.stop(backgroundMusic);
	}
}
