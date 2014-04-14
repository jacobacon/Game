package framework;

import java.awt.Canvas;
import engine.*;

public class Framework extends Canvas {

	public static int width;

	public Framework() {

		Thread gameThread = new Thread() {

			public void run() {
				Game.gameLoop();
			}

		};
		gameThread.start();

	}

}
