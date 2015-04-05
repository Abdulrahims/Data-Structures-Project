public class Venue { 
	
	private String type;
	private String name;
	private double rating;
	private String address;
	private int x, y;
	private int score;
	public Node<Venue> venueNode;
	
	public Venue(String type, String name, double rating, String address, int x, int y) {
		this.type = type;
		this.name = name;
		this.rating = rating;
		this.address = address;
		this.x = x;
		this.y = y;
		
		score = this.scoreCalc();
	}
	
	public int scoreCalc() {
		double score = rating*2;
		int deltaX = Math.abs(this.x - Itinerary.initialLoc.getX());
		int deltaY = Math.abs(this.y - Itinerary.initialLoc.getY());
		
		if (deltaX != 0 && deltaY != 0) score -= Math.sqrt((deltaX)^2 + (deltaY)^2);
		else if (deltaX != 0) score -= deltaX;
		else if (deltaY != 0) score -= deltaY;
		
		return (int)score;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getType() {
		return type;
	}
	
	public double getRating() {
		return rating;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}	
}
