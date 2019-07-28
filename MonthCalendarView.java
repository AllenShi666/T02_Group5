import java.time.YearMonth;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;import java.time.YearMonth;
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
import javafx.scene.control.*;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
 
public class ContextMenuDemo extends Application {
 
    @Override
    public void start(Stage stage) {
 
Label label = new Label();

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
	private ArrayList<Button> =new ArrayList<Button>[];
    
	public MonthCalendarView(YearMonth currYearMonth) {
		// TODO Auto-generated constructor stub
		currentYearMonth = currYearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(800, 600);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                customCalendarObject dayPane = new customCalendarObject();
                dayPane.setPrefSize(200,200);
                calendar.add(dayPane,j,i);
                CalendarDays.add(dayPane);
		    
            }
         }
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
            dayPane.setBottomAnchor(txt, 5.0);
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
        view = new VBox(titleBar, dayLabels, calendar);
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
