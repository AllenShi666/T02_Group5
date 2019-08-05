//import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Event {
	protected String event_date;
	protected int id = 0;
	protected String privacy_type;
	protected String event_name = "";
	protected String event_description = "";
	protected int color_id = 0;
	protected String event_StartTime;
	protected String event_EndTime;
	protected String event_Date; //start date
	protected String event_EndDate;

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

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	
	/*public void setEvent_date(String inputEvent) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date date = formatter.parse(inputEvent);
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
	}*/

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
		return this.getEvent_name()+this.getEvent_date()+this.getEvent_description();
	}
	
	
	
	
}
