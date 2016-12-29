import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static javax.swing.JOptionPane.*;

public class main {

	private static List<String> kortLista = new ArrayList<String>();
	private static List<String> playerList = new ArrayList<String>();
	
	public static SpelKort spelkort = new SpelKort();
	
	public static String winner = "", looser = "";
	public static int gameCounter = 0;
									
	/*															   \ \
	 *            ______                     ____    ______  ___    
	 * |\	  /| |       |\   |    /\      /		|       |   \   |
	 * | \	 / | |______ | \  |   /  \     | _____  |______ |   /   |
	 * |  \ /  | |       |  \ |  /____\	   |     |  |       |  <    |
	 * |   V   | |______ |   \| /      \   \_____/  |______ |   \   |
	 * 
	 */
	
	public static void main(String[] args) {
		
		boolean game = true; // main loop variable
		
		int nrOfPlayers = createPlayers();
		delautKort(nrOfPlayers);
	
		System.out.println(kortLista.size()); // for testing purposes
		
		while(game){ // main loop
			
			if(gameCounter < 52){
				
				checkAndList(nrOfPlayers);
				Collections.rotate(kortLista, -1);
				gameCounter++;
				showMessageDialog(null, "No one wins. Press ok to continue!");
			} else {
				
				System.out.println("We've made it here! Card Count: " + gameCounter);
				game=false;
			}
		}
	}	
	
	private static void checkAndList(int nrOfPlayers){
		
		boolean foundMatch = false;
		
		String referenceValor = getFirstValor(0, 1);
		
		int counter = 1;
			
		for(int i = 1; i < nrOfPlayers; i++){
			
			String pValors = getFirstValor(i, 1);
			System.out.println(referenceValor + " " + pValors);
			
			if(referenceValor.equals(pValors)){
				
				System.out.println("Works!");
				foundMatch = true;
				
				/* randomize who wins */
				
				String fPlayer[] = kortLista.get(0).split(";");
				String opponent[] = kortLista.get(i).split(";");
				
				String whoWins[] = {fPlayer[0], opponent[0]};
				
				int randomNum = 0 + (int)(Math.random() * 2); 
				
				String playerID = whoWins[randomNum];
				
				winner = playerID; // keep track of who wins
				
				if(winner.equals(fPlayer[0])){
					looser = opponent[0];
				} else if (winner.equals(opponent[0])){
					looser = fPlayer[0];
				}
				
				System.out.println("Winner: " + winner);
				System.out.println("Looser: " + looser);
				
				counter++;
				break;
				
			}  else {
				
				counter++;
				System.out.println("Nope");
				
			}
			counter++;
		}
		
		if(!foundMatch){
			
			for(int i = 0; i < nrOfPlayers; i++){
				spelkort.speladeKort(kortLista.get(0));
				kortLista.remove(0);
				gameCounter++;
			}
			
			spelkort.skrivUt();
			System.out.println("-----kortLista------");
			skrivUt();
			
		} else {
					
			for(int j = 0; j < counter; j++){ // counter instead of nrOfPlayers cause win might have interrupted the round
				spelkort.speladeKort(kortLista.get(0));
				kortLista.remove(0);
				gameCounter++;
			}
			
			spelkort.reverseList(); // korten i rätt ordning
			
			for(int k = 0; k < spelkort.getSpeladeKortSize(); k++){
				
				String spelkortSpelareKort[] = spelkort.getSpeladeKort(k).split(";");
				String fargOvalor[] = spelkortSpelareKort[1].split(" ");
												
				if(spelkortSpelareKort[0].equals(winner)||spelkortSpelareKort[0].equals(looser)){
					kortLista.add(winner + ";" + fargOvalor[0] + " " + fargOvalor[1]);
					spelkort.removeEntry(k);
					k=0; // to ensure the whole list is checked
				}
			}
			 
			//spelkort.resetList(); // töm listan
			
			spelkort.skrivUt();
			System.out.println("-----kortLista------");
			skrivUt();
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


