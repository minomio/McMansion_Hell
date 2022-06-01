package fixtures;

public class Item extends Fixture {

  public Item(String name, String shortDes) {

	this.name = name;
	this.shortDes = shortDes;

  }

  public String getName() {
	return this.name;
  }
  public String getShortDes() {
	return this.shortDes;
  }

  public String toString() {
	return String.format(name);
  }

}
