package coop8200_a7;

import javax.swing.JFrame;

public class Main {
	public static void main(final String args[]) {
		final JFrame frame = new JFrame("Location Finder");
		final FinderView view = new FinderView();
		frame.setContentPane(view);
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

