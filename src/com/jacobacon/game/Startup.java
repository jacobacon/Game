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
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Startup extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) screenSize.getWidth(); 
	public static final int HEIGHT = (int) screenSize.getHeight();
	public static final double SCALE = 1.75;

	boolean running;
	private int tickCount = 0;

	private JFrame frame; // Frame

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	public Startup() {
		setMinimumSize(new Dimension((int)(WIDTH / SCALE), (int)(HEIGHT / SCALE))); // Sets
		setPreferredSize(new Dimension((int)(WIDTH / SCALE), (int)(HEIGHT / SCALE))); // minimum
		// size.

		frame = new JFrame("Game Alpha 0.0.3"); // Sets name of frame, and
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
		tickCount++;

		/*
		 * for (int i = 0; i < pixels.length; i++) { pixels[i] = i * tickCount;
		 * }
		 */

	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.dispose();

		bs.show();

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
