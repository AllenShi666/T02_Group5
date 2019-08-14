import java.time.YearMonth;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
/**
 * @author Team5
 *main function, responsible for application launch
 *
 */
public class mainFunction extends Application {

	//Set up stage window
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("University Calendar");
        primaryStage.setScene(new Scene(new MonthCalendarView(YearMonth.now()).getView()));
        primaryStage.show();   
	}
	
	/**
     * @param args Launch the application
     * 
     */
    public static void main(String[] args) {
            launch(args);
        }
	}
	

