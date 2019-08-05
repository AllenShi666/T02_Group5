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

import java.time.LocalDate;



public class MonthCalendarView {
	
	private ArrayList<customCalendarObject> CalendarDays = new ArrayList<>(35);
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;
    private Button newEvent = new Button("Add New Event");
    private Button viewEvent = new Button("View Events");
    private Button viewWeek = new Button("Week View");
    
    
	public MonthCalendarView(YearMonth currYearMonth) {
		// TODO Auto-generated constructor stub
		currentYearMonth = currYearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(600, 600);
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
        
    HandleButtonAdd handleAdd = new HandleButtonAdd("Add");
    HandleButtonAdd handleAdd2 = new HandleButtonAdd("View");
    HandleButtonAdd handleAdd3 = new HandleButtonAdd("WView");
    
    newEvent.setOnAction(handleAdd);
    viewEvent.setOnAction(handleAdd2);
    viewWeek.setOnAction(handleAdd3);
    
    
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
        bottomView.getChildren().add(viewWeek);
        view = new VBox(titleBar, dayLabels, calendar, bottomView);
	}
	
	public void populateCalendar(YearMonth curryearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(curryearMonth.getYear(), curryearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (customCalendarObject dayUnit : CalendarDays) {
            if (dayUnit.getChildren().size() != 0) {
                dayUnit.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            dayUnit.setDate(calendarDate);
            dayUnit.setTopAnchor(txt, 5.0);
            dayUnit.setLeftAnchor(txt, 5.0);
            dayUnit.getChildren().add(txt);
            calendarDate = calendarDate.plusDays(1);
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

	public VBox getView() {
		// TODO Auto-generated method stub
		return view;
	}

	public ArrayList<customCalendarObject> getAllCalendarDays() {
        return CalendarDays;
    }

    public void setAllCalendarDays(ArrayList<customCalendarObject> allCalendarDays) {
        this.CalendarDays = allCalendarDays;
    }
}
