import java.io.IOException;
import java.util.LinkedList;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		boolean restart = false;
		
		do {
			System.out.println();
			
			restart = false;
			
			LinkedList<String> venueTypes = new LinkedList<String>();
			
			GUI choices = new GUI();
			venueTypes = choices.getVenueTypes();
			
			while (choices.isRunning()) {
				for (int i = 0; i < 1000000; i++)
					if (i == 999999) 
						System.out.println();
			}
						
			MapFrame locationFinder = new MapFrame();
			locationFinder.setVisible(true);
						
			while (locationFinder.isRunning()) { // Keep window running until location is picked
				for (int i = 0; i < 1000000; i++)
					if (i == 999999) 
						System.out.println(); // Synchronize methods
			}
			locationFinder.dispose();
			
			Location loc = new Location(locationFinder.getX(), locationFinder.getY());
			
			Itinerary itinerary = new Itinerary(loc, venueTypes);
			
			ItineraryGUI finalItinerary = new ItineraryGUI(itinerary);
			
			while (finalItinerary.isRunning()) { // Keep window running until location is picked
				for (int i = 0; i < 1000000; i++)
					if (i == 999999) 
						System.out.println(); // Synchronize methods
				restart = finalItinerary.restart();
			}
			finalItinerary.dispose();
			
		} while (restart);
			
	}
}
