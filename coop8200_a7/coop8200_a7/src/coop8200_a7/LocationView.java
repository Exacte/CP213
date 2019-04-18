package coop8200_a7;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LocationView extends JPanel{
	
	private JPanel LocationOutput = new JPanel();
	static JLabel OutputLabel = new JLabel();
	
	public LocationView(){
		this.layoutView();
	}

	private void layoutView(){
		this.add(this.LocationOutput);
		this.LocationOutput.add(OutputLabel);
		this.LocationOutput.setBackground(Color.lightGray);
	}
}
