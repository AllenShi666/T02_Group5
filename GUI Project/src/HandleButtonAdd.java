import java.time.YearMonth;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.time.LocalDate;


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

		public void start3(Stage weekView) {
			// TODO Auto-generated method stub
			weekView.setTitle("Weekly View");
			WeekGUI week = new WeekGUI();
			weekView.setScene(new Scene(week.getWeekDisplay()));
			weekView.show();
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
		} else if(message == "View") {
			eventWindow ee = new eventWindow();
			Stage viewEventGUI = new Stage();
			ee.start2(viewEventGUI);
		
		} else if(message == "WView") {
			eventWindow WV = new eventWindow();
			Stage WeekView = new Stage();
			WV.start3(WeekView);
		}
		int counter = 0;
		
		counter++;
	}

}
