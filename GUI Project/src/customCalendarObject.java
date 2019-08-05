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
	
	
	
	
	public customCalendarObject(Node...children) {
		
		super(children);
		this.setOnMouseClicked(e -> System.out.println("Today's events are: " + day));
		
		
		
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
