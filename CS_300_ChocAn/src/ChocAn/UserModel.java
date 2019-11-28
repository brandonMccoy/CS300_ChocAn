package ChocAn;

public class UserModel implements IModel {

	public int id;// id cannot start with 0
	public String name;
	public String street;
	public String city;
	public String state;
	public String zip;
	
	UserModel(){
		id = -1;
		name = "";
		street = "";
		city = "";
		state = "";
		zip = "";
	}
	
	@Override
	public void Print() {
		System.out.println("     ID: " + id);
		System.out.println("   Name: " + name);
		System.out.println("Address: " + street);
		System.out.println("   City: " + city);
		System.out.println("  State: " + state);
		System.out.println("    Zip: " + zip);
	}

	@Override
	public Boolean Database(Action action) {
		return true;
	}
	
	@Override
	public IModel Get(int id) {
		// search database for matching model
		return null;
	}
}
