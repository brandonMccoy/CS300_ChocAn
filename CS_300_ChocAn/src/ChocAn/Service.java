package ChocAn;

import java.util.List;

public class Service implements IModel {
	
	public int code;
	public String name;

	/**Add, Delete, or Update this Service in the database. Or check to see if 
	 * this Service is already in the database.
	 * @param action tells the method whether to add, delete, update, or check 
	 * if the Service is in the database.
	 * @return Depending on the argument, returns true if Service is 
	 * successfully added, deleted, updated, or found in the Service database.
	 */
	@Override
	public Boolean Database(Action action) {
		Boolean response = false;
		if(action == Action.ADD) {
			response = db.AddService(this);
		}else if(action == Action.DELETE) {
			response = db.DeleteService(this.code);
		}else if(action == Action.UPDATE) {
			response = db.UpdateService(this);
		}else if(action == Action.EXISTS) {
			response = db.ServiceExists(this.code);
		}
		return response;
	}

	/**Searches the Service database for an object with a matching id.
	 * @param id of Service to find in the database
	 * @return A copy of the Service in the database that matches the id arg. 
	 * If a match is not found, an empty Service is returned with id = -1.
	 */
	@Override
	public Service Get(int code) {
		return db.GetService(code);
	}
	
	/**
	 * @return An unmodifiable list of all members in the memberDB database
	 */
	public List<Service> GetAll(){
		return db.AllServices();
	}

	/**
	 * @param code is the service code linked to the service name to return.
	 * @return The name of the service that matches the code argument.
	 */
	public String GetServiceName(int code) {
		return db.GetServiceName(code);
	}

	/**
	 * @param serviceName of the service that is linked to the service code to return.
	 * @return service code that matches the service name argument.
	 */
	public int GetServiceCode(String serviceName) {
		return db.GetServiceCode(serviceName);
	}

	/**Prints all Service variables to the console, 
	 * formatting specific to a Service type.
	 */
	@Override
	public void Print() {
		String message = "Name: " + name;
		message.concat(", code: " + code);
		System.out.println(message);
	}
}
