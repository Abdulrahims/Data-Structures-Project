import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Itinerary {

	Scanner scan = new Scanner(System.in);
	
	private LinkedList<Node<Venue>> itinerary;
	private ItinCalc itinCalc;
	public static Location initialLoc;
	private int x, y;
	
	/**
	 * Constructor(): Runs everything from reading the database and making the trees, to creating the final Itinerary, and substituting Venues.
	 * @param initialLoc - Location object, picked from map
	 * @param venueTypes - LinkedList of desired Venue types
	 */
	
	public Itinerary(Location initialLoc, LinkedList<String> venueTypes) {
		Itinerary.initialLoc = initialLoc;
		this.x = initialLoc.getX(); this.y = initialLoc.getY();
		this.itinCalc = new ItinCalc(x, y, venueTypes); //Create ItinCalc object based on x,y - location, and options selected
		this.itinerary = new LinkedList<Node<Venue>>();
		
		for (int i = 0; i < venueTypes.size(); i++) {
			itinerary.add(itinCalc.trees.get(i).getMaxNode()); //Adds the best option of each tree to the itinerary LinkedList
		}
	}
	
	/**
	 * Replaces undesired Venue with the next best option.
	 * @param choice - Choice of venue to be replaced
	 */
	public void changeVenue(int choice) {
		
		Node<Venue> temp = itinerary.get(choice).nextBest();
		
		itinerary.remove(choice);
		
		itinerary.add(choice, temp);
	}
	
	public void printItinerary() {
		ListIterator<Node<Venue>> iter = itinerary.listIterator();
		while (iter.hasNext()) {
			Venue venue = iter.next().getData();
			System.out.println(venue.getRating() + " | " + venue.getType() + " | " + venue.getName());
		}
	}
	
	public LinkedList<Node<Venue>> getItinerary() {
		return itinerary;
	}
	
	public boolean hasA(String type) {
		ListIterator<Node<Venue>> iter = itinerary.listIterator();
		while (iter.hasNext()) {
			if (iter.next().getData().getType().equals(type)) return true;
		}
		return false;
	}
	
	public int indexOf(String type) {
		for (int i = 0; i < itinerary.size(); i++) {
			if (itinerary.get(i).getData().getType().equals(type)) return i;
		}
		return -1;
	}
}
