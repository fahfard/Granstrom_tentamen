import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static javax.swing.JOptionPane.*;

public class main {

	private static List<String> kortLista = new ArrayList<String>();
	private static List<String> playerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		boolean game = true; // main loop variable
		
		int nrOfPlayers = createPlayers();
		
		delautKort(nrOfPlayers);
		
		skrivUt();
		System.out.println(kortLista.size()); // for testing purposes
		
		while(game){ // main loop
			
			
				checkAndList(nrOfPlayers);
				game=false;
					
			
		}
	}
	
	private static void checkAndList(int nrOfPlayers){
		
		boolean foundMatch = false;
		
		String referenceValor = getFirstValor(0, 1);
		
		for(int i = 1; i < nrOfPlayers; i++){
			
			String pValors = getFirstValor(i, 1);
			
			System.out.println(referenceValor + " " + pValors);
			
			if(referenceValor.equals(pValors)){
				System.out.println("Works!");
				foundMatch = true;
			} else {
				System.out.println("Nope");
				
			}
			
		//	kortLista.remove(i);
		//	kortLista.remove(0); // remove first player also
			
			//System.out.println("So is this the next card?: " + kortLista.get(0));
			
		}
		
		if(!foundMatch){
			SpelKort spelkort = new SpelKort();
			for(int i = 0; i < nrOfPlayers; i++){
				spelkort.speladeKort(kortLista.get(0));
				kortLista.remove(0);
			}
			
		}
	}
	
	
	private static String getFirstValor(int index, int index2){
			
				String forstaSpelare = kortLista.get(index);
				
				String spelareOchKort[] = forstaSpelare.split(";"); // dela upp listan i spelare, id och djur mot farg och valor
				String fargOchValor[] = spelareOchKort[1].split(" "); // dela upp farg och valor
				
				return fargOchValor[index2];
		
	}
	
	private static void delautKort(int nrOfPlayers){
		
		SpelKort spelkort = new SpelKort();
		spelkort.createDeck();
		
		int i = 0;
	
		while(i < 52){
			for(int j = 0; j < nrOfPlayers; j++){		
				kortLista.add("Spelare: " + playerList.get(j) + ";" + spelkort.getFarg(i) + " " + spelkort.getValor(i));
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
	public static int createPlayers(){
		
		String indata = showInputDialog(null, "Enter number of players: ");
		
		if(indata != null){
			int nrOfPlayers = Integer.parseInt(indata);
			if(nrOfPlayers >= 4 && nrOfPlayers <= 10){
				
				DjurList djurList = new DjurList();
				djurList.getDjurlist();
				
				for(int i = 0; i < nrOfPlayers; i++){
					if(djurList.getListSize() < nrOfPlayers){
						int temp = nrOfPlayers - djurList.getListSize();
						for(int j = 0; j < temp; j++){
							djurList.addDjur();
						}
						djurList.checkDjurlist();
					}
					
					indata = showInputDialog(null, "Enter your name and an ID (e.g 'Joe 123456-1234')");
					if(indata != null){
						
						String players[] = indata.split(" ");
						Djur djurAndSound = djurList.getDjurAndSound();
						
						Spelare spelare = new Spelare(players[0], players[1], djurAndSound, true, i);
						
						playerList.add(spelare.getNamn() + ", " + spelare.getID() + " - " + djurAndSound + " Tur: " + i);
						
					} else {
						showMessageDialog(null, "Empty input or cancel. Terminating.");
						System.exit(0);
					}
				}
			} else {
				showMessageDialog(null, "Fel antal spelare. Skriv in ett antal mellan 4 och 10");
				createPlayers(); // recursive call to try again
			}
			return nrOfPlayers;
		} else {
			showMessageDialog(null, "No input. Terminating.");
			System.exit(0); // if no input or cancel then terminate
		}
		return 0;
	}
}


