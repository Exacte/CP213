package coop8200_a6;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author mason
 *
 * This JPannel sets up the input and output views for the calculator.
 */
@SuppressWarnings("serial")
public class CalcView extends JPanel {
	
	private CalcButtonView cbView = null;
	private CalcOutputView coView = null;
	
	/**
	 * Constructor
	 */
	public CalcView(){
		this.cbView = new CalcButtonView();
		this.coView = new CalcOutputView();
		this.layoutView();
	}
	
	/**
	 * Sets the Layout for this view.
	 */
	public void layoutView(){
		this.setLayout(new GridLayout(2,1));
		this.add(this.coView);
		this.add(this.cbView);
		this.coView.setBorder(BorderFactory.createLineBorder(Color.black));
		this.cbView.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
