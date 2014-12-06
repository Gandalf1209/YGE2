package com.gandalf1209.yge2.audio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound {

	private static String def = "";
	
	/**
	 * Sets the directory to load the audio files from
	 * @param path Path to audio file
	 */
	public static void setDefaultLoadingDirectory(String path) {
		def = path;
	}
	
	/**
	 * Loads and plays audio file not in source folder
	 * @param url
	 */
	public static void playExternal(String url) {
		try {
			InputStream in = new FileInputStream(new File(def + url));
			InputStream buf = new BufferedInputStream(in);
			AudioInputStream ain = AudioSystem.getAudioInputStream(buf);
			AudioFormat format = ain.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ain);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads and plays the audio file specified
	 * @param url
	 */
	public static void play(String url) {
		try {
			InputStream in = Sound.class.getClass().getResourceAsStream(def + url);
			InputStream buf = new BufferedInputStream(in);
			AudioInputStream ain = AudioSystem.getAudioInputStream(buf);
			AudioFormat format = ain.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ain);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
