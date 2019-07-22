
import java.util.*;
public class ProjectDemo_1 {

	public static void main(String args[]) {
		/*
		 * This is the temporary storage for all the data received from the
		 * input stream
		 */
		String event_type;
		ArrayList<Event> event_list = new ArrayList<>();
		Event tempEvent = new Event();
		

		
		Scanner input = new Scanner(System.in);
		
		
		
		
		//Adding event name to event
			System.out.println("Please enter the event name: ");
			tempEvent.setEvent_name(input.nextLine());
			
		//Pulling date
		System.out.println("Please enter the event date (mm-dd-yyyy): ");
		tempEvent.setEvent_date(input.nextLine());
		
		//Taking the event date as a string, have to convert to .calendar format and add to event 
		
		//Pulling description
		System.out.println("Please enter the event description: ");
		tempEvent.setEvent_description(input.nextLine());
		
		
		System.out.println("Please enter 'p' for a personal event (ex. a quiz or meeting) or "
				+ "any other letter for an academic/university sanctioned event (school fee "
				+ "deadline, faculty networking event etc): ");
		event_type=(input.nextLine());
		
		 switch (event_type) { 
	        case "p": 
	        	PublicEvent addEvent = new PublicEvent(tempEvent);
	        	
	        	event_list.add(addEvent);
	        	
	        	//System.out.println(addEvent.toString());
	        	
	        	System.out.println("This is the public event:\nEvent name: "+addEvent.getEvent_name()+"\nEvent date: " +addEvent.getEvent_date()+ "\nEvent description: " +addEvent.getEvent_description());
	        	
	            break; 
	        
	        default: 
	        	
	        	PrivateEvent addEvent1 = new PrivateEvent(tempEvent);
	        	
	        	event_list.add(addEvent1);
	        	

	        	System.out.println("This is the private event:\nEvent name: "+addEvent1.getEvent_name()+"\nEvent date: " +addEvent1.getEvent_date()+ "\nEvent description: " +addEvent1.getEvent_description());
	        	
	            
	        	break; 
		 }
		 
		 

	}
}
