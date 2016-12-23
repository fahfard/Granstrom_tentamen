import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import static javax.swing.JOptionPane.*;

public class DjurList {

	private List<Djur> djurLists = new ArrayList<Djur>();
	
	public void getDjurlist(){
		loadDjur();
		//addDjur();
		checkDjurlist();
	}
	
	public void addDjur(){ 
		String indata = showInputDialog(null, "Skriv in djur och l�te (e.g Ko,Mu): ");
		
		try{
			if(indata != null){ // in case empty input or cancel
				String djurSound[] = indata.split(",");
				
				Djur djur = new Djur(djurSound[0], djurSound[1]);
				
				djurLists.add(djur);
			}
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public Djur getDjurAndSound(){
		
		Collections.shuffle(djurLists);
		Djur tempDjur = djurLists.get(1);
		djurLists.remove(1);
		
		return tempDjur;
	}
	
	public void checkDjurlist(){
		
		List<String> bufferedList = new ArrayList<String>(); // create a buffered List of type string for sorting
		
		String tempStringbuffer = "";
		
		for(Djur lines: djurLists){ // copy elements
			tempStringbuffer += lines;
			bufferedList.add(tempStringbuffer);
			tempStringbuffer = "";
		}
		
		djurLists.clear(); // empty djurLists
		
		Set<String> LinkedSet = new LinkedHashSet<String>(bufferedList);  // create LinkedHashset to eliminate duplicates
		
		for(String lines: LinkedSet){ // for testing purposes; print LinkedHashSet			
			String djurSound[] = lines.split("-");
			Djur djur = new Djur(djurSound[0], djurSound[1]);
			djurLists.add(djur);
		}
	}

	public void loadDjur() {
		String csvFile = "djur.txt";
	    BufferedReader br = null;
	    String line = "";
	
	    try {
	        br = new BufferedReader(new FileReader(csvFile));
	
	        br.readLine(); // read the first line
	        
	        while ((line = br.readLine()) != null) {
				if(line != null){	// in case file is empty
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
