package coop8200_a7;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class FinderView extends JPanel{
	
	private CircleView cView = null;
	private LocationButtonView fView = null;
	private LocationView lView = null;
	
	public FinderView(){
		this.cView = new CircleView();
		this.fView = new LocationButtonView();
		this.lView = new LocationView();
		this.layoutView();
	}
	
	private void layoutView(){
		this.setLayout(new GridLayout(3,1));
		this.add(this.cView);
		this.add(this.fView);
		this.add(this.lView);
		this.cView.setBorder(BorderFactory.createLineBorder(Color.black));
		this.cView.setBackground(Color.lightGray);
		this.fView.setBorder(BorderFactory.createLineBorder(Color.black));
		this.lView.setBorder(BorderFactory.createLineBorder(Color.black));
		this.lView.setBackground(Color.lightGray);
	}

}
