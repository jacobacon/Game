package framework;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Window extends JFrame {

	private boolean fullscreen = false;

	/* Creates the Game Window and starts the game. */

	@SuppressWarnings("static-access")
	private Window() {
		this.setTitle("Game Alpha 1");

		if (fullscreen) {
			this.setUndecorated(true);
			this.setExtendedState(this.MAXIMIZED_BOTH);
		}

		else {
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this.setContentPane(new Framework());

		this.setVisible(true);

	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Window();
			}
		});

	}

}
