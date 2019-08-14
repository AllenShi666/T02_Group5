import java.time.YearMonth;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.*;


public class WeekGUI {

	
	
	private ArrayList<customCalendarObject> weeklyViewArray = new ArrayList<>(7);
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;
    private Button newEvent = new Button("Add New Event");
    private Button viewEvent = new Button("View Events");
    
    public WeekGUI() {
		// TODO Auto-generated constructor stub
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(600, 600);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
            for (int j = 0; j < 7; j++) {
                customCalendarObject dayPane = new customCalendarObject();
                dayPane.setPrefSize(600,800);
                calendar.add(dayPane, j, 0);
                weeklyViewArray.add(dayPane);
            }
         }
    
    
    
    public GridPane getWeekDisplay() {
    	
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
    	
    	return dayLabels;
    }
    
    public void populateWeek(YearMonth curryearMonth, LocalDate currDay) {
        // Get the date we want to start with on the calendar
        DayOfWeek dayOfWeek = currDay.getDayOfWeek();
    	LocalDate weekStartDate = LocalDate.of(curryearMonth.getYear(), curryearMonth.getMonthValue(), dayOfWeek.getValue());
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!weekStartDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            weekStartDate = weekStartDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (customCalendarObject dayUnit : weeklyViewArray) {
            if (dayUnit.getChildren().size() != 0) {
                dayUnit.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(weekStartDate.getDayOfMonth()));
            dayUnit.setDate(weekStartDate);
            dayUnit.setTopAnchor(txt, 5.0);
            dayUnit.setLeftAnchor(txt, 5.0);
            dayUnit.getChildren().add(txt);
            weekStartDate = weekStartDate.plusDays(1);
        }
      
}}
