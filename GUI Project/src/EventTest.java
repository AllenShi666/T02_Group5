/**
 * @author Team5
 * JUnit test file that tests the creation of events and getter/setter methods for our event calculations.
 */

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class EventTest {

	//Testing constructor with no input arguments
	@Test
	public final void testEvent() {
		Event testEvent = new Event();
		testEvent.setEvent_name("Created New Event");
		assertEquals("Created New Event", testEvent.getEvent_name());
	}

	//Testing constructor with Event name, date, and description as string input arguments
	@Test
	public final void testEventStringStringString() {
		Event testEvent = new Event("JUnit_Name", "JUnit_Date", "JUnit_Description");
		assertEquals("JUnit_Name", testEvent.getEvent_name());
		assertEquals("JUnit_Date", testEvent.getEvent_date());
		assertEquals("JUnit_Description", testEvent.getEvent_description());
	}
	//Testing getter for Event End Date
	@Test
	public final void testGetEvent_EndDate() {
		Event testEvent = new Event();
		testEvent.setEvent_EndDate("Junit end time");
		assertEquals("Junit end time", testEvent.getEvent_EndDate());
	}

	//Testing setter for Event End Date - test should be same as Event End Date getter method
	@Test
	public final void testSetEvent_EndDate() {
		Event testEvent = new Event();
		testEvent.setEvent_EndDate("Junit end time");
		assertEquals("Junit end time", testEvent.getEvent_EndDate());
	}

	//Testing getter for inputted Event Date
	@Test
	public final void testGetEvent_date() {
		Event testEvent = new Event();
		testEvent.setEvent_date("Junit test date");
		assertEquals("Junit test date", testEvent.getEvent_date());
	}
	//Testing getter for inputted Event Date - test should be same as Event Date getter method
	@Test
	public final void testSetEvent_date() {
		Event testEvent = new Event();
		testEvent.setEvent_date("Junit test date");
		assertEquals("Junit test date", testEvent.getEvent_date());
	}
	//Testing getter for inputted Event name
	@Test
	public final void testGetEvent_name() {
		Event testEvent = new Event();
		testEvent.setEvent_name("Junit test name");
		assertEquals("Junit test name", testEvent.getEvent_name());
	}
	//Testing getter for inputted Event Date - test should be same as Event Name getter method
	@Test
	public final void testSetEvent_name() {
		Event testEvent = new Event();
		testEvent.setEvent_name("Junit test name");
		assertEquals("Junit test name", testEvent.getEvent_name());
	}

	//Testing getter method for Event Start Time
	@Test
	public final void testGetEvent_StartTime() {
		Event testEvent = new Event();
		testEvent.setEvent_StartTime("Junit start time");
		assertEquals("Junit start time", testEvent.getEvent_StartTime());
	}

	//Testing getter for inputted Event Start Time - test should be same as Event Start Time getter method
	@Test
	public final void testSetEvent_StartTime() {
		Event testEvent = new Event();
		testEvent.setEvent_StartTime("Junit start time");
		assertEquals("Junit start time", testEvent.getEvent_StartTime());
	}
	//Testing getter for inputted end time
	@Test
	public final void testGetEvent_EndTime() {
		Event testEvent = new Event();
		testEvent.setEvent_EndTime("Junit end time");
		assertEquals("Junit end time", testEvent.getEvent_EndTime());
	}
	//Testing getter for inputted Event Start Time - test should be same as Event End Time getter method
	@Test
	public final void testSetEvent_EndTime() {
		Event testEvent = new Event();
		testEvent.setEvent_EndTime("Junit end time");
		assertEquals("Junit end time", testEvent.getEvent_EndTime());
	}
	//Testing getter for Event description
	@Test
	public final void testGetEvent_description() {
		Event testEvent = new Event();
		testEvent.setEvent_description("Junit description");
		assertEquals("Junit description", testEvent.getEvent_description());
	}
	//Testing getter for inputted Event description - test should be same as Event description getter method
	@Test
	public final void testSetEvent_description() {
		Event testEvent = new Event();
		testEvent.setEvent_description("Junit description");
		assertEquals("Junit description", testEvent.getEvent_description());
	}

	@Test
	public final void testToString() {
		Event testEvent = new Event();
		testEvent.setEvent_name("Junit event name");
		testEvent.setEvent_StartTime("Junit start time");
		testEvent.setEvent_EndTime("Junit end time");
		testEvent.setEvent_description("Junit description");
		assertEquals("Junit event name Junit start time Junit end time Junit description", testEvent.toString());
	}

}
