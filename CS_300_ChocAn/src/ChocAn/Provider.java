package ChocAn;

import java.util.List;

public class Provider extends UserModel {

	Provider(){
		id = -1;
		name = "";
		street = "";
		city = "";
		state = "";
		zip = -1;
	}
	
	/// Logic for adding, deleting, updating, or finding this provider
	/// Returns true if Provider is successfully added, deleted, or updated in the memberDB database.
	/// Returns true if this Provider is found in the providerDB database.
	@Override
	public Boolean Database(Action action) {
		Boolean response = false;
		if(action == Action.ADD) {
			response = db.AddProvider(this);
		}else if(action == Action.DELETE) {
			response = db.DeleteProvider(this.id);
		}else if(action == Action.UPDATE) {
			response = db.UpdateProvider(this);
		}else if(action == Action.EXISTS) {
			response = db.ProviderExists(this.id);
		}
		return response;
	}
	
	/// Searches the providerDB database for an object with a matching id.
	/// Returns a copy of the Provider found. If a matching Provider is not found, 
	/// then a Provider object with id = -1 is returned
	@Override
	public Provider Get(int id) {
		return db.GetProvider(id);
	}
	
	/// Returns an unmodifiable list of all providers in the providerDB database
	public List<Provider> GetAll(){
		return db.AllProviders();
	}

	@Override
	public void Print() {
		System.out.println();
		System.out.println("== Provider ===============");
		System.out.println();
		super.Print();
	}
}
