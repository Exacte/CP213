package coop8200_a7;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CircleView extends JPanel{
	
	static JPanel CircleOutput = new JPanel();
	
	public CircleView(){
		this.layoutView();
	}
	private void layoutView(){
		this.setLayout(new BorderLayout());
		this.add(this.CircleOutput, BorderLayout.CENTER);
		this.CircleOutput.setBackground(Color.lightGray);
	}
}
