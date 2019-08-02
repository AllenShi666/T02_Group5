import java.time.YearMonth;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
	
	
		
		
	}
	
	//Initializes second stage
	@Override
	public void handle(ActionEvent addEvent) {
		//System.out.println("THis is a TeSt");
		if(message == "Add") {
			eventWindow e = new eventWindow();
			Stage eventGUI = new Stage();
			e.start(eventGUI);
		} else if(message == "Save") {
			
			
		}
		int counter = 0;
		
		counter++;
	}

	

}
