
import java.util.*;
public class ProjectDemo_1 {

	public static void main(String args[]) {
		/*
		 * This is the temporary storage for all the data received from the
		 * input stream
		 */
		String event_data, event_type;
		ArrayList<Event> event_list = new ArrayList<>();
		

		
		Scanner input = new Scanner(System.in);
		
		//Deciding what type of event to make
		System.out.println("Please enter 'p' for a personal event (ex. a quiz or meeting) or "
				+ "any other letter for an academic/university sanctioned event (school fee "
				+ "deadline, faculty networking event etc): ");
		event_type=(input.nextLine());
		
		//Adding event name to event
		System.out.println("Please enter the event name: ");
		event_data=(input.nextLine());
		 switch (event_type) { 
	        case "p": 
	        	event_list.add(new PublicEvent(event_data));
	            break; 
	        default: 
	        	event_list.add(new PrivateEvent(event_data));
	            break; 
		 }
		
			
		
		System.out.println("Please enter the event date (mm-dd-yyyy): ");
		event_data=(input.nextLine());
		
		//Taking the event date as a string, have to convert to .calendar format and add to event 
		
		System.out.println("Please enter the event description: ");
		event_data=(input.nextLine());
		


	}
}
