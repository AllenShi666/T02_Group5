import javafx.collections.ObservableList;
/**
 * @author Team5
 * Interface that set the ObservableList &lt;Event&gt; strglobalEventList, it will always read from *.csv file as the application start
 *
 */
public interface EventArrayListClass {
	/**
	 * create the ImportEvent to import event from *.csv file to strglobalEventList
	 */
	ImportEvent Ie = new ImportEvent();

	public ObservableList<Event> strglobalEventList = Ie.ReadBoxFromCSV("Test.csv");

}
