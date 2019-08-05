import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImportEvent implements EventArrayListClass{
	
		String filename;
		String line;
	/*public static void main(String[] args)  {
        System.out.println(strglobalEventList.get(0).getEvent_date());
	}*/    
        public static ObservableList<Event> ReadBoxFromCSV(String fileName) {
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
                ioe.printStackTrace();
            }
            Event a = new Event();
            existEvent = a.receiveEvent(words);
            return existEvent;
        }

}
