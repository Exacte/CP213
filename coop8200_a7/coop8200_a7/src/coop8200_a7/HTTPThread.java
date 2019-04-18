package coop8200_a7;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class HTTPThread extends Thread{

	public HTTPThread(Location location){
		try {
			URL website = new URL(
					"http://hopper.wlu.ca/~choang/iPhone/http/getLocationFromDatabase2.php?zip="
							+ LocationButtonView.postalCodeTextArea.getText());
			Scanner inputStream = new Scanner(new InputStreamReader(
					website.openStream()));
			while (inputStream.hasNextLine()) {
				String s = inputStream.nextLine();
				location.setLocation(s);
			}
			inputStream.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
