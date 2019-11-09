package ChocAn;

public abstract class UserModel implements Model {

	public int id;
	public String name;
	public String street;
	public String city;
	public String state;
	public int zip;
	
	@Override
	public void Print() {
		System.out.println("     ID: " + id);
		System.out.println("   Name: " + name);
		System.out.println("Address: " + street);
		System.out.println("   City: " + city);
		System.out.println("  State: " + state);
		System.out.println("    Zip: " + zip);
	}
}
