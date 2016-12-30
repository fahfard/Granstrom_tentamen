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
	
	public static int theTurn = 0, nrOfPlayers = 0;
									
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
		
		nrOfPlayers = createPlayers();
		delautKort(nrOfPlayers);
		
		while(game){ // main loop
			
			if(isPlayerNext()){
				
				checkPlayers();
				checkAndList(nrOfPlayers);
				showMessageDialog(null, "No one wins. Press ok to continue!");
				
				if(theTurn < nrOfPlayers-1){ // keep track of who's in turn 
					theTurn++;  
				} else {
					theTurn = 0;
				}
									
			} else {
				
				Collections.rotate(kortLista, -1); //rotate list to find next player
				System.out.println("Shuffled");
			}
		}
	}	
	
	private static void dealNewCards(){
		
		while(kortLista.size() < 52){	
			for(String lines: playerList){
				
				try{
					String temp[] = spelkort.getWinCard(0).split(";");
					String temp2[] = temp[0].split(",");
					String nextPlayer[] = temp2[0].split(": ");
					String inTurn[] = lines.split(",");
						
					System.out.println("Sorting winners list!");
						
					if(inTurn[0].equals(nextPlayer[1])){
						kortLista.add(spelkort.getWinCard(0));
						spelkort.removeWinIndex(0);
						
					}
				} catch (IndexOutOfBoundsException e){
					try{
						String temp[] = spelkort.getSpeladeKort(0).split(";");
						String temp2[] = temp[0].split(",");
						String nextPlayer[] = temp2[0].split(": ");
						String inTurn[] = lines.split(",");
						
						System.out.println("Sorting played cards!");
						
						if(inTurn[0].equals(nextPlayer[1])){
							kortLista.add(spelkort.getSpeladeKort(0));
							spelkort.removeEntry(0);
					
						}
					} catch (IndexOutOfBoundsException ex){
						System.out.println(kortLista.size());
					}
				}
			}
		}
	}
	
	private static boolean isPlayerNext(){
		
		boolean retVal = false;
		
		try{
			for(int i = 0; i < nrOfPlayers; i++)
				kortLista.get(i);
		} catch (IndexOutOfBoundsException e){
			System.out.println("Deal new cards function here");
			dealNewCards();	
		}
		
		String temp[] = kortLista.get(0).split(";");
		String temp2[] = temp[0].split(",");
		String nextPlayer[] = temp2[0].split(": ");
		
		String inTurn[] = playerList.get(theTurn).split(",");
		
		if(inTurn[0].equals(nextPlayer[1]))
			retVal = true;
		
		return retVal;
	}
	
	private static void randomWin(int index){
	
		String fPlayer[] = kortLista.get(0).split(";");
		String opponent[] = kortLista.get(index).split(";");
		
		String whoWins[] = {fPlayer[0], opponent[0]};
		
		int randomNum = 0 + (int)(Math.random() * 2); 
		
		String playerID = whoWins[randomNum];
		
		winner = playerID; // keep track of who wins
		
		if(winner.equals(fPlayer[0])){
			looser = opponent[0];
		} else if (winner.equals(opponent[0])){
			looser = fPlayer[0];
		}
	}
	private static void checkPlayers(){
		
		boolean isSame = true;
		
		while(isSame){
			for(int i = 0; i < nrOfPlayers; i++){	
				for(int j = 1; j < nrOfPlayers; j++){	
					
					String referenceValor[] = getFirstValor(i).split(";");
					String referencePlayer[] = referenceValor[0].split(",");
					String pValors[] = getFirstValor(j).split(";");
					String pPlayer[] = pValors[0].split(",");
				
					//System.out.println(referencePlayer[0] + " " + pPlayer[0]);
					
					if(referencePlayer[0].equals(pPlayer[0]) && i != j){
						Collections.swap(kortLista, j, kortLista.size()-1);
						System.out.println("Found player match, shuffling!");
					} else {
						isSame = false;
					}
				}
			}
		}
	}
	
	private static void checkAndList(int nrOfPlayers){
		
		boolean foundMatch = false;
		
		String referenceValor[] = getFirstValor(0).split(";");
		String referenceFargValor[] = referenceValor[1].split(" ");
		String referencePlayer[] = referenceValor[0].split(",");
		
		int counter = 1;
			
		for(int i = 1; i < nrOfPlayers; i++){
			
	
			String pValors[] = getFirstValor(i).split(";");
			String pFargValor[] = pValors[1].split(" ");
			String pPlayer[] = pValors[0].split(",");
			
			counter++;
			
			System.out.println(referencePlayer[0] + " Val�r:" + referenceFargValor[1] + "\n J�mf�r mot: \n" + pPlayer[0] + " Val�r:" + pFargValor[1]);
			
			if(referenceFargValor[1].equals(pFargValor[1])){
				
				System.out.println("Match!");
				foundMatch = true;
				
				/* randomize who wins */
				
				randomWin(i);
				
				System.out.println("Winner: " + winner);
				System.out.println("Looser: " + looser);
				
				counter++;
				break;
				
			}  else {
				
				counter++;
				System.out.println("No Match");
				
			}
			counter++;
		}
		
		if(!foundMatch){
			
			for(int i = 0; i < nrOfPlayers; i++){
				spelkort.speladeKort(kortLista.get(0));
				kortLista.remove(0);
			}
			
			spelkort.skrivUt();
			System.out.println("-----kortLista------");
			skrivUt();
			
		} else {
			
			
			for(int j = 0; j < counter; j++){ // counter instead of nrOfPlayers cause win might have interrupted the round
				spelkort.speladeKort(kortLista.get(0));
				kortLista.remove(0);
			}
			
			for(int k = 0; k < spelkort.getSpeladeKortSize(); k++){
				
				String spelkortSpelareKort[] = spelkort.getSpeladeKort(k).split(";");
				String fargOvalor[] = spelkortSpelareKort[1].split(" ");
												
				if(spelkortSpelareKort[0].equals(winner)||spelkortSpelareKort[0].equals(looser)){
					//kortLista.add(winner + ";" + fargOvalor[0] + " " + fargOvalor[1]);
					spelkort.vunnetSpelatKort(winner + ";" + fargOvalor[0] + " " + fargOvalor[1]);
					spelkort.removeEntry(k);
					k=0; // to ensure the whole list is checked
				}
			} 
			
			spelkort.reverseList(); // korten i r�tt ordning
				
			spelkort.skrivUt();
			System.out.println("-----kortLista------");
			skrivUt();
		}
	
	}
	
	
	private static String getFirstValor(int index){
			
				String Spelare = kortLista.get(index);
			
				return Spelare;
		
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


