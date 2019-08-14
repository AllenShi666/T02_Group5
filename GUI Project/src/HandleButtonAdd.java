import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author Team5
 * Handler class that listens on buttons clicked in the Month calendar view. Initializes the stages for "Add Event" and "View Event"
 * This class takes no arguments as it initializes GUI stages when called on by the user (AKA button click).
 */
public class HandleButtonAdd implements EventHandler <ActionEvent> {
	
	private String message = "Add";
	
	/**
	 * This is the constructor where it takes in a String and switch the text if button get clicked
	 */
	public HandleButtonAdd(String A) {
		
		message = A;
		
	}
	
	/**
	 * This is the inner class that start a new window once Add Event or View Event button get clicked
	 */
	public class eventWindow extends Application {
		/**
		 * take in a Stage and start Add Event window
		 * @param Stage
		 */
		public void start(Stage secondStage) {			
		
			secondStage.setTitle("Add Event");
			EventGUI a = new EventGUI();
	        secondStage.setScene(new Scene(a.getDisplay()));
	        secondStage.show();
	        
		}
		
		/**
		 * take in a Stage and start View Event window
		 * @param Stage
		 */
		public void start2(Stage secondStage) {
			
			secondStage.setTitle("All Events");
			viewEventGUI b = new viewEventGUI();
			secondStage.setScene(new Scene(b.getViewEventDisplay()));
			secondStage.show();
		}
	
	}
	
	//Initializes second stage
	/**
	 * @param ActionEvent
	 * This handle method will switch message once the button get clicked
	 */
	@Override
	public void handle(ActionEvent addEvent) {
		
		if(message == "Add") {
			eventWindow e = new eventWindow();
			Stage eventGUI = new Stage();
			e.start(eventGUI);
		} else if(message == "View") {
			eventWindow ee = new eventWindow();
			Stage viewEventGUI = new Stage();
			ee.start2(viewEventGUI);
		
		} 
		
	}

}
