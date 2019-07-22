
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
		System.out.println("Please 'p' for a personal event (ex. a quiz or meeting) or "
				+ "any other letter for an academic/university sanctioned event (school fee "
				+ "deadline, faculty networking event etc): ");
		event_type=(input.nextLine());
		
		//Adding event name to event
		System.out.println("Please enter the event name: ");
		event_data=(input.nextLine());
		
		if (event_type=="p"){  
			PublicEvent event1=new PublicEvent(event_data);}
		else {
			PrivateEvent event1= new PrivateEvent(event_data);}
			
		
		System.out.println("Please enter the event date (mm-dd-yyy): ");
		event_data=(input.nextLine());
		
		
		
		System.out.println("Please enter the event description: ");
		event_data=(input.nextLine());
		event1.setEvent_name(event_data);

		System.out.println("This is event data: \n" + event_data.toString());

	}
}
