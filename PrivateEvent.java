import java.util.ArrayList;
public class PrivateEvent extends Event{

	private String event_type;
	private int event_color;
	
	
	//Functions
	
	public PrivateEvent() {}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public int getEvent_color() {
		return event_color;
	}
	public void setEvent_color(int event_color) {
		this.event_color = event_color;
	}
	public PrivateEvent(String event_type, int event_color) {
		super();
		this.event_type = event_type;
		this.event_color = event_color;
	}
	public PrivateEvent (String name, int date, String type)
	
	/*This function takes in a string which could be a name, type 
	or description of the event that needs to be changed, and the indicator (1, 2, or 3)
	which would indicate which one of the three field it would go in*/
	public void modPEvent (String change, int indicator){
		
		
	}
	
	/*Modifies Date of PrivateEvent*/
	 public void modPEvent (int date){
		 
	 }
	 // Displays event w/o edit option in GUI
	 
	public void displayA_PEvent(Event a) {
		
	}
	 
}