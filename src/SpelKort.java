import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpelKort implements SpelKortGranssnitt {
	
	private String färg[] = { "hjärter", "ruter", "klöver", "spader" };
	private String valör[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" } ;
	
	private List<Spelare> lagtKort = new ArrayList<Spelare>();
	private List<Spelare> vändtKort = new ArrayList<Spelare>();
	private List<String> kortPacka = new ArrayList<String>();
	
	public String getValör(int index){
		
		String valör = kortPacka.get(index);
		String temp[] = valör.split(",");
		
		return temp[1];
	}
	
	public String getFärg(int index){
		
		String färg = kortPacka.get(index);
		String temp[] = färg.split(",");
		
		return temp[0];
	}
	
	public void skrivUt(){
		
	}
	
	public void printCards(){
		for(String lines: kortPacka){
			System.out.println(lines);
		}
		
	}
	
	public void createDeck(){
		 for(String färger: färg){
			 for(String valörer: valör){
				 kortPacka.add(färger + "," + valörer);
			 }
		 }
		 Collections.shuffle(kortPacka); // shuffle the deck
	}
}	
	
