import java.awt.Label;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.Label;

public class HandleButtonClick implements EventHandler<ActionEvent>{
    	
    	private PublicEvent e1;
    
    	@Override
    	public void handle (ActionEvent event) {
    		
    	
    		

    		
    		Scanner input = new Scanner(System.in);
    		
    		
    		
    		
    		//Adding event name to event
    			System.out.println("Please enter the event name: ");
    			e1.setEvent_name(input.nextLine());
    			
    		//Pulling date
    		System.out.println("Please enter the event date (mm-dd-yyyy): ");
    		e1.setEvent_date(input.nextLine());
    		
    		//Taking the event date as a string, have to convert to .calendar format and add to event 
    		
    		//Pulling description
    		System.out.println("Please enter the event description: ");
    		e1.setEvent_description(input.nextLine());
    		
    		
    		
    		
    		
		}
}