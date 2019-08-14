import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Event {

	private String event_date;
	private Date event_Date_Time; //start date
	private String privacy_type="1";
	private String event_name = null;
	private String event_description = null;
	private String event_StartTime;
	private String event_EndTime;
	private String event_EndDate;


	public Event() {}
	
	public Event(String eventName, String eventDate, String eventDescription) {
		setEvent_name(eventName);
		setEvent_date(eventDate);
		setEvent_description(eventDescription);
	}

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

	public void setEvent_Date_Time(Date event_Date_Time) {
		this.event_Date_Time = event_Date_Time;
	}

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
		
	
	public Label createEventLabel() {
		
		Label eventDescription = new Label(this.event_name);
		
		return eventDescription;
	}
	
	public Date eventString_to_Date(String inputEvent){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date javaDate = Calendar.getInstance().getTime();
		
		try {
			javaDate = (Date) formatter.parse(inputEvent);
			System.out.println("Line 97:: This is JavaDate: \n "+ javaDate);
			this.event_date=inputEvent;
			return javaDate;
		} catch (ParseException e) {
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
		return this.getEvent_name()+ " "+ this.getEvent_StartTime()+ " " + this.getEvent_EndTime() + " " + this.getEvent_description();
	}
	
}
