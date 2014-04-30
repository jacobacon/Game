package com.jacobacon.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.jacobacon.game.prefs.Prefs;

public class InputHandler implements KeyListener {

	private final int RIGHT_LETTER = Prefs.loader.load("RIGHT");
	private final int LEFT_LETTER = KeyEvent.VK_A;
	private final int UP_LETTER = KeyEvent.VK_W;
	private final int DOWN_LETTER = KeyEvent.VK_S;

	private final int RIGHT_ARROW = KeyEvent.VK_RIGHT;
	private final int LEFT_ARROW = KeyEvent.VK_LEFT;
	private final int UP_ARROW = KeyEvent.VK_UP;
	private final int DOWN_ARROW = KeyEvent.VK_DOWN;

	boolean focused;

	public InputHandler(Startup game) {
		game.addKeyListener(this);
		focused = false;
	}

	public class Key {
		private boolean pressed = false;

		public void toggle(boolean isPressed) {
			pressed = isPressed;
		}

		public boolean isPressed() {
			return pressed;
		}
	}

	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();

	@Override
	public void keyPressed(KeyEvent e) {
		toggle(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggle(e.getKeyCode(), false);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void toggle(int keyCode, boolean isPressed) {
		switch (keyCode) {

		// WASD
		case UP_LETTER:
			up.toggle(isPressed);
			break;
		case DOWN_LETTER:
			down.toggle(isPressed);
			break;
		case LEFT_LETTER:
			left.toggle(isPressed);
			break;
		case RIGHT_LETTER:
			right.toggle(isPressed);
			break;

		// Arrow Keys.
		case UP_ARROW:
			up.toggle(isPressed);
			break;
		case DOWN_ARROW:
			down.toggle(isPressed);
			break;
		case LEFT_ARROW:
			left.toggle(isPressed);
			break;
		case RIGHT_ARROW:
			right.toggle(isPressed);
			break;

		}

	}

}
