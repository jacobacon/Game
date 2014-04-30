package com.jacobacon.game.prefs;

import com.jacobacon.game.Startup;

public class Prefs {

	Startup game;
	public PreferenceLoader loader = new PreferenceLoader();
	public PreferenceSaver saver = new PreferenceSaver();

	public Prefs(Startup game) {
		this.game = game;

	}

	public class PreferenceLoader {
		public PreferenceLoader() {

		}

		public void test() {
			System.out.println("Load Preferences");
		}

	}

	public class PreferenceSaver {
		public PreferenceSaver() {

		}
	}

}
