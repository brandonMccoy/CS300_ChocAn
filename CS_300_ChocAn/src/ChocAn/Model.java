package ChocAn;

public interface IModel {

	public enum Action {ADD, DELETE, UPDATE, EXISTS};
	public static Database db = new Database();
	public Boolean Database(Action action);
	public IModel Get(int id);
	public void Print();
}
