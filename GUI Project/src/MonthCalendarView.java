import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

/**
 * 
 * @author hechen
 * Credit to GitHub user SirGoose3432 as he provided the initial calendar GUI layout.
 * URL: https://github.com/SirGoose3432/javafx-calendar
 * Accessed on: July 22nd 2019
 * 
 * @see
 * https://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html
 *
 */

public class MonthCalendarView implements EventArrayListClass {
	
	//Initializes calendar GUI objects
	private ArrayList<customCalendarObject> CalendarDays = new ArrayList<>(35);
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;
    private Button newEvent = new Button("Add New Event");
    private Button viewEvent = new Button("View Events");
    //private Button viewWeek = new Button("Week View");
    
    
	/**
	 
	 * @param YearMonth
	 * Code that creates the gridpane month view of the calendar GUI.
	 * Requires YearMonth object that opens the calendar to the current month and year
	 */
    public MonthCalendarView(YearMonth currYearMonth) {
		// TODO Auto-generated constructor stub
		currentYearMonth = currYearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(1600, 600);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                customCalendarObject dayPane = new customCalendarObject();
                dayPane.setPrefSize(600,800);
                calendar.add(dayPane,j,i);
                CalendarDays.add(dayPane);
            }
         }
    
    //Initialize handle button methods to HandleButtonAdd class so that users will can add and view events
    HandleButtonAdd handleAdd = new HandleButtonAdd("Add");
    HandleButtonAdd handleAdd2 = new HandleButtonAdd("View");
    HandleButtonAdd handleAdd3 = new HandleButtonAdd("WView");
    
    //Setting button action handles
    newEvent.setOnAction(handleAdd);
    viewEvent.setOnAction(handleAdd2);
    //viewWeek.setOnAction(handleAdd3);
    
    
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text("Sunday"), new Text("Monday"), new Text("Tuesday"),
                                        new Text("Wednesday"), new Text("Thursday"), new Text("Friday"),
                                        new Text("Saturday") };
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(600);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane dayPane = new AnchorPane();
            dayPane.setPrefSize(200, 10);
            dayPane.setBottomAnchor(txt, 0.0);
            dayPane.setRightAnchor(txt, 0.0);
            dayPane.setLeftAnchor(txt, 0.0);;
            dayPane.setTopAnchor(txt,  0.0);
            dayPane.getChildren().add(txt);
            dayLabels.add(dayPane, col++, 0);
        }
        
     // Create calendarTitle and buttons to change current month
        calendarTitle = new Text();
        Button previousMonth = new Button("<<");
        previousMonth.setOnAction(e -> previousMonth());
        Button nextMonth = new Button(">>");
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
        titleBar.setAlignment(Pos.BASELINE_CENTER);
        // Populate calendar with the appropriate day numbers
        populateCalendar(currYearMonth);
        // Create the calendar view
        HBox bottomView = new HBox();
        bottomView.getChildren().add(newEvent);
        bottomView.getChildren().add(viewEvent);
        //bottomView.getChildren().add(viewWeek);
        view = new VBox(titleBar, dayLabels, calendar, bottomView);
	}
	
    
    
    
    
	/**
	 * 
	 * @param curryearMonth
	 * Populating calendar using the current YearMonth object that sets the calendar to today's date as default.
	 */
    public void populateCalendar(YearMonth curryearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(curryearMonth.getYear(), curryearMonth.getMonthValue(), 1);
        LocalDate calendarDateBegin= LocalDate.of(curryearMonth.getYear(), curryearMonth.getMonthValue(), 1);
        LocalDate calendarDateEnd= LocalDate.of(curryearMonth.getYear(), curryearMonth.getMonthValue(), 1);
        LocalDate nowTime = LocalDate.now();
         // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
            calendarDateBegin=calendarDate;
        }
        // Populate the calendar with day numbers
        //int countDate=0;
        double leftAnchor = 5.0;
        double TopAnchor = 5.0;
        for (customCalendarObject dayUnit : CalendarDays) {
            while(dayUnit.getChildren().size() != 0) 
            {
                dayUnit.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            dayUnit.setDate(calendarDate);
            dayUnit.setTopAnchor(txt, TopAnchor);
            dayUnit.setLeftAnchor(txt,leftAnchor);
            dayUnit.getChildren().add(txt);
            //System.out.println(calendarDate);
            
            for(int i = 0; i< strglobalEventList.size();i++) {
            	LocalDate temp;
            	String eventDate = strglobalEventList.get(i).getEvent_date();
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        		temp=LocalDate.parse(eventDate, formatter); 
        		
        		if(temp.equals(calendarDate)) {
        			Text test= new Text(String.valueOf(strglobalEventList.get(i).getEvent_name()));
        			if(dayUnit.getChildren().size() >= 5) {
        				test= new Text(String.valueOf("..."));
        				dayUnit.setTopAnchor(test, 80.0);
        			}else if(dayUnit.getChildren().size() == 1) {
                        dayUnit.setTopAnchor(test, dayUnit.getChildren().size()+19.0);
                    }else {
                    	dayUnit.setTopAnchor(test, (dayUnit.getChildren().size()-1)*15+20.0);
                    }
                    dayUnit.setLeftAnchor(test, leftAnchor);
                    dayUnit.getChildren().add(test);    
        		}
            }
  
            calendarDate = calendarDate.plusDays(1);

            
            
            // REMEBER THIS SECTION 
            /*While (eventFinder=true)
            	{ counter:: NumberofEvents=0;
            	
            	func( counter, firstDate ):: label
            			***** check if firstDate minus EIM.iter==counter
            			*If it is, return a label
            			*Numbr of EVent++;
            			*If NOT, return null
            			*
            		If (LAbel== "")--eventFinder=false
            		else {
            		****** DO shit to set the event label to date
            		*********Remebr, for every additional Labvel, add 15 to the anchor
            		}         
            */
     
            /*if(calendarDate == nowTime) {
            Text test= new Text(String.valueOf("NapTime"));
            dayUnit.setTopAnchor(test, 20.0);
            dayUnit.setLeftAnchor(test, leftAnchor);
            dayUnit.getChildren().add(test);}
            calendarDateEnd=calendarDate;
            */
         
            // Segment to display events
            /*
            
            	String tempDate= "";
            	LocalDate temp;
            	int counter =0;
            	ArrayList<Label>eimLabels = new ArrayList<Label>();
            	ArrayList<Event> EventsInMonth= new ArrayList<Event>();
            	for (int i=1; i<strglobalEventList.size(); i++) {
            		
            		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            		tempDate=strglobalEventList.get(i).getEvent_date();
            		temp=LocalDate.parse(tempDate, formatter);   
            		
            		if (temp.isAfter(calendarDateBegin) && temp.isBefore(calendarDateEnd)) {
            			counter++;
            			EventsInMonth.add(strglobalEventList.get(i));
            			System.out.println("MCV.L153:: This is event name: "+ strglobalEventList.get(i).getEvent_name()+"     "+ counter);
            		}
            		
            		
            	}
            	for (int i=0; i<EventsInMonth.size(); i++) {
            	eimLabels.add(EventsInMonth.get(i).createEventLabel());
            	}
            
            	*/
            /*	for(customCalendarObject x : CalendarDays) {
            		
            		x.getChildren().add(eimLabels());
            		
            		for(Event a : EventsInMonth) {
            			
            			
            		}
            		
            		if()
            		
            		
            	}*/
            	
            	
        }
        // Change the title of the calendar
        
           calendarTitle.setText(curryearMonth.getMonth().toString() + " " + String.valueOf(curryearMonth.getYear()));
    }
	
	 /**
     * Move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }

    /**
     * Move the month forward by one. Repopulate the calendar with the correct dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        populateCalendar(currentYearMonth);
    }

	/**
	 * 
	 * @return VBox -
	 * Returns the monthly calendar view
	 */
    public VBox getView() {
		// TODO Auto-generated method stub
		return view;
	}

	/**
	 * 
	 * @return ArrayList&lt;customCalendarObject&gt; - Returns the stored array list of custom calendar objects
	 */
    public ArrayList<customCalendarObject> getAllCalendarDays() {
        return CalendarDays;
    }

    /**
     * 
     * @param ArrayList&lt;customCalendarObject&gt; Sets the array list of calendar objects
     */
    public void setAllCalendarDays(ArrayList<customCalendarObject> allCalendarDays) {
        this.CalendarDays = allCalendarDays;
    }
}
