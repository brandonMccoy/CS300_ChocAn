package ChocAn;

public interface Model {

	public enum Action {ADD, DELETE, UPDATE, EXISTS};
	public static Database db = new Database();
	public Boolean Database(Action action);
	public Model Get(int id);
	public void Print();
}
