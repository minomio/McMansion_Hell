package fixtures;

public class Room extends Fixture {

  public Room[] exits;

  //------------------------------------- * CONSTRUCTOR * -------------------------------------\\

  public Room(String name, String shortDes, String longDes) {
	super(); //references name & descriptions from fixture
	this.name = name;
	this.shortDes = shortDes;
	this.longDes = longDes;
	this.exits = new Room[4];

  }
  //------------------------------------- * GETTERS * -------------------------------------\\
  public Room[] getExits() {
	return exits;
  }

  public Room getExit(String direction) {
	if (direction == "north") {
	  return exits[0];
	} else if (direction == "east") {
	  return exits[1];
	} else if (direction == "south") {
	  return exits[2];
	} else if (direction == "west") {
	  return exits[3];
	}
	return null;
  }//END getExit

  public String getName() {
	return this.name;
  }

}
