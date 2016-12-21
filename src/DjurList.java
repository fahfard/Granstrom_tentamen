import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DjurList {

public List<Djur> djurLists = new ArrayList<Djur>();
	
	public void loadDjur() {
		String csvFile = "djur.txt";
	    BufferedReader br = null;
	    String line = "";
	
	    try {
	        br = new BufferedReader(new FileReader(csvFile));
	
	        //br.readLine(); // read the first line
	        
	        while ((line = br.readLine()) != null) {
				if(line != null){	// incase file is empty
	            	String[] djurandSound = line.split(",");
					
	            	Djur djur = new Djur(djurandSound[0], djurandSound[1]);
					this.djurLists.add(djur);
				}
			} 
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	    	}
		}
	}
}
