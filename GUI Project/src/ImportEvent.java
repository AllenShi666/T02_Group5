import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * @author Team5
 * This class will have two methods built-in, one is to take info from existing *.csv file, the other one is to export info stored in ObservableList &lt;Event&gt; 
 * to a *.csv, so that next time the program run, we do not lose any info from last run
 *
 */
public class ImportEvent implements EventArrayListClass{
	
		private FileWriter csvWriter;
		
		 /**
         * ReadBoxFromCSV will take the *.csv file name, import every single cell in the csv file and store info to ObservableList &lt;Event&gt; in the type of Event.
         * If there is no file exist whe nthe application run, it will create one test.csv file with all school event inside 
         * @param fileName String filename for *.csv file
         * @return ObservableList &lt;Event&gt; the ObservableList will store all event from *.csv file 
         */
        public ObservableList<Event> ReadBoxFromCSV(String fileName) {
        	int row = 0;
        	int column = 0;
        	List<String> words = new ArrayList<String>();
        	ObservableList<Event> existEvent = FXCollections.observableArrayList();
            Path pathToFile = Paths.get(fileName);
        
            try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) {
                String line = br.readLine();
                while (line != null) {
                	String[] attributes = line.split(",");
                    column = attributes.length;
                    for (int j = 0; j < column; j++) {
                    	words.add(attributes[j]);
                    }
                    line = br.readLine();
                    row++; 
                } 
            } catch (IOException ioe) {
	            
				try {
					List<List<String>> rows = Arrays.asList(
        			    Arrays.asList("Labour Day", "2019-09-02","N/A","N/A","N/A","Statutory Holiday","Public"),
        			    Arrays.asList("Start of Classes", "2019-09-05", "N/A","N/A","N/A","Start of Class for Fall 2019","Public"),
        			    Arrays.asList("Last day to Drop", "2019-09-12", "N/A","N/A","N/A","Last day to drop a class without financial penalty","Public"),
        			    Arrays.asList("Tuition and Fee Deadline", "2019-09-20", "N/A","N/A","N/A","Deadline to pay for tuition and fee","Public"));
					csvWriter = new FileWriter("Test.csv");
					csvWriter.append("Subject");
	    			csvWriter.append(",");
	    			csvWriter.append("Start Date");
	    			csvWriter.append(",");
	    			csvWriter.append("End Date");
	    			csvWriter.append(",");
	    			csvWriter.append("Start Time");
	    			csvWriter.append(",");
	    			csvWriter.append("End Time");
	    			csvWriter.append(",");
	    			csvWriter.append("Description");
	    			csvWriter.append(",");
	    			csvWriter.append("Private");
	    			csvWriter.append("\n");
	    			
	    			for (List<String> rowData : rows) {
	    			    csvWriter.append(String.join(",", rowData));
	    			    csvWriter.append("\n");
	    			}
	    			csvWriter.flush();
	    			csvWriter.close();
	    			BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII);
	                String line = br.readLine();
	                while (line != null) {
	                	String[] attributes = line.split(",");
	                    column = attributes.length;
	                    for (int j = 0; j < column; j++) {
	                    	words.add(attributes[j]);
	                    }
	                    line = br.readLine();
	                    row++; }
	                }catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("not found");
				}		
				
            } 
            Event a = new Event();
            existEvent = a.receiveEvent(words);
            return existEvent;
        }
        
        /**
         * ExportCSV will export every event that user created in the program to a *.csv file
         * @param event take in the argument as event which has all event info stored
         */
        public void ExportCSV(Event event) {
			try {
				csvWriter = new FileWriter("Test.csv",true);
	 	        csvWriter.append(event.getEvent_name());
	 	        csvWriter.append(",");
		        csvWriter.append(event.getEvent_date());
		        csvWriter.append(",");
		        csvWriter.append("N/A");
		        csvWriter.append(",");
		        csvWriter.append(event.getEvent_StartTime());
		        csvWriter.append(",");
		        csvWriter.append(event.getEvent_EndTime());
		        csvWriter.append(",");
		        csvWriter.append(event.getEvent_description());
		        csvWriter.append(",");
		        csvWriter.append("N/A");
		        csvWriter.append("\n");
		        csvWriter.flush();
		        csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
        }

}
