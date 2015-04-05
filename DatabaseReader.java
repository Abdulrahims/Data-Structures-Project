import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseReader {
	
	private String docName;
	
	public DatabaseReader(String docName) {
		this.docName = docName;
	}
	
	/**
	 * Reads filename from a certain x,y-location on the grid, and proceeds 
	 * to read and store the linked file into a two-dimensional String array
	 * @param xCoor
	 * @param yCoor
	 * @return Two-dimensional String array
	 */
	public static ArrayList<String[]> getVenues(int xCoor, int yCoor) {
		
		DatabaseReader fileNames = new DatabaseReader("grid.csv");
		ArrayList<String[]> fileName = fileNames.read();
		
		DatabaseReader dataRead = new DatabaseReader(fileName.get(xCoor)[yCoor]);
		ArrayList<String[]> venues = dataRead.read();
		
		return venues;
	}
	
	/**
	 * Reads and stores information into a ArrayList of String arrays
	 * @return ArrayList of String arrays
	 */
	public ArrayList<String[]> read() {
		
		ArrayList<String[]> a = new ArrayList<String[]>();
		
		
		File file = new File(docName);
		try {
			Scanner data = new Scanner(file); 
			if (data.hasNext()) {
				data.next();
				while (data.hasNext()) {
					String values = data.next();
					String[] value = values.split(",");
					a.add(value);
				}
				data.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return a;
	}
}
