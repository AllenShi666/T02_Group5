import javafx.collections.ObservableList;

public interface EventArrayListClass {
	
	ImportEvent Ie = new ImportEvent();

	public ObservableList<Event> strglobalEventList = Ie.ReadBoxFromCSV("Test.csv");

}
