package ChocAn;

import java.util.List;

public class Service implements Model {
	
	public int code;
	public String name;
	
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
	
	@Override
	public Service Get(int code) {
		return db.GetService(code);
	}
	
	/// Returns an unmodifiable list of all members in the memberDB database
	public List<Service> GetAll(){
		return db.AllServices();
	}
	
	public String GetServiceName(int code) {
		return db.GetServiceName(code);
	}
	
	public int GetServiceCode(String serviceName) {
		return db.GetServiceCode(serviceName);
	}
	
	@Override
	public void Print() {
		String message = "Name: " + name;
		message.concat(", code: " + code);
		System.out.println(message);
	}
}