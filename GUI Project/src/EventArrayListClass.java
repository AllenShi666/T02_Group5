import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface EventArrayListClass {
	ImportEvent Ie = new ImportEvent();
	//public ArrayList<Event>globalEventList = Ie.ReadBoxFromCSV("Test.csv");
	public ObservableList<Event> strglobalEventList = Ie.ReadBoxFromCSV("Test.csv");
			//FXCollections.observableArrayList(
			
			//new Event("Your Event Name", "Your Event Date", "Your Event Description"));
}
