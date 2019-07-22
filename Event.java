//import java.util.Calendar;
import java.util.*;

public class Event {
	private Calendar event_date;
	private int id = 0;
	private char privacy_type ='\0';
	private String event_name = "";
	private String event_description = "";
	private int color_id = 0;

	public Event() {}
	
	public Event newEvent(Event newevent) {
		return newevent.newEvent(newevent);
	}
	
	public void displayEvent(ArrayList disp) {
		
	}

	public Calendar getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Calendar event_date) {
		this.event_date = event_date;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	
	
	
	
	
}
