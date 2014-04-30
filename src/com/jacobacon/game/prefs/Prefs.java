package com.jacobacon.game.prefs;

import java.util.prefs.Preferences;

import com.jacobacon.game.Startup;

public class Prefs {

	Preferences userPreferences = Preferences.userRoot();
	Preferences systemPreferences = Preferences.systemRoot();

	Startup game;
	public static PreferenceLoader loader;
	public static PreferenceSaver saver;

	public Prefs(Startup game) {
		this.game = game;
		loader = new PreferenceLoader();
		saver = new PreferenceSaver();

	}

	public class PreferenceLoader {
		public PreferenceLoader() {

		}

		public String load(String name) {
			return userPreferences.get(name, "Doesn't Exist");
		}

	}

	public class PreferenceSaver {
		public PreferenceSaver() {

		}
		
		public void save(String name, String value){
			userPreferences.put(name, value);
		}
	}

}
