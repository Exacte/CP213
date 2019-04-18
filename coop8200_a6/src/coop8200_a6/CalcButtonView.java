package coop8200_a6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author mason
 *
 * This sets up the Buttons and their actions for the calculator.
 */
@SuppressWarnings("serial")
public class CalcButtonView extends JPanel {
	public CalcButtonView() {
		this.layoutView();
		this.registerListeners();
	}
	
	/**
	 * 
	 * @author mason
	 *
	 * This is the listeners for buttons 1-9 and the operators, it adds the number or operator to the input JPanel.
	 */
	private class buttonListener implements ActionListener{
		
		String buttonValue = "";
		
		public buttonListener(String buttonValue) {
			 this.buttonValue = buttonValue;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CalcOutputView.theUsersInput.setText(CalcOutputView.theUsersInput.getText() + buttonValue);
			
		}
	}
	
	/**
	 * 
	 * @author mason
	 *
	 * This is the listener for clear button, it clears both the input and output JPanels.
	 */
	private class clearButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			CalcOutputView.theUsersInput.setText("");
			CalcOutputView.theUsersOutput.setText("");
		}
		
	}
	
	/**
	 * 
	 * @author mason
	 *
	 * This is the listener for the equal button, it calls the doesMath class and clalculates the eqution,
	 * then outputs it to the output JPanel.
	 */
	private class equalsButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double output = doesMath.theMath(CalcOutputView.theUsersInput.getText());
			CalcOutputView.theUsersInput.setText(CalcOutputView.theUsersInput.getText() + "=");
			CalcOutputView.theUsersOutput.setText(String.valueOf(output));
		}
		
	}
	
	private final JButton equalsButton = new JButton("=");
	private final JButton add = new JButton("+");
	private final JButton subtract = new JButton("-");
	private final JButton multiply = new JButton("*");
	private final JButton divide = new JButton("/");
	private final JButton clear = new JButton("C");
	
	private final JButton zero = new JButton("0");
	private final JButton one = new JButton("1");
	private final JButton two = new JButton("2");
	private final JButton three = new JButton("3");
	private final JButton four = new JButton("4");
	private final JButton five = new JButton("5");
	private final JButton six = new JButton("6");
	private final JButton seven = new JButton("7");
	private final JButton eight = new JButton("8");
	private final JButton nine = new JButton("9");
	
	/**
	 * Sets the Layout for this view.
	 */
	private void layoutView() {
		this.setLayout(new GridLayout(4, 5));
		this.add(this.seven);
		this.add(this.eight);
		this.add(this.nine);
		this.add(this.divide);
		this.add(this.clear);
		
		this.add(this.four);
		this.add(this.five);
		this.add(this.six);
		this.add(this.multiply);
		this.add(new JButton());
		
		this.add(this.one);
		this.add(this.two);
		this.add(this.three);
		this.add(this.subtract);
		this.add(new JButton());
		
		this.add(new JButton());
		this.add(this.zero);
		this.add(new JButton());
		this.add(this.add);
		this.add(this.equalsButton);
		
	}
	
	/**
	 * Sets all listeners for all buttons.
	 */
	private void registerListeners() {
		this.zero.addActionListener(new buttonListener("0"));
		this.one.addActionListener(new buttonListener("1"));
		this.two.addActionListener(new buttonListener("2"));
		this.three.addActionListener(new buttonListener("3"));
		this.four.addActionListener(new buttonListener("4"));
		this.five.addActionListener(new buttonListener("5"));
		this.six.addActionListener(new buttonListener("6"));
		this.seven.addActionListener(new buttonListener("7"));
		this.eight.addActionListener(new buttonListener("8"));
		this.nine.addActionListener(new buttonListener("9"));
		
		this.add.addActionListener(new buttonListener("+"));
		this.subtract.addActionListener(new buttonListener("-"));
		this.multiply.addActionListener(new buttonListener("*"));
		this.divide.addActionListener(new buttonListener("/"));
		
		this.clear.addActionListener(new clearButtonListener());
		
		this.equalsButton.addActionListener(new equalsButtonListener());
	}
}
