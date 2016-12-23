import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpelKort implements SpelKortGranssnitt {
	
	private String farg[] = { "hjarter", "ruter", "klover", "spader" };
	private String valor[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" } ;
	
	private List<Spelare> lagtKort = new ArrayList<Spelare>();
	private List<Spelare> vandtKort = new ArrayList<Spelare>();
	private List<String> kortPacka = new ArrayList<String>();
	
	public String getValor(int index){
		
		String valor = kortPacka.get(index);
		String temp[] = valor.split(",");
		
		return temp[1];
	}
	
	public String getFarg(int index){
		
		String farg = kortPacka.get(index);
		String temp[] = farg.split(",");
		
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
		 for(String farger: farg){
			 for(String valorer: valor){
				 kortPacka.add(farger + "," + valorer);
			 }
		 }
		 Collections.shuffle(kortPacka); // shuffle the deck
	}
}	
	
