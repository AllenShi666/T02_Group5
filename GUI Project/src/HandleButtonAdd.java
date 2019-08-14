import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HandleButtonAdd implements EventHandler <ActionEvent> {
	
	private String message = "Add";
	
	
	public HandleButtonAdd(String A) {
		
		message = A;
		
	}
	
	public class eventWindow extends Application {
		
		//Displays second window
		public void start(Stage secondStage) {			
		
			secondStage.setTitle("Add Event");
			EventGUI a = new EventGUI();
	        secondStage.setScene(new Scene(a.getDisplay()));
	        secondStage.show();
	        
		}
	
		public void start2(Stage secondStage) {
			
			secondStage.setTitle("All Events");
			viewEventGUI b = new viewEventGUI();
			secondStage.setScene(new Scene(b.getViewEventDisplay()));
			secondStage.show();
		}
	
	}
	
	//Initializes second stage
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
