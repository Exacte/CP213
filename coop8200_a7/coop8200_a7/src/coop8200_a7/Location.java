package coop8200_a7;

public class Location {
	static String location;
	static boolean ready = false;

	synchronized boolean isAvailable() {
		return ready;
	}

	public Location() {
		this.initialize();
	}

	synchronized void initialize() {
		ready = false;
		location = new String("unknown location");
	}

	synchronized void setLocation(String l) {
		ready = true;
		location = new String(l);
		notifyAll();
	}
	
	synchronized String getLocation() {
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		} // while
		return location;
	} // getLocation
} // Location