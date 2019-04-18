package coop8200_a6;

import javax.swing.JFrame;

/**
 * version 1.0
 * 2015-11-25
 * @author mason
 *
 * Initalizes the main frame for the calculator. 
 */
public class Main {
	public static void main(final String args[]) {
		final JFrame frame = new JFrame("Calculator");
		final CalcView view = new CalcView();
		frame.setContentPane(view);
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
