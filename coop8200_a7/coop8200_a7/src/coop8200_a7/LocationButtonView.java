package coop8200_a7;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LocationButtonView extends JPanel {
	public LocationButtonView() {
		this.layoutView();
		this.registerListeners();
	}

	private final JButton getLocation = new JButton("Get Location");
	static JTextArea postalCodeTextArea = new JTextArea();

	private JPanel buttonSpot = new JPanel();
	static JPanel postalCode = new JPanel();
	final JLabel theText = new JLabel("Enter Postal Code");

	private class getLocationButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if (actionCommand.equals("Get Location")) {
				getResult();
			}
		}
		
		public void getResult(){
			new Thread(){
				public void run(){
					Location location = new Location();
					Runnable theThread = new HTTPThread(location);
					new Thread(theThread).start();
					drawCircles();
					location.getLocation();
				}
			}.start();
			
		}
		
		private static final int FILL_WIDTH = 300;
		private static final int FILL_HEIGHT = 100;
		private static final int CIRCLE_SIZE = 10;
		private static final int PAUSE = 100;
		
		private void drawCircles(){
			Graphics g = CircleView.CircleOutput.getGraphics();
			for(int y=0; y<FILL_HEIGHT;y+=CIRCLE_SIZE){
				for(int x=0; x<FILL_WIDTH;x+=CIRCLE_SIZE){
					g.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
					doNothing(PAUSE);
				}
			}
				
		}
		
		public void doNothing(int milliseconds){
			try{
				Thread.sleep(milliseconds);
			}catch(InterruptedException e){
				System.err.println("Error!");
			}
		}
			
	}

	private void layoutView() {
		this.setLayout(new GridLayout(1, 2));
		this.postalCode.setLayout(new GridLayout(2, 1));
		this.postalCode.add(theText);
		this.postalCode.add(postalCodeTextArea);
		this.add(this.postalCode);
		this.buttonSpot.setLayout(new BorderLayout());
		this.buttonSpot.add(getLocation, BorderLayout.CENTER);

		this.add(buttonSpot);

	}

	private void registerListeners() {
		this.getLocation.addActionListener(new getLocationButtonListener());
	}
}
