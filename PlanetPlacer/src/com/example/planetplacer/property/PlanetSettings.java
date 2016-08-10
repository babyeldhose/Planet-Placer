package com.example.planetplacer.property;



public class PlanetSettings {
	private static boolean sound = true;
	
	private static boolean music = true;
	
	private static boolean vibration = true;
	
	private static boolean develmode = false;
	
	public static boolean isSound() {
		return sound;
	}
	public static void setSound(boolean sound) {
		PlanetSettings.sound = sound;
	}
	public static boolean isMusic() {
		return music;
	}
	public static void setMusic(boolean music) {
		PlanetSettings.music = music;
	}
	public static boolean isVibration() {
		return vibration;
	}
	public static void setVibration(boolean vibration) {
		PlanetSettings.vibration = vibration;
	}
	public static boolean isDevmode() {
		return develmode;
	}
	public static void setDevmode(boolean devmode) {
		PlanetSettings.develmode = devmode;
	}

}
