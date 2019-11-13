package ChocAn;

import java.util.List;

public class Member extends UserModel {

	public boolean suspended;
	public enum Status {INVALID, VALID, SUSPENDED}
	public Status status;
	
	Member(){
		id = -1;
		name = "";
		street = "";
		city = "";
		state = "";
		zip = -1;
		suspended = true;
		status = Status.INVALID;
	}
	/// Logic for adding, deleting, updating, or finding this member
	@Override
	public Boolean Database(Action action) {
		Boolean response = false;
		if(action == Action.ADD) {
			response = db.AddMember(this);
		}else if(action == Action.DELETE) {
			response = db.DeleteMember(this.id);
		}else if(action == Action.UPDATE) {
			response = db.UpdateMember(this);
		}else if(action == Action.EXISTS) {
			response = db.MemberExists(this.id);
		}
		return response;
	}
	
	/// Searches the memberDB database for an object with a matching id.
	/// Returns a copy of the meember found. If a matching member is not found, 
	/// then a member object with id = -1 is returned
	@Override
	public Member Get(int id) {
		return db.GetMember(id);
	}
	
	/// Returns an unmodifiable list of all members in the memberDB database
	public List<Member> GetAll(){
		return db.AllMembers();
	}
	
	@Override
	public void Print() {
		System.out.println();
		System.out.println("== Member ===============");
		System.out.println();
		super.Print();
		System.out.println("Suspended: " + (suspended?"yes":"no"));
	}	
}
