import java.util.ArrayList;
import java.util.List;

public class main {

	private static List<String> kortLista = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		// For testing purposes
		DjurList djurList = new DjurList();
		djurList.getDjurlist();
		
		Spelare spelare1 = new Spelare("Ken", "123456-1234", "Ko"); // Test spelare 
		Spelare spelare2 = new Spelare("Mari", "123456-1234", "Fisk");
		
		delautKort(5);
		skrivUt();
		System.out.println(kortLista.size()); // for testing purposes
	}
	
	private static void delautKort(int nrOfPlayers){
		
		SpelKort spelkort = new SpelKort();
		spelkort.createDeck();
		
		int i = 0;
	
		while(i < 52){
			for(int j = 0; j < nrOfPlayers; j++){		
				kortLista.add("Spelare" + (j+1) + ":" + spelkort.getFärg(i) + " " + spelkort.getValör(i));
				i++;
				if(i >= 52)
					break;
			}
		}
	}
	
	private static void skrivUt(){
		for(String lines: kortLista){
			System.out.println(lines);
		}
	}
}


