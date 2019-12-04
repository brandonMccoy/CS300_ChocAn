package ChocAn;

import java.util.List;

public class Member extends UserModel {

	public boolean isSuspended;
	
	Member(){
		isSuspended = false;
	}
	
	/**Add, Delete, or Update this Member in the database. Or check to see if 
	 * this Member is already in the database.
	 * @param action tells the method whether to add, delete, update, or check 
	 * if the Member is in the database.
	 * @return Depending on the argument, returns true if Member is 
	 * successfully added, deleted, updated, or found in the Member database.
	 */
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
	

	/**Searches the member database for an object with a matching id.
	 * @param id of member to find in the database
	 * @return A copy of the member in the database that matches the id arg. 
	 * If a match is not found, an empty Member is returned with id = -1.
	 */
	@Override
	public Member Get(int id) {
		return db.GetMember(id);
	}
	
	/**
	 * @return An unmodifiable list of all members in the member database.
	 */
	public List<Member> GetAll(){
		return db.AllMembers();
	}
	
	/**
	 * @param status Set member isSuspended equal to status.
	 */
	public void SetSuspension(Boolean status) {
		isSuspended = status;
		db.SetMemberSuspension(id, status);
	}
	
	/**Prints all Member variables to the console, 
	 * formatting specific to a Provider type.
	 */
	@Override
	public void Print() {
		System.out.println();
		System.out.println("== Member ===============");
		System.out.println();
		super.Print();
		System.out.println("Suspended: " + (isSuspended?"yes":"no"));
	}	
}
