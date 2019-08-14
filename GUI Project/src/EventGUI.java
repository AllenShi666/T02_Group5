import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 

/**
 * @author Team5
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
			To get around the the default handle in the handle button add class. Nested if-elseif-else statement just did 
			format checking on date and time, if format does not match, throws an warning error*/
			@Override
			public void handle (ActionEvent a) {
			    String inputDate= typedDate.getText();
			    String inputTimeStart=typedStartTime.getText();
			    String inputTimeEnd=typedEndTime.getText();
			    String checkYear="2019-13-13";
			    String STsub1="45", STsub2="45", ETsub1="45", ETsub2="45";
			    int STnum1=45, STnum2=45, ETnum1=45, ETnum2=45;
			    if (inputTimeStart.lastIndexOf(':')!=-1||inputTimeEnd.lastIndexOf(':')!=-1) {
			    	
			    	int indexCol= inputTimeStart.lastIndexOf(':');
			    	STsub1=inputTimeStart.substring(0, indexCol);
			    	STsub2=inputTimeStart.substring(indexCol+1);
			    	indexCol= inputTimeEnd.lastIndexOf(':');
			    	ETsub1=inputTimeEnd.substring(0, indexCol);
			    	ETsub2=inputTimeEnd.substring(indexCol+1);
			    	STnum1=Integer.parseInt(STsub1);
			    	STnum2=Integer.parseInt(STsub2);
			    	ETnum1=Integer.parseInt(ETsub1);
			    	ETnum2=Integer.parseInt(ETsub2);	
			    }
			    
			    if ( inputDate.lastIndexOf('-')!=-1) {
				    checkYear= inputDate.substring(0, 4);
				}
				String c1Str="13";
				String c2Str="42";
				int datesub=40;
				int monthsub=40;
				
				if ( checkYear.lastIndexOf('-')==-1) {
				    c1Str= inputDate.substring(5, 7);
				    c2Str= inputDate.substring(8);
				    datesub=Integer.parseInt(c2Str);
				    monthsub=Integer.parseInt(c1Str);
				}

				if(typedName.getText().isEmpty() || typedDate.getText().isEmpty() || typedDes.getText().isEmpty() 
						|| typedStartTime.getText().isEmpty() || typedEndTime.getText().isEmpty()) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("One of the textbox is empty");
					dateAlert.show();
				}else if (inputDate.lastIndexOf('-')!=7) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Incorrect Date Format. Event could not be saved.");
					dateAlert.show();
				}else if (inputDate.length()!= 10) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check1::Incorrect Date Format. Event could not be saved.");
					dateAlert.show();
				}else if (monthsub<1||monthsub>12) {
	             	dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 2::" + monthsub+" Incorrect Date Format. Event could not be saved.");
					dateAlert.show();
				}else if (datesub<1||datesub>31) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 3::"+ datesub+" Incorrect Date Format. Event could not be saved.");
					dateAlert.show();
				}else if (STnum1<=0||STnum1>=24) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 4::"+ STnum1+" Incorrect SHTime Format. Event could not be saved.");
					dateAlert.show();
				}else if (ETnum1<=0||ETnum1>=24) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 4::"+ ETnum1+" Incorrect EHTime Format. Event could not be saved.");
					dateAlert.show();	
				}else if(STsub2.length()!=2 && ETsub2.length()!=2) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 5::"+ ETnum2+"::"+STnum2+" Incorrect E/STime Format. Event could not be saved.");
					dateAlert.show();
				}else if (STnum2<0||STnum1>=60) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 5::"+ STnum2+" Incorrect SMTime Format. Event could not be saved.");
					dateAlert.show();
				}else if (ETnum2<0||ETnum1>=60) {
					dateAlert.setAlertType(AlertType.WARNING);
					dateAlert.setContentText("Check 5::"+ ETnum2+" Incorrect EMTime Format. Event could not be saved.");
					dateAlert.show();
				}else {
					
					eventVariable.setEvent_name(typedName.getText());
					
					eventVariable.setEvent_Date_Time(eventVariable.eventString_to_Date(typedDate.getText())); 
					
					eventVariable.setEvent_description(typedDes.getText());
					
					eventVariable.setEvent_StartTime(typedStartTime.getText());
					
					eventVariable.setEvent_EndTime(typedEndTime.getText());
					
					Event printEvent = eventVariable;
					
					strglobalEventList.add(eventVariable);
				
				    ie.ExportCSV(printEvent);}
				
				Stage stage = (Stage) saveEvent.getScene().getWindow();
				stage.close();}
		
		});
		display.getChildren().add(saveEvent);
		display.setPrefSize(300, 300);
		return display;
	}

	
}
