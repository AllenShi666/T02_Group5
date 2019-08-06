import java.util.Date;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class viewEventGUI implements EventArrayListClass{
	//Variables for the View Event GUI screen
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
		
		public VBox getViewEventDisplay() {
			
			
			viewEventTable.setEditable(false);
			TableColumn eventNameCol = new TableColumn("Event Name");
			eventNameCol.setMinWidth(150);
			eventNameCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_name"));
			
			TableColumn eventDateCol = new TableColumn("Event Date");
			eventDateCol.setMinWidth(120);
			eventDateCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_date"));
			
			TableColumn eventStartTimeCol = new TableColumn("Event Start Time");
			eventStartTimeCol.setMinWidth(120);
			eventStartTimeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_StartTime"));
			System.out.println("L38:: this is a startTime value"+ strglobalEventList.get(0).event_StartTime);
			
			TableColumn eventEndTimeCol = new TableColumn("Event End Time");
			eventEndTimeCol.setMinWidth(120);
			eventEndTimeCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_EndTime"));
			
			TableColumn eventDesCol = new TableColumn("Event Description");
			eventDesCol.setMinWidth(400);
			eventDesCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_description"));
			//System.out.println("viewEventGUI.L36:: This is strglobalVenetList string date for entry 1: \n"+ strglobalEventList.get(1).event_date);
			System.out.println("vewEventGUI.L47:: This is the latest event added: \n" + strglobalEventList.get(0).event_date);
			
			viewEventTable.setItems(strglobalEventList);
			viewEventTable.getColumns().addAll(eventNameCol, eventDateCol, eventStartTimeCol, eventEndTimeCol, eventDesCol);
			
			
			viewEventsDisplay.getChildren().add(viewEventsTitle);
			viewEventsDisplay.getChildren().add(viewEventContents);
			viewEventsDisplay.getChildren().add(viewEventTable);
			
			
			return viewEventsDisplay;
		}
}
