package game;
import java.util.HashMap;
import java.util.Set;

import fixtures.Item;
import fixtures.Room;

public class RoomManager {

  public static Room startingRoom;

  public static HashMap<Room, String> roomItemMap = new HashMap<>();
  public static Set<Room> roomKeys = roomItemMap.keySet();

  //---------------------------------------- * ITEMS * ------------------------------------------\\

  public static Item deadPlant = new Item("dead plant", "This plant looks like its been dead for days...");
  public static Item porcelainTrinket = new Item("porcelain trinket", "This porcelain trinket is an angel baby...");
  public static Item feather = new Item("ostrich feather",
	  "Dead animal parts are gross but cats love ostrich feathers...");
  public static Item pillow = new Item("pillow", "This pillow is very soft and fluffy...");
  public static Item dustBunny = new Item("dust bunny", "Only weirdos collect dust bunnies...");
  public static Item toiletPaper = new Item("toilet paper", "People hoard toilet paper because its end times...");
  public static Item drink = new Item("drink", "It is important to drink lots of fluids and this tour is long...");
  public static Item strayCat = new Item("stray cat",
	  "How did this cat get in here?! \nYou can give this cat your things."
		  + "\nFor example, if you have an ostrich feather in your booty bag, type 'give ostrich feather to cat'");
  public static Item soul = new Item("soul",
	  "This is where the architect lost their soul... you can give it to the cat...");
  public static Item penny = new Item("penny", "You can throw the penny in the fountain on your way out...");
  public static Item sculpture = new Item("sculpture fragment",
	  "This sculpture fragment looks like the index finger of a Roman god...");

  public static Item[] itemsArray = {deadPlant, porcelainTrinket, feather, pillow, dustBunny, toiletPaper, drink,
	  strayCat, soul, penny, sculpture};

  //---------------------------------------- * ROOMS * ------------------------------------------\\

  public static Room foyer = new Room("Foyer", "a small foyer",
	  "A lackluster two-story foyer with a signature McMansion above-door useless window/ inaccessible " + "\n"
		  + "balcony. Reminiscent of the dark entryway you may find in a strip mall phlebotomist's office, " + "\n"
		  + "adjacent to a \"We Buy Gold\" store. There is a marble table, an antique bench, and a dead plant.");

  public static Room formalLiving = new Room("Formal Living Room", "the main attraction",
	  "A display of opulence that tries to put Versailles to shame. Except for some exterior elements, this is " + "\n"
		  + "the only part of the house inspired by French decor. Extravagant and tacky outdoor columns indoors. "
		  + "\n" + "Out of control molding everywhere, faux marble, and chandeliers (yes, multiple), bronze, and "
		  + "\n" + "porcelain trinkets.");

  public static Room formalDining = new Room("Formal Dining Room", "where guests are fed",
	  "A tacky extension of the formal living room. A twelve foot table made of redwood and dead animals. " + "\n"
		  + "Elephant tusk table legs and ostrich skin stretched chairs. 🤮");

  public static Room mainSuite = new Room("Main Suite", "where the parents live",
	  "King sized bed with twenty pillows and wall to wall white carpeting. Like all McMansions go, " + "\n"
		  + "all the rooms where guests do not go are oddly devoid of furniture. ");

  public static Room maineSuiteStudy = new Room("Main Suite Study", "where business happens",
	  "Here you see a giant mahogany desk and floor to ceiling wood paneling. In fact, the ceiling is also covered "
		  + "\n"
		  + "in wood. There is a chandelier in here as well. It is dark and stuffy with a notable lack of books. ");

  public static Room maineSuiteBathroom = new Room("Main Suite Bathroom", "a large bathroom",
	  "This McMansion Main Suite bathroom comes with all the McMansion staples. A massive stand up shower with " + "\n"
		  + "five shower heads, a Jacuzzi with LED lights, two sinks and a giant fire place. ");

  public static Room maineSuiteSittingRoom = new Room("Main Suite Sitting Room", "where sitting happens",
	  "This room serves no function but is a must have when trying to impress your friends from the tennis club.");

  public static Room kitchen = new Room("Kitchen", "where food is made",
	  "Not much to see here. A giant fridge, laminate flooring, two islands, and insanely ugly foam injected crown "
		  + "\n" + "molding all over the place.");

  public static Room servantsQuarters = new Room("Servant's Quarters", "where the servants live",
	  "A real estate agent will tell you to put your in-laws here.");

  public static Room familyRoom = new Room("Family Room", "the informal room",
	  "This is where the family spends time when not entertaining guests so as not to wear out the finer things " + "\n"
		  + "in the formal living room. This room is bare with minimal furnishing and the only place where the children "
		  + "\n" + "are allowed to play.");

  public static Room patio = new Room("Patio", "be half outside half inside",
	  "Wall to wall astroturf and wicker furniture.");

  public static Room spiralStaircase = new Room("Spiral Staircase", "fancy stairs",
	  "A sad attempt of a Bramante Staircase... Upper floor and basement are not available for tour...");

  public static Room garage1 = new Room("Three Door Car Garage", "where cars are parked",
	  "A McMansion staple. If it doesn't have a three door garage, it's not a McMansion.");

  public static Room garage2 = new Room("Extra Car Garage", "where cars are parked #2",
	  "Taking McMansionism to a whole new level, the architect added another garage. This one only has two " + "\n"
		  + "doors because they read some where that the Japanese use asymmetry in their design. ");

  public static Room driveway = new Room("Driveway (with Fountain)", "be outside",
	  "Typical McMansion exterior cladding made of manufactured stone veneers, stucco board, vinyl siding, " + "\n"
		  + "and imitation wood. There is some loose change on the ground near the fountain.");

  public static Room poolDeck = new Room("Pool Deck/ Backyard Area", "the pool",
	  "An oddly shaped pool spattered with kitschy statues. There are columns all around the perimeter of " + "\n"
		  + "the pool-deck that don't connect to anything up top. ");

  public static Room[] rooms = {foyer, formalLiving, formalDining, mainSuite, maineSuiteStudy, maineSuiteBathroom,
	  maineSuiteSittingRoom, kitchen, servantsQuarters, familyRoom, patio, spiralStaircase, garage1, garage2, driveway,
	  poolDeck};

  //------------------------------------- * FUNCTION * -------------------------------------\\
  public static void init() {

	//------------------------- * STARTING ROOM * ------------------------- \\
	startingRoom = rooms[14];

	//-------------------------  * EXITS * ------------------------- \\
	rooms[0].exits = new Room[]{rooms[1], null, rooms[14], rooms[4]};
	rooms[1].exits = new Room[]{rooms[2], rooms[11], rooms[0], rooms[3]};
	rooms[2].exits = new Room[]{rooms[15], rooms[7], rooms[1], null};
	rooms[3].exits = new Room[]{rooms[6], rooms[1], rooms[5], null};
	rooms[4].exits = new Room[]{rooms[5], rooms[0], rooms[13], null};
	rooms[5].exits = new Room[]{rooms[3], null, rooms[4], null};
	rooms[6].exits = new Room[]{null, null, rooms[3], null};
	rooms[7].exits = new Room[]{rooms[9], null, rooms[8], rooms[2]};
	rooms[8].exits = new Room[]{rooms[7], null, null, null};
	rooms[9].exits = new Room[]{rooms[10], null, rooms[7], null};
	rooms[10].exits = new Room[]{null, null, rooms[9], rooms[15]};
	rooms[11].exits = new Room[]{null, null, rooms[12], rooms[1]};
	rooms[12].exits = new Room[]{rooms[11], null, null, rooms[14]};
	rooms[13].exits = new Room[]{rooms[4], rooms[14], null, null};
	rooms[14].exits = new Room[]{rooms[0], rooms[12], null, rooms[13]};
	rooms[15].exits = new Room[]{null, rooms[10], rooms[2], null};

	//-------------------------  * ROOM ITEM MAP * -------------------------\\

	roomItemMap.put(foyer, deadPlant.toString());
	roomItemMap.put(formalLiving, porcelainTrinket.toString());
	roomItemMap.put(formalDining, feather.toString());
	roomItemMap.put(mainSuite, pillow.toString());
	roomItemMap.put(maineSuiteStudy, dustBunny.toString());
	roomItemMap.put(maineSuiteBathroom, toiletPaper.toString());
	roomItemMap.put(kitchen, drink.toString());
	roomItemMap.put(familyRoom, strayCat.toString());
	roomItemMap.put(spiralStaircase, soul.toString());
	roomItemMap.put(driveway, penny.toString());
	roomItemMap.put(poolDeck, sculpture.toString());

  }//END init()

}
