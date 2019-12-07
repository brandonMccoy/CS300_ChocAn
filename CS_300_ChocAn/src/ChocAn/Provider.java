package ChocAn;

import java.util.List;

public class Provider extends UserModel {

	/**Add, Delete, or Update this Provider in the database. Or check to see if 
	 * this Provider is already in the database.
	 * @param action tells the method whether to add, delete, update, or check 
	 * if the Provider is in the database.
	 * @return Depending on the argument, returns true if Provider is 
	 * successfully added, deleted, updated, or found in the provider database.
	 */
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
	
	/**Searches the provider database for an object with a matching id.
	 * @param id of the Provider to locate in the database.
	 * @return A copy of the Provider found. If a matching Provider is not 
	 * found, then a Provider object with id = -1 is returned.
	 */
	@Override
	public Provider Get(int id) {
		return db.GetProvider(id);
	}
	
	/**
	 * @return An unmodifiable list of all providers in the provider database.
	 */
	public List<Provider> GetAll(){
		return db.AllProviders();
	}

	/**Prints all Provider variables to the console, 
	 * formatting specific to a Provider type.
	 */
	@Override
	public void Print() {
		System.out.println();
		System.out.println("== Provider ===============");
		System.out.println();
		super.Print();
	}
}
