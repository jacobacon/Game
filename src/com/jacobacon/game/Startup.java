package com.jacobacon.game;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Startup().start();

	}

	public synchronized void start() {
		running = true;

		while (running) {
			System.out.println("Hello!");
		}

	}

	public synchronized void stop() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
