package ChocAn;

public class Member extends UserModel {

	public boolean suspended;
	
	@Override
	public void Print() {
		System.out.println();
		System.out.println("== Member ===============");
		System.out.println();
		super.Print();
		System.out.println("Suspended: " + (suspended?"yes":"no"));
	}
}
