import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Team5
 * Code that displays the view event stage that allows users to view all inputted events
 *
 */
public class viewEventGUI implements EventArrayListClass{
	//Variables for the View Event GUI screen
	/* Creating variables for table view of View events
	 * These are GUI objects organized to display user events in a methodical manner.
	 */
		private VBox viewEventsDisplay = new VBox();
		private Label viewEventsname = new Label("Event Name: ");
		private Label viewEventsDate = new Label("Event DateTest: ");
		private Label viewEventsTime = new Label("Event Time: ");
		private HBox viewEventsTitle = new HBox();
		private HBox viewEventContents = new HBox();
		private VBox viewEventContent1 = new VBox();
		private VBox viewEventContent2 = new VBox();
		private VBox viewEventContent3 = new VBox();
		private TableView viewEventTable = new TableView();
		
		/*
		 * Method that opens view event display. Initializes the table view columns
		 */
		
		public VBox getViewEventDisplay() {
			
			
			viewEventTable.setEditable(true);
			TableColumn eventNameCol = new TableColumn("Event Name");
			eventNameCol.setMinWidth(150);
			eventNameCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_name"));
			
			TableColumn eventDateCol = new TableColumn("Event Date");
			eventDateCol.setMinWidth(120);
			eventDateCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_date"));
			
			TableColumn eventStartTimeCol = new TableColumn("Event Start Time");
			eventStartTimeCol.setMinWidth(120);
			eventStartTimeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_StartTime"));
			
			TableColumn eventEndTimeCol = new TableColumn("Event End Time");
			eventEndTimeCol.setMinWidth(120);
			eventEndTimeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_EndTime"));
			
			TableColumn eventDesCol = new TableColumn("Event Description");
			eventDesCol.setMinWidth(400);
			eventDesCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_description"));
			
			viewEventTable.setItems(strglobalEventList);
			viewEventTable.getColumns().addAll(eventNameCol, eventDateCol, eventStartTimeCol, eventEndTimeCol, eventDesCol);
			
			eventNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	   		eventNameCol.setSortable(false);
	   		eventDateCol.setSortable(false);
	   	    eventStartTimeCol.setSortable(false);
	   		eventEndTimeCol.setSortable(false);
	   		eventDesCol.setSortable(false);
			
			viewEventsDisplay.getChildren().add(viewEventsTitle);
			viewEventsDisplay.getChildren().add(viewEventContents);
			viewEventsDisplay.getChildren().add(viewEventTable);
	
			return viewEventsDisplay;
			
		}
		public void changeEventName(CellEditEvent editCell) {
	   		 
	   		 Event eventSelected = (Event) viewEventTable.getSelectionModel().getSelectedItem();
	   		 eventSelected.setEvent_name(editCell.getNewValue().toString());
	   		 
	   	 }
}
