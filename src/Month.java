import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;
public class Month {

	private String month_name;
	private int month_id;
	private ArrayList<Day> months_day = new ArrayList<Day>();
	
	
	public Month(){
		
		
	}
	
	public Month(String Calendar) {
		
		
	}
	
	public void addDay(Day inputDay) {
		
		Day tempDay = inputDay;
		
		months_day.add(new Day(tempDay));
	}
	
	public void displayMonth(ArrayList<Day> monthDays) {
		
		
	}
	
}
