package com.jacobacon.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	private final int RIGHTKEY = KeyEvent.VK_D;
	private final int LEFTKEY = KeyEvent.VK_A;
	private final int UPKEY = KeyEvent.VK_W;
	private final int DOWNKEY = KeyEvent.VK_S;

	public InputHandler(Startup game) {
		game.addKeyListener(this);
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
		case UPKEY:
			up.toggle(isPressed);
			break;
		case DOWNKEY:
			down.toggle(isPressed);
			break;
		case LEFTKEY:
			left.toggle(isPressed);
			break;
		case RIGHTKEY:
			right.toggle(isPressed);
			break;

		}

	}

}
