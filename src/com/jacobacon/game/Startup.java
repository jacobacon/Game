package com.jacobacon.game;

/*
 * Simple outline of steps to help keep code clean: !REMOVE LATER!
 *  1) Main method called.
 *  2) Calls start method.
 *  3) Calls run method.
 *  4) Calls tick method every loop.
 *  5)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Startup extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160; // TODO Get width * height from
											// monitor.
	public static final int HEIGHT = WIDTH / 12 * 9;

	public static final int SCALE = 3;

	boolean running;

	private JFrame frame; // Frame

	public Startup() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE)); // Sets
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE)); // minimum
		// size.

		frame = new JFrame("Game Alpha 1"); // Sets name of frame, and
											// initializes it.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.setResizable(false); // Can't resize the window!

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void tick() {
		// TODO Auto-generated method stub

	}

	private void render() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Startup().start();

	}

	public synchronized void start() { // Starts the Game.
		running = true;
		new Thread(this).start();

	}

	public synchronized void stop() { // Stops the Game
		running = false;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime(); // Get Last System Time.
		double nanoPerTick = 1000000000D / 60D; // How many nano seconds to wait
												// before updating.

		int frames = 0; // Number of frames.
		int ticks = 0; // Number of updates.

		long lastTimer = System.currentTimeMillis(); // Get last time in
														// milliseconds.
		double delta = 0; // Determine if needs to change.

		while (running) { // While the game runs.
			long now = System.nanoTime(); // Sets to current time.
			delta += (now - lastTime) / nanoPerTick; // determines if needs to
														// update.
			lastTime = now; // updates last time.
			boolean shouldRender = true; // Tells the engine to render the game
											// again.

			while (delta >= 1) {
				ticks++; // Updates ticks
				tick(); // Ticks the game.
				delta -= 1; // Resets Delta.
				shouldRender = true;

			}

			try {
				Thread.sleep(2); // Sleep.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++; // Render Game.
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(frames + " " + ticks);
				frames = 0;
				ticks = 0;
			}

		}

	}

}
