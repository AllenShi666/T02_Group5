
import java.time.*;
import java.time.format.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


public class Notify implements EventArrayListClass{
	//Variables 
		boolean runTime=true;
		ArrayList<LocalTime> eventTimes= new ArrayList<LocalTime>();
		ArrayList<Integer> eventIndex= new ArrayList<Integer>();
		LocalTime now=LocalTime.now();
		LocalTime nowish=LocalTime.now();
		int currentGlobalSize=strglobalEventList.size();
		
		//setting todays date
		DateTimeFormatter test= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime today=LocalDateTime.now();
        String todayDate=test.format(today);
       
        
		
        int counter=0;
		
	//Functions
		//Checks if event time and now are equal to send notification

		
		public void checkTime() {
			
			
			while (runTime==true) {
				
				if (strglobalEventList.size()!=currentGlobalSize||counter%10==0) {
					this.timeArray();
					System.out.println("Notify.L60:: new event time constructed");
					
				}
				
				LocalTime compareTime;
				if (eventTimes.isEmpty()==false){
				for (int i=0; i<eventTimes.size(); i++) {
					System.out.println("Notify.L67:: This is the compare time for loop iter "+i);
					now=LocalTime.now();
					System.out.println("Notify.L69:: This is ~now~: \n"+ now);
					nowish=now.minus(30, ChronoUnit.MINUTES);
					System.out.println("Notify.L70:: This is ~nowish~: \n"+ nowish+"\n      This is eventTimes size: "+eventTimes.size());
					
					compareTime=eventTimes.get(i);
					if(nowish.isAfter(compareTime))
					{
						System.out.println("Notify.L66:: compare and now are equal");
						Alert event=new Alert(AlertType.CONFIRMATION, "You have an event coming up", ButtonType.OK);
						
						
						if (event.getResult() == ButtonType.OK) {
						    event.close();
						}
					}
				}
				}
				
				
				counter++;
			}

		}
		
		
		 
		//Creates and array with all events occurring today
			public void timeArray()
			{
				currentGlobalSize=strglobalEventList.size();
				String tempTime;
				LocalDateTime toAdd;
				String tempDate; 
				
				for(int i=0; i<currentGlobalSize; i++) {
					System.out.println("Notify.L101:: Looking for events iter "+ i+"  ");
					tempDate=strglobalEventList.get(i).event_date;
					System.out.println("Notify.L103:: This is tempDate and todayDate, respectively: \n"+ tempDate+"\n"+todayDate);
					if(tempDate.equals(todayDate)) {
						System.out.println("Notify.L105:: Found event that matches today's date.");
						tempTime=strglobalEventList.get(i).event_StartTime;
						nowish=LocalTime.parse(tempTime);
						if (now.isBefore(nowish)) {
							System.out.println("Notify.L109:: Found event that is before current time.");
							eventIndex.add(i);
							DateTimeFormatter addET = DateTimeFormatter.ofPattern("HH:mm");
							LocalTime temp = LocalTime.parse(tempTime, addET); 
							eventTimes.add(temp);
							System.out.println("Notify.L113:: This is the event added:\n"+ eventTimes.get(0));
						}
					}
					
				}
			
			
		
				System.out.println("Notify.L114:: Leaving timeArray function with eventTime holding " + eventTimes.size()+" events.\n\n\n\n");
				
				
				
				
			}
				
			
			
		
				
				
				
				
				
			

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
