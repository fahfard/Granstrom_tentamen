import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpelKort implements SpelKortGranssnitt {
	
	private String farg[] = { "hjarter", "ruter", "klover", "spader" };
	private String valor[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" } ;
	
	private List<String> lagtKort = new ArrayList<String>();
	private List<String> vandtKort = new ArrayList<String>();
	private List<String> kortPacka = new ArrayList<String>();
	
	public void speladeKort(String inKort){

		String spelaresKort[] = inKort.split(";");
		String fargValor[] = spelaresKort[1].split(" ");
		
		vandtKort.add(spelaresKort[0] + ";" + fargValor[0] + " " + fargValor[1]);
	}
	
	public void removeEntry(int index){
		vandtKort.remove(index);
	}
	public void resetList(){
		vandtKort.clear();
	}
	public String getSpeladeKort(int index){
		return vandtKort.get(index);
	}
	
	public void reverseList(){
		Collections.reverse(vandtKort);
	}
	
	public int getSpeladeKortSize(){
		return vandtKort.size();
	}
	
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
		for(String lines: vandtKort)
			System.out.println(lines);
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
	
