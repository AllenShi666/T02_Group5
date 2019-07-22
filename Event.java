//import java.util.Calendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class Event {
	protected String event_date;
	protected int id = 0;
	protected char privacy_type ='\0';
	protected String event_name = "";
	protected String event_description = "";
	protected int color_id = 0;

	public Event() {}
	
	public Event newEvent(Event newevent) {
		return newevent.newEvent(newevent);
	}
	
	public void displayEvent(ArrayList disp) {
		
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

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	
	
	
	
	
}
