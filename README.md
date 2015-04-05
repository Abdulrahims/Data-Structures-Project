# Data-Structures-Project
Final project for Algorithms &amp; Data Structures 

Team members:
Abdul Sheikhnureldin
Remi Galvez
Jeremy Glassman
Akbar Sattar

Team Allez
Remi Galvez, Jeremy Glassman, Akbar Sattar, Abdul Sheikhnureldin

The purpose of this program is to create an itinerary/plan for a user’s night outing, based on a user selection of different types of venues, such as a club, bar, or restaurant. The program picks out the best options for the user, based on location input, and a score calculator that prioritizes convenience based on location, and the venue’s ratings. (Note: Some of the venues are made up and do not exist)
The program begins with a GUI that allows the user to choose whether they would like to go to a club, bar, and/or restaurant (the user may select all three options). Next, the user is taken to a map of D.C., which includes locations such as Foggy Bottom, Georgetown, DuPont Circle, U Street, and other areas, where the user must click on the map to indicate their desired or current location. This coordinates information is then stored, and the program will parse information from a database to confirm or deny entry. An added feature would be the implementation of user profiles, where the user can set preferences. These functions will simply be organized methods in the main class. After the user selects all their preferences, the program will generate a plan for the user’s outing. 
        	
	The GUI map was created using jFrames, and was split into an invisible 5x5 grid. The image was taken from a screenshot of Google Maps. When the user clicks on a spot on the map, the program generates a pointer object with those (x,y) coordinates. This data will be used in a recursive function to parse an excel spreadsheet systematically, and generate a tree of the venues that match the user’s description, as explained later in this document. 
        	All information about the venues is organized into a database, based on location. The database consists of a unique grid, which has the names of the spreadsheets linked with the specified locations, and the linked spreadsheets. The latter categorize the venues into individual spreadsheets, based on location, and give basic information for each of the venues. Using a GUI that displays a map of Foggy Bottom, Georgetown, DuPont Circle, and other areas of Downtown D.C., a user is able to select their location by clicking on the map, which will save their location as a coordinate. These coordinates are used in conjunction with the coordinate locations of the different venues as pulled from the database.
         	The program must then read information from the appropriate spreadsheet, and the ones directly surrounding it on the grid. To access this information, the program must read the name of the targeted documents from the grid, and  create ‘Venue’ objects from the information stored in the opened spreadsheets. These objects are then stored into an ArrayList. An ArrayList is useful here as it will not be modified throughout the execution of the program, and will easily add as many venues as there are on the spreadsheet.
        	From there, the program will sort the venues into binary trees according to their type (Bar, Restaurant, etc.), and their score, calculated from their general rating, and proximity. Binary trees are very efficient in sorting the venues as they are ordered progressively as they are added, rather than sorted at the end with final sorting algorithms.
        	The final itinerary will then be created by storing the best venue option for each choice into a LinkedList. The LinkedList will facilitate itinerary modifications, in case one option is refused by the user. The user is also able to remove an option from the itinerary if they do not like it, and the next best option will appear. These functionalities are all interactive through the GUI and allows for easy usage by the user.
