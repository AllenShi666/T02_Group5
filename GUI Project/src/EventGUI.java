import java.time.YearMonth;

import java.util.ArrayList;
import java.util.Date;

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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 

/**
 * 
 * @author hechen
 * Event GUI code that displays UI on adding a new event to the calendar.
 */
public class EventGUI implements EventArrayListClass {

	
	//Variables for the Add Event GUI screen
	private ImportEvent ie = new ImportEvent();
	private VBox display = new VBox();
	private Label eventName = new Label("Event Name: ");
	private Label eventDescription = new Label("Event Description: ");
	private Label eventDate = new Label("Event Date (YYYY-MM-DD): ");
	private Label eventStartTime = new Label("Event Start Time (24Hr. HH:MM): ");
	private Label eventEndTime = new Label("Event End Time (24Hr. HH:MM): ");
	private Alert dateAlert = new Alert(AlertType.WARNING);
	private Button saveEvent = new Button("Save");
	private TextField typedName = new TextField();
	private TextField typedDate = new TextField();
	private TextField typedDes = new TextField();
	private TextField typedStartTime = new TextField();
	private TextField typedEndTime = new TextField();
	private Event eventVariable = new Event();
	
	/**
	 * 
	 * @return VBox Returns the display back to user when called on by clicking "Add Event" from Month Calendar view
	 * 
	 */
	public VBox getDisplay() {	
		
		HandleButtonAdd handleSave = new HandleButtonAdd("Save");
		
		
		display.getChildren().add(eventName);
		display.getChildren().add(typedName);
		display.getChildren().add(eventDate);
		display.getChildren().add(typedDate);
		display.getChildren().add(eventDescription);
		display.getChildren().add(typedDes);
		display.getChildren().add(eventStartTime);
		display.getChildren().add(typedStartTime);
		display.getChildren().add(eventEndTime);
		display.getChildren().add(typedEndTime);
		saveEvent.setOnAction( new EventHandler <ActionEvent> (){
			
			/*What happens when "Save" in the Add Event screen is hit - handler is executed manually inside GUI code
			To get around the the default handle in the handle button add class*/
			@Override
			public void handle (ActionEvent a) {
			
				eventVariable.setEvent_name(typedName.getText());
				
				//eventVariable.setEvent_date(typedDate.getText());
				
				eventVariable.event_Date_Time = eventVariable.eventString_to_Date(typedDate.getText());
				
				eventVariable.setEvent_description(typedDes.getText());
				
				eventVariable.setEvent_StartTime(typedStartTime.getText());
				
				eventVariable.setEvent_EndTime(typedEndTime.getText());
				
				Event printEvent = eventVariable;
				if(typedName.getText().isEmpty() || typedDate.getText().isEmpty() || typedDes.getText().isEmpty() 
						|| typedStartTime.getText().isEmpty() || typedEndTime.getText().isEmpty()) {
					
				}else {
					strglobalEventList.add(eventVariable);
				
				    ie.ExportCSV(printEvent);}
				
				    System.out.println("Success: " + printEvent.toString());
				    System.out.println("Success: EventGUI Line 86 (Date) " + printEvent.event_Date_Time);
				
				Stage stage = (Stage) saveEvent.getScene().getWindow();
				stage.close();}
				
		
			
				
				
			
			
		});
		display.getChildren().add(saveEvent);
		display.setPrefSize(300, 300);
		
		return display;
	}

	
}
