import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Team5
 * Event will store event name, event date, event start time, event end time, event description and privacy type 
 *
 */
public class Event {

	private String event_date;
	private Date event_Date_Time; //start date
	private String privacy_type="1";
	private String event_name = null;
	private String event_description = null;
	private String event_StartTime;
	private String event_EndTime;
	private String event_EndDate;

	/**
	 * Default constructor
	 */
	public Event() {}
	
	/**
	 * Consturctor that takes in event name, event date and event description and set each corresponding variable
	 * @param eventName Event name
	 * @param eventDate Event date
	 * @param eventDescription Event description
	 */
	public Event(String eventName, String eventDate, String eventDescription) {
		setEvent_name(eventName);
		setEvent_date(eventDate);
		setEvent_description(eventDescription);
	}

	/**
	 * receiveEvent will receive the list of String in form of Event from *.csv file and store in ObservableList &lt;Event&gt;
	 * @param event takes in list of String that stores Event variable
	 * @return ObservableList &lt;Event&gt; return Event in ObservableList
	 */
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
	/**
	 * setter method to set the event date_time in type of Date
	 * @param event_Date_Time
	 */
	public void setEvent_Date_Time(Date event_Date_Time) {
		this.event_Date_Time = event_Date_Time;
	}
	
	/**
	 * To make new event
	 * @param newevent make new event
	 * @return new event created
	 */
	public Event newEvent(Event newevent) {
		return newevent.newEvent(newevent);
	}
	
	/**
	 * @return get privacy type
	 */
	public String getPrivacy_type() {
		return privacy_type;
	}

	/**
	 * @param privacy_type set privacy type
	 */
	public void setPrivacy_type(String privacy_type) {
		this.privacy_type = privacy_type;
	}
	
	/**
	 * @return get event end date
	 */
	public String getEvent_EndDate() {
		return event_EndDate;
	}

	/**
	 * @param event_EndDate set event end date
	 */
	public void setEvent_EndDate(String event_EndDate) {
		this.event_EndDate = event_EndDate;
	}
	
	/**
	 * @return get event date in Date format
	 */
	public Date getEvent_Date_Time() {
		return event_Date_Time;
	}

	/**
	 * @return get event date
	 */
	public String getEvent_date() {
		return event_date;
	}

	/**
	 * @param event_date set event date
	 */
	public void setEvent_date(String event_date) {
		
		this.event_date = event_date;
		}
		
	
	/*public Label createEventLabel() {
		
		Label eventDescription = new Label(this.event_name);
		
		return eventDescription;
	}*/
	
	/**
	 * this function will give Warning window if the format does not match the system format
	 * @param inputEvent converts from string to date object
	 * @return get the event date in Date format
	 */
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
	
	/**
	 * @return get event name
	 */
	public String getEvent_name() {
		return event_name;
	}

	/**
	 * @param event_name set event name
	 */
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	
	/**
	 * @return get event start time 
	 */
	public String getEvent_StartTime() {
		return event_StartTime;
	}
	
	/**
	 * @param event_StartTime set event start time
	 */
	public void setEvent_StartTime(String event_StartTime) {
		this.event_StartTime = event_StartTime;
	}
	
	/**
	 * @return get event end time
	 */
	public String getEvent_EndTime() {
		return event_EndTime;
	}
	
	/**
	 * @param event_EndTime set event end time
	 */
	public void setEvent_EndTime(String event_EndTime) {
		this.event_EndTime = event_EndTime;
	}

	/**
	 * @return get event description
	 */
	public String getEvent_description() {
		return event_description;
	}
	
	/**
	 * @param event_description set event description
	 */
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	
	/**
	 * @return return event name, event start time, event end time and event description
	 */
	public String toString() {
		return this.getEvent_name()+ " "+ this.getEvent_StartTime()+ " " + this.getEvent_EndTime() + " " + this.getEvent_description();
	}
	
}
