import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpelKort implements SpelKortGranssnitt {
	
	private String f�rg[] = { "hj�rter", "ruter", "kl�ver", "spader" };
	private String val�r[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" } ;
	
	private List<Spelare> lagtKort = new ArrayList<Spelare>();
	private List<Spelare> v�ndtKort = new ArrayList<Spelare>();
	private List<String> kortPacka = new ArrayList<String>();
	
	public String getVal�r(int index){
		
		String val�r = kortPacka.get(index);
		String temp[] = val�r.split(",");
		
		return temp[1];
	}
	
	public String getF�rg(int index){
		
		String f�rg = kortPacka.get(index);
		String temp[] = f�rg.split(",");
		
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
		 for(String f�rger: f�rg){
			 for(String val�rer: val�r){
				 kortPacka.add(f�rger + "," + val�rer);
			 }
		 }
		 Collections.shuffle(kortPacka); // shuffle the deck
	}
}	
	
