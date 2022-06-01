package game;

import java.util.LinkedList;
import java.util.Scanner;

import fixtures.Item;
import fixtures.Room;

public class Main {

  static String[] command;
  static Player player;
  static boolean gameOver;

  static LinkedList<String> itemBag = new LinkedList<>();
  public static boolean isItemAvailable;

  //*********************************************** MAIN ***************************************************

  public static void main(String[] args) {

	isItemAvailable = false;
	gameOver = false;
	RoomManager.init();
	Player.currentRoom = RoomManager.startingRoom;

	printIntro();
	while (gameOver == false) {

	  try {
		collectInput();
		parse(command, player);

		printCurrentDirections();

	  } catch (IndexOutOfBoundsException e) {
		printErrorMessage();

	  }
	}

  }

  //*******************************************************************************************************
  //////////////////////////////////////////////////////////////////////////////////////////////

  public static void printIntro() {
	System.out.println("\n\n              Welcome to McMansion Hell (based on the website).\n\n\n"
		+ "Commands are presented in single quotes...\n\n" + "\u2022"
		+ " Type 'go north', 'go east', 'go south', or 'go west' to move from room to room.\n\n" + "\u2022"
		+ " Type 'look around' to explore the room you are currently in.\n\n" + "\u2022"
		+ " Type 'my booty' to see your hoard.\n\n" + "\u2022" + " Type 'exit game' to end the game."
		+ "\n\n      	    	     <> * <>   *   <> * <>   *   <> * <>         \n" + "\nYou are starting in the "
		+ Player.currentRoom.name + "." + "\n");

	if (Player.currentRoom.getExit("north") != null) {
	  System.out.println("  'go north' to " + Player.currentRoom.getExit("north").shortDes + "..." + "\n");
	}
	if (Player.currentRoom.getExit("east") != null) {
	  System.out.println("  'go east' to " + Player.currentRoom.getExit("east").shortDes + "..." + "\n");
	}
	if (Player.currentRoom.getExit("south") != null) {
	  System.out.println("  'go south' to " + Player.currentRoom.getExit("south").shortDes + "..." + "\n");
	}
	if (Player.currentRoom.getExit("west") != null) {
	  System.out.println("  'go west' to " + Player.currentRoom.getExit("west").shortDes + "...");
	}
	System.out.println("\nPick a direction or type 'look around' to explore this space...\n");
	System.out.print("-> ");

  }
  //////////////////////////////////////////////////////////////////////////////////////////////
  private static void printCurrentDirections() {

	System.out.println("\nYou are in the " + Player.currentRoom.name + "." + "\n");
	if (Player.currentRoom.getExit("north") != null) {
	  System.out.println("  'go north' to " + Player.currentRoom.getExit("north").shortDes + "..." + "\n");
	}
	if (Player.currentRoom.getExit("east") != null) {
	  System.out.println("  'go east' to " + Player.currentRoom.getExit("east").shortDes + "..." + "\n");
	}
	if (Player.currentRoom.getExit("south") != null) {
	  System.out.println("  'go south' to " + Player.currentRoom.getExit("south").shortDes + "..." + "\n");
	}
	if (Player.currentRoom.getExit("west") != null) {
	  System.out.println("  'go west' to " + Player.currentRoom.getExit("west").shortDes + "...");
	}
	System.out.println("\nPick a direction or type 'look around' to explore this space...\n");
	System.out.print("-> ");

  }

  //////////////////////////////////////////////////////////////////////////////////////////////

  private static String[] collectInput() {
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	command = in.nextLine().split(" ");
	return command;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////
  //  private static void printRoom(Player player) {    //I didn't end up using it but it works.
  //	System.out.println(player.currentRoom.getName());
  //  }
  //////////////////////////////////////////////////////////////////////////////////////////////

  private static void parse(String[] command, Player player) {
	String action = command[0];
	String target = command[1];

	switch (action) {
	  //------------------------------------* GO *--------------------------------------\\
	  case "go" :
		Player.currentItem = null;
		switch (target) {

		  case "north" :
			if (Player.currentRoom.getExit("north") != null) {
			  Player.currentRoom = Player.currentRoom.getExit("north");
			  printLine();
			}
			break;
		  case "east" :
			if (Player.currentRoom.getExit("east") != null) {
			  Player.currentRoom = Player.currentRoom.getExit("east");
			  printLine();
			}
			break;
		  case "south" :
			if (Player.currentRoom.getExit("south") != null) {
			  Player.currentRoom = Player.currentRoom.getExit("south");
			  printLine();
			}
			break;
		  case "west" :
			if (Player.currentRoom.getExit("west") != null) {
			  Player.currentRoom = Player.currentRoom.getExit("west");
			  printLine();
			}
			break;
		  default :
			printErrorMessage();
			break;
		}
		break;
	  case "give" :
		Player.currentItem = null;
		catchWords(command);
		break;
	  //------------------------------------* LOOK *--------------------------------------\\
	  case "look" :
		Player.currentItem = null;
		switch (target) {
		  case "around" :
			System.out.println(
				"\n----------------------------------------------------------------------------------------------"
					+ "\n----------------------------------------------------------------------------------------------\n");
			System.out.println(
				"                     - " + Player.currentRoom.name + " - \n" + "\n" + Player.currentRoom.longDes);
			showRoomItem();
			break;
		  default :
			printErrorMessage();
			break;
		}//------------------* PICK * KEEP * PUT * MY BOOTY *-------------------\\
		break;

	  case "pick" :

		switch (target) {
		  case "up" :
			if (Player.currentItem != null) {
			  printLine();
			  pickUp();
			  break;
			}
			break;
		  default :
			printErrorMessage();
			break;
		}
		//break;
	  case "keep" :

		switch (target) {
		  case "it" :
			if (Player.currentItem != null && !Player.currentItem.equals("stray cat")) {
			  keepIt();
			  break;

			}

		}
		break;
	  case "put" :

		switch (target) {
		  case "down" :
			Player.currentItem = null;
			break;

		  default :
			printErrorMessage();
			break;
		}
		break;
	  case "my" :
		Player.currentItem = null;
		switch (target) {
		  case "booty" :
			System.out.println("\n\n    Your Booty: " + "\n" + itemBag + "\n");

			break;
		  default :
			printErrorMessage();
			break;
		}
		break;

	  //------------------------------------* EXIT *--------------------------------------\\
	  case "exit" :
		switch (target) {
		  case "game" :
			System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+ "\n<<<<<<<<<<<<<<                                    >>>>>>>>>>>>>>"
				+ "\n<<<<<<<<<<<<<<                                    >>>>>>>>>>>>>>"
				+ "\n<<<<<<<<<<<<<<   thank you for taking the tour    >>>>>>>>>>>>>>"
				+ "\n<<<<<<<<<<<<<<                                    >>>>>>>>>>>>>>"
				+ "\n<<<<<<<<<<<<<<                                    >>>>>>>>>>>>>>"
				+ "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			gameOver = true;
			break;
		}
		break;

	  default :
		printErrorMessage();
		break;
	}
  }//END parse()

  //////////////////////////////////////////////////////////////////////////////////////////////

  public static String showRoomItem() { //checks to see if room has item, if so, displays it
	for (Room room : RoomManager.roomKeys) {
	  if (room.equals(Player.currentRoom)) {
		Room key = room;
		String itemValue = RoomManager.roomItemMap.get(key);
		System.out.println("\n 'pick up' " + itemValue + "\n");
		Player.currentItem = itemValue;
		isItemAvailable = false;
		return Player.currentItem;
	  }
	}
	return null;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////

  public static boolean pickUp() { //shows details about items and asks if you want to keep it

	for (Item i : RoomManager.itemsArray) {
	  if (Player.currentItem.equals(i.getName())) {
		System.out.println("\n" + i.getShortDes() + "\n\n 'keep it' or 'put down'\n");
		isItemAvailable = true;
	  }
	}
	return isItemAvailable;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////
  public static void keepIt() { //keep item - add item to 

	if (isItemAvailable == true) {

	  if (!itemBag.contains(Player.currentItem)) {
		if (!Player.currentItem.equals("stray cat")) {
		  itemBag.add(Player.currentItem);
		}

	  }
	  System.out.println("\n\n    Your Booty: " + "\n" + itemBag + "\n");
	}
  }
  //////////////////////////////////////////////////////////////////////////////////////////////

  public static void catchWords(String[] command) { //There must be a better way to do this...

	for (String itemX : itemBag) {

	  if (!itemX.contains(" ")) { //single word named items
		if (itemX.equals(command[1])) {
		  if (command[2].equals("to")) {
			if (command[3].equals("cat")) {
			  System.out.println("\n  " + "\uD83D\uDC08" + " cat is happy \n  cat loves " + itemX);
			  Player.currentItem = itemX;
			  itemBag.remove(itemX);

			}
		  }

		}
	  }

	  if (itemX.contains(" ")) { //double word named items

		String[] itemLongNames = itemX.split(" ");
		if (itemLongNames[0].equals(command[1]) && !itemX.equals("stray cat")) {
		  if (itemLongNames[1].equals(command[2])) {
			if (command[3].equals("to")) {
			  if (command[4].equals("cat")) {
				System.out.println("\n  " + "\uD83D\uDC08" + " cat is happy \n  cat loves " + itemX);
				Player.currentItem = itemX;
				itemBag.remove(itemX);
			  }
			}
		  }
		}
	  }
	}
  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  private static void printErrorMessage() {

	System.out.println("\n      	    	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
		+ "      	    	 |  Please type in correct instructions.  |\n"
		+ "      	          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

  }
  //////////////////////////////////////////////////////////////////////////////////////////////
  private static void printLine() {
	System.out
		.println("\n----------------------------------------------------------------------------------------------");
  }

}
