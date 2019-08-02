import java.time.YearMonth;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

import java.time.LocalDate;

public class EventGUI implements EventArrayListClass {

	private VBox display = new VBox();
	private Label eventName = new Label("Event Name: ");
	private Label eventDescription = new Label("Event Description: ");
	private Label eventDate = new Label("Event Date (YYYY-MM-DD): ");
	private Button saveEvent = new Button("Save");
	private TextField typedName = new TextField();
	private TextField typedDate = new TextField();
	private TextField typedDes = new TextField();
	private Event eventVariable = new Event();
	
	
	
	
	
	public VBox getDisplay() {	
		
		HandleButtonAdd handleSave = new HandleButtonAdd("Save");
		
		
		display.getChildren().add(eventName);
		display.getChildren().add(typedName);
		display.getChildren().add(eventDate);
		display.getChildren().add(typedDate);
		display.getChildren().add(eventDescription);
		display.getChildren().add(typedDes);
		saveEvent.setOnAction( new EventHandler <ActionEvent> (){
			
			//What happens when save is hit - handler is executed manually inside GUI code
			@Override
			public void handle (ActionEvent a ) {
				
				eventVariable.setEvent_name(typedName.getText());
				eventVariable.setEvent_date(typedDate.getText());
				eventVariable.setEvent_description(typedDes.getText());
				globalEventList.add(eventVariable);
				
				//This gotta change after demo 2
				Event printEvent = globalEventList.get(0);
				
				System.out.println(printEvent.toString());
				
				
			}
			
		});
		display.getChildren().add(saveEvent);
		display.setPrefSize(300, 300);
		
		return display;
	}
	 
	public ArrayList <String> getTextFields() {
		
		ArrayList<String>returnStrings = new ArrayList<String>();
		
		returnStrings.add(typedName.getText());
		returnStrings.add(typedDate.getText());
		returnStrings.add(typedDes.getText());
		return returnStrings;
	}
	
	
}
