
public class PublicEvent extends Event{

	private String event_type;
	private int event_color;
	
	//Functions
	public PublicEvent() {}
	public PublicEvent(String event_type, int event_color) {
		super();
		this.event_type = event_type;
		this.event_color = event_color;
	}
	public PublicEvent (String name, int date, String type)
	
	public PublicEvent(String event_data) {
		// TODO Auto-generated constructor stub
	}
	/*This function takes in a string which could be a name, type 
	or description of the event that needs to be changed, and the indicator (1, 2, or 3)
	which would indicate which one of the three field it would go in*/
	public void modPubEvent (String change, int indicator){
		
		
	}
	
	/*Modifies Date of PrivateEvent*/
	 public void modPubEvent (int date){
		 
	 }
	 // Displays event w/o edit option in GUI
	 
	public void displayA_PubEvent(Event a) {
		
	}
	 
}
