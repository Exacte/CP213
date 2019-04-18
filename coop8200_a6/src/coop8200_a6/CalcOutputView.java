package coop8200_a6;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author mason
 *
 * A JPanel that connects other JPanels into one frame.
 */
@SuppressWarnings("serial")
public class CalcOutputView extends JPanel{
	private JPanel userInput = new JPanel();
	private JPanel output = new JPanel();
	
	static JLabel theUsersInput = new JLabel("");
	static JLabel theUsersOutput = new JLabel("");
	
	/**
	 * Constructor.
	 */
	public CalcOutputView(){
		this.layoutView();
	}
	
	/**
	 * Sets the Layout for this view
	 */
	public void layoutView(){
		this.setLayout(new GridLayout(2,1));
		this.add(this.userInput);
		this.userInput.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(this.output);
		this.output.setBorder(BorderFactory.createLineBorder(Color.black));
		this.userInput.add(theUsersInput);
		this.output.add(theUsersOutput);
	}
}