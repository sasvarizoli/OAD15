package oad;

import java.io.FileInputStream;
import java.io.IOException;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class AudioHandler {
	private AudioPlayer MGP = AudioPlayer.player;
	private AudioStream BGM;
	private AudioData MD;
	private ContinuousAudioDataStream loop = null;
	private Boolean playable;
	private Boolean playing;
	public AudioHandler(){
		playable = false;
		playing = false;
	}
	public void setAudioData(String input){
		if(playing){
			this.MGP.stop(loop);
		}
		if (input == null){
			playable = false;
			return;
		}
		try{
			//BGM = new AudioStream(new FileInputStream(input));
			BGM = new AudioStream(Program.class.getResourceAsStream(input));
			MD = BGM.getData();
			loop = new ContinuousAudioDataStream(MD);
			playable = true;
		} catch(IOException error){
			System.out.print("error: " + error.getMessage());
			playable = false;
			if(playing){
				playing = false;
			}
		}
		if(playing){
			this.MGP.start(loop);
		}
	}
	public void start(){
		if (playable){
			this.MGP.start(loop);
			playing = true;
		} else {
			System.out.println("no playable music");
		}
	}
	public void stop(){
		this.MGP.stop(loop);
		playing = false;
	}
}
