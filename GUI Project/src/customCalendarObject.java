import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

/* This is the class file that will handle our group's custom event code
 * We will also put the notification event code in here as well as it will need to be
 * triggered by a click??????
 * 
 * Also, dates aren't assigned to day objects here. This file is only for the action 
 * methods that will provide functionality to the calendar. Another class file will have
 * to take care of the calendar GUI design, and the population of the date labels.
 * 
 * Resources:
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html
 * https://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html

 */

public class customCalendarObject extends AnchorPane {

	//Single date displayed on calendar
	private LocalDate day;
	private ArrayList<Event> dayEventList = new ArrayList<Event>();
	
	
	public customCalendarObject() {
		
	}
	
	
	public customCalendarObject(Node clickDay) {
		
		super();
		
		String eventType;
		Scanner input = new Scanner(System.in);
		Event tempEvent = new Event();
		
		
        // Add action handler for mouse clicked
        this.setOnMouseClicked(e -> System.out.println("Please enter 'p' for a personal event (ex. a quiz or meeting) or "
				+ "any other letter for an academic/university sanctioned event (school fee "
				+ "deadline, faculty networking event etc): "));
        
       //This has to switch to GUI-based input
        eventType=(input.nextLine());
		
		 switch (eventType) { 
	        case "p": 
	        	PublicEvent addEvent = new PublicEvent(tempEvent);
	        	
	        	dayEventList.add(addEvent);
	        
	        break;
	      
	        default: 
	        	
	        	PrivateEvent addEvent1 = new PrivateEvent(tempEvent);
	        	
	        	dayEventList.add(addEvent1);
	        	
	        	break; 
	        
		 }
		
	}
	
	/* Getter and setter methods for custom day class object
	 * 
	 */
	public LocalDate getDate() {
		
		return day;
	}
	
	public void setDate(LocalDate inputDate) {
		
		this.day = inputDate;
	}
	
}
