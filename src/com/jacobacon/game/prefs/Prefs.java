package com.jacobacon.game.prefs;

import java.util.prefs.Preferences;

import com.jacobacon.game.Startup;

public class Prefs {

	Preferences userPreferences = Preferences.userRoot();

	Startup game;
	public PreferenceLoader loader;
	public PreferenceSaver saver;

	public Prefs(Startup game) {
		this.game = game;
		loader = new PreferenceLoader();
		saver = new PreferenceSaver();

	}

	public class PreferenceLoader {
		public PreferenceLoader() {

		}

		public String loadString(String name) {
			return userPreferences.get(name, "Doesn't Exist");
		}
		
		public int loadInt(String name){
			return userPreferences.getInt(name, 10);
		}

	}

	public class PreferenceSaver {
		public PreferenceSaver() {

		}
		
		public void saveString(String name, String value){
			userPreferences.put(name, value);
		}
		
		public void saveInt(String name, int value){
			userPreferences.putInt(name, value);
		}
	}

}
