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
	private int listSize;
	
	public void getDjurlist(){
		loadDjur();
		checkDjurlist();
	}
	
	public void addDjur(){ 
	
		String indata = showInputDialog(null, "Skriv in djur och l�te (e.g Ko,Mu): ");
		
		try{
			if(indata != null){ // in case empty input or cancel
				String djurSound[] = indata.split(",");
				
				Djur djur = new Djur(djurSound[0], djurSound[1]);
				
				djurLists.add(djur);
				listSize++;
			}
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public Djur getDjurAndSound(){
		
		
		Collections.shuffle(djurLists);

		while(djurLists.size() > 2){
		
			Djur tempDjur = djurLists.get(0);	
			djurLists.remove(0);
			
			return tempDjur;
			
		}
		
		return djurLists.get(0);
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
		
		for(String lines: LinkedSet){ 			
			String djurSound[] = lines.split("-");
			Djur djur = new Djur(djurSound[0], djurSound[1]);
			djurLists.add(djur);
		}
		
		if(djurLists.size() != listSize)
			listSize = djurLists.size()+1;
		
	}
	
	public int getListSize(){
		return listSize;	
	}
	

	public void loadDjur() {
		
		String csvFile = "djur.txt";
	    BufferedReader br = null;
	    String line = "";
	
	    try {
	    	
	    	br = new BufferedReader(new FileReader(csvFile));
	
	        listSize = Integer.parseInt(br.readLine()); // read the first line and save listSize
	        
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
