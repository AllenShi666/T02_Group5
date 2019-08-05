import java.time.YearMonth;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EventGUI implements EventArrayListClass {

	
	//Variables for the Add Event GUI screen
	private VBox display = new VBox();
	private Label eventName = new Label("Event Name: ");
	private Label eventDescription = new Label("Event Description: ");
	private Label eventDate = new Label("Event Date (YYYY-MM-DD): ");
	private Button saveEvent = new Button("Save");
	private TextField typedName = new TextField();
	private TextField typedDate = new TextField();
	private TextField typedDes = new TextField();
	private Event eventVariable = new Event();
	
	//Variables for the View Event GUI screen
	private VBox viewEventsDisplay = new VBox();
	private Label viewEventsname = new Label("Event Name: ");
	private Label viewEventsDate = new Label("Event Date: ");
	private Label viewEventsTime = new Label("Event Time: ");
	private HBox viewEventsTitle = new HBox();
	private HBox viewEventContents = new HBox();
	private VBox viewEventContent1 = new VBox();
	private VBox viewEventContent2 = new VBox();
	private VBox viewEventContent3 = new VBox();
	private TableView viewEventTable = new TableView();
	
	
	
	
	public VBox getDisplay() {	
		
		HandleButtonAdd handleSave = new HandleButtonAdd("Save");
		
		
		display.getChildren().add(eventName);
		display.getChildren().add(typedName);
		display.getChildren().add(eventDate);
		display.getChildren().add(typedDate);
		display.getChildren().add(eventDescription);
		display.getChildren().add(typedDes);
		saveEvent.setOnAction( new EventHandler <ActionEvent> (){
			
			//What happens when "Save" in the Add Event screen is hit - handler is executed manually inside GUI code
			@Override
			public void handle (ActionEvent a) {
				
				eventVariable.setEvent_name(typedName.getText());
				eventVariable.setEvent_date(typedDate.getText());
				eventVariable.setEvent_description(typedDes.getText());
				globalEventList.add(eventVariable);
				strglobalEventList.add(eventVariable);
				
				
				Event printEvent = eventVariable;
				
				System.out.println(printEvent.toString());
				
				Stage stage = (Stage) saveEvent.getScene().getWindow();
				stage.close();
				
				
			}
			
		});
		display.getChildren().add(saveEvent);
		display.setPrefSize(300, 300);
		
		return display;
	}
	
	public VBox getViewEventDisplay() {
		
		
		viewEventTable.setEditable(false);
		TableColumn eventNameCol = new TableColumn("Event Name");
		eventNameCol.setMinWidth(150);
		eventNameCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_name"));
		TableColumn eventDateCol = new TableColumn("Event Date");
		eventDateCol.setMinWidth(120);
		eventDateCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_date"));
		TableColumn eventDesCol = new TableColumn("Event Description");
		eventDesCol.setMinWidth(400);
		eventDesCol.setCellValueFactory(new PropertyValueFactory<Event, String>("event_description"));
		
		viewEventTable.setItems(strglobalEventList);
		viewEventTable.getColumns().addAll(eventNameCol, eventDateCol, eventDesCol);
		
		
		
		
		
		viewEventsDisplay.getChildren().add(viewEventsTitle);
		viewEventsDisplay.getChildren().add(viewEventContents);
		viewEventsDisplay.getChildren().add(viewEventTable);
		
		
		
		
		
		
		
		return viewEventsDisplay;
	}
	
	
	 
	public ArrayList <String> getTextFields() {
		
		ArrayList<String>returnStrings = new ArrayList<String>();
		
		returnStrings.add(typedName.getText());
		returnStrings.add(typedDate.getText());
		returnStrings.add(typedDes.getText());
		return returnStrings;
	}
	
	public void shutWindow(Stage StageWindow) {
		
		StageWindow.close();
	}
	
	
}
