//import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Event {
	//protected String event_date;
	protected int id = 0;
	protected String event_date;
	protected Date event_Date_Time; //start date
	protected LocalDate forLabel;
	protected String privacy_type="1";
	protected String event_name = null;
	protected String event_description = null;
	protected int color_id = 0;
	protected String event_StartTime;
	protected String event_EndTime;
	protected String event_EndDate;
	private Alert dateAlert = new Alert(AlertType.WARNING);

	public Event() {}
	
	public Event(String eventName, String eventDate, String eventDescription) {
		setEvent_name(eventName);
		setEvent_date(eventDate);
		setEvent_description(eventDescription);
	}
	//public ArrayList<Event> receiveEvent(List<String> event){
		//ArrayList<Event> a = new ArrayList<Event>();
	public ObservableList<Event> receiveEvent(List<String> event){
		ObservableList<Event> a = FXCollections.observableArrayList();
	
		for (int i = 7; i < event.size();i = i+7) {	
            Event b = new Event();
			b.setEvent_name(event.get(i));
			b.setEvent_date(event.get(i+1));
			b.setEvent_EndDate(event.get(i+2));
		    b.setEvent_StartTime(event.get(i+3));
			b.setEvent_EndTime(event.get(i+4));
			b.setEvent_description(event.get(i+5));
			b.setPrivacy_type(event.get(i+6));
			a.add(b);
		}
		return a;
		
	}
	/*public LocalDate getForLabel() {
		return forLabel;
	}

	public void setForLabel(LocalDate forLabel) {
		this.forLabel = forLabel;
	}*/
	public Event newEvent(Event newevent) {
		return newevent.newEvent(newevent);
	}

	public String getPrivacy_type() {
		return privacy_type;
	}

	public void setPrivacy_type(String privacy_type) {
		this.privacy_type = privacy_type;
	}

	public String getEvent_EndDate() {
		return event_EndDate;
	}

	public void setEvent_EndDate(String event_EndDate) {
		this.event_EndDate = event_EndDate;
	}
	
	public Date getEvent_Date_Time() {
		return event_Date_Time;
	}


	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		
		this.event_date = event_date;
		}
		
	
	/*public void setEvent_Date_Time(String event_date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.event_Date_Time = formatter.parse(event_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dateAlert.setAlertType(AlertType.WARNING);
			dateAlert.setContentText("Something Event date is incorrectly formatted.");
			dateAlert.show();
		}
	}*/
	
	public Label createEventLabel() {
		
		Label eventDescription = new Label(this.event_name);
		
		return eventDescription;
	}
	
	public ArrayList<String> getEventName(ObservableList<Event> globalList) {
		
		ArrayList<String> EventName = new ArrayList<String>();
		
		for(int i = 1; i < globalList.size(); i++) {
			
			EventName.add(globalList.get(i).getEvent_name());
		}
		
		
		
		return EventName;
		
	}
	
	
	public ArrayList<String> getEventDate(ObservableList<Event> globalList){
		
		ArrayList<String> EventDate = new ArrayList<String>();
		
		for(int i = 1; i < globalList.size(); i++) {
			
			EventDate.add(globalList.get(i).getEvent_date());
		}
		
		
		
		return EventDate;
		
	}
	public Date eventString_to_Date(String inputEvent) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date javaDate = null;
		
		try {
			javaDate = (Date) formatter.parse(inputEvent);
			System.out.println("Line 97:: This is JavaDate: \n "+ javaDate);
			this.event_date=inputEvent;
			return javaDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dateAlert.setAlertType(AlertType.WARNING);
			dateAlert.setContentText("Event date is incorrectly formatted.");
			dateAlert.show();
			return javaDate;
		}
		
	}

	public String getEvent_name() {
		return event_name;
	}
	


	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_StartTime() {
		return event_StartTime;
	}

	public void setEvent_StartTime(String event_StartTime) {
		this.event_StartTime = event_StartTime;
	}

	public String getEvent_EndTime() {
		return event_EndTime;
	}

	public void setEvent_EndTime(String event_EndTime) {
		this.event_EndTime = event_EndTime;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	
	public String toString() {
		return this.getEvent_name()+ " " + this.getEvent_Date_Time()+ " "+ this.getEvent_StartTime()+ " " + this.getEvent_EndTime() + " " + this.getEvent_description();
	}
	
	
	
	
}
