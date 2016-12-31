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
		
		int counter = 0;
		
		nrOfPlayers = createPlayers();
		delautKort(nrOfPlayers);
		
		while(game){ // main loop
			
			if(isPlayerNext()){
				
				checkAndList(nrOfPlayers);
				showMessageDialog(null, "Press ok to continue!");
				
				if(theTurn < nrOfPlayers-1){ // keep track of who's in turn 
					theTurn++;  
				} else {
					theTurn = 0;
				}
				
				counter=0;
				
			} else {
				
				Collections.rotate(kortLista, -1); //rotate list to find next player
				System.out.println("Shuffled");
				counter++;
				if(counter >= kortLista.size()){
					if(lookForPlayer()){
						dealNewCards();
					} else {
						playerList.remove(theTurn);
						nrOfPlayers--;
						if(theTurn >= 1)
							theTurn--;
					}
				}
			}
		if(nrOfPlayers <= 1)
			game=false;
		}
	}	
	
	private static boolean lookForPlayer(){
		
		String inTurn[] = playerList.get(theTurn).split(",");
		
		for(int i = 0; i < spelkort.getWinCardsSize(); i++){
			
			String temp[] = spelkort.getWinCard(i).split(";");
			String temp2[] = temp[0].split(",");
			String nextPlayer[] = temp2[0].split(": ");	
			
			if(inTurn[0].equals(nextPlayer[1]))
				return true;
		}
		
		for(int j = 0; j < spelkort.getSpeladeKortSize(); j++){
			
			String temp[] = spelkort.getSpeladeKort(j).split(";");
			String temp2[] = temp[0].split(",");
			String nextPlayer[] = temp2[0].split(": ");	
			
			if(inTurn[0].equals(nextPlayer[1]))
				return true;
		}
		
		return false;
	}

	private static void dealNewCards(){
		
		while(kortLista.size() < 52){	
			for(String lines: playerList){
				
				try{
					String temp[] = spelkort.getWinCard(0).split(";");
					String temp2[] = temp[0].split(",");
					String nextPlayer[] = temp2[0].split(": ");
					String inTurn[] = lines.split(",");
						
					//System.out.println("Sorting winners list!");
						
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
						
						//System.out.println("Sorting played cards!" + kortLista.size());
						
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
			for(int i = 0; i < nrOfPlayers; i++){
				kortLista.get(i);
			}
		} catch (IndexOutOfBoundsException e){
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
		
		int turnNr = theTurn;
		
		boolean foundMatch = false;
		
		for(int run = 0; run < playerList.size(); run++){
			for(int j = 0; j < kortLista.size(); j++){	
					
				String referenceValor[] = playerList.get(turnNr).split(",");
				String referencePlayer[] = referenceValor[0].split(",");
				String pValors[] = kortLista.get(j).split(";");
				String pPlayer[] = pValors[0].split(",");
				String pPlayerAgain[] = pPlayer[0].split(": ");
			
				if(referencePlayer[0].equals(pPlayerAgain[1]) && run == j){
				} else if(referencePlayer[0].equals(pPlayerAgain[1]) && run != j){
					Collections.swap(kortLista, j, run);
				}
			}
			
			if(turnNr >= nrOfPlayers-1){
				turnNr = 0;
			} else {
				turnNr++;
			}
		}	
	}
	
	private static void checkAndList(int nrOfPlayers){
		
		boolean foundMatch = false;
		
		checkPlayers();
		
		String referenceValor[] = kortLista.get(0).split(";");
		String referenceFargValor[] = referenceValor[1].split(" ");
		String referencePlayer[] = referenceValor[0].split(",");
		
		int counter = 1;
			
		for(int i = 1; i < nrOfPlayers; i++){
			
			checkPlayers();
			
			String pValors[] = kortLista.get(i).split(";");
			String pFargValor[] = pValors[1].split(" ");
			String pPlayer[] = pValors[0].split(",");
			
			counter++;
			
			if(!referencePlayer[0].equals(pPlayer[0]))
				System.out.println(referencePlayer[0] + " Valör:" + referenceFargValor[1] + "\n Jämför mot: \n" + pPlayer[0] + " Valör:" + pFargValor[1] + "\n");
			
			if(referenceFargValor[1].equals(pFargValor[1]) && !referencePlayer[0].equals(pPlayer[0])){
				
				System.out.println("Samma valör!\n");
				foundMatch = true;
				
				/* randomize who wins */
				
				randomWin(i);
				
				System.out.println("Winner: " + winner);
				System.out.println("Looser: " + looser);
				
				String turnToWinner[] = winner.split(": ");
				
				for(int setTurn = 0; setTurn < playerList.size(); setTurn++){
				
					String playerListWin[] = playerList.get(setTurn).split(": ");
					
					if(playerListWin[0].equals(turnToWinner[1])){
						theTurn = setTurn;
						theTurn--;
					}
				}
				counter++;
				break;
				
			}  else {
				counter++;
				System.out.println("Nope, olika valörer!\n");
			}
			counter++;
		}
		
		if(!foundMatch){
			
			for(int i = 0; i < nrOfPlayers; i++){
				try{
					spelkort.speladeKort(kortLista.get(0));
					kortLista.remove(0);
				} catch (IndexOutOfBoundsException e){
					dealNewCards();
					spelkort.speladeKort(kortLista.get(0));
					kortLista.remove(0);
				}
			}
			
			/*System.out.println("-----kortLista------");
			skrivUt();*/
			
		} else {
			
			for(int j = 0; j < counter; j++){ // counter instead of nrOfPlayers cause win might have interrupted the round
				try{
					spelkort.speladeKort(kortLista.get(0));
					kortLista.remove(0);
				} catch (IndexOutOfBoundsException e){
					dealNewCards();
					spelkort.speladeKort(kortLista.get(0));
					kortLista.remove(0);
				}
			}
			
			for(int k = 0; k < spelkort.getSpeladeKortSize(); k++){
				
				String spelkortSpelareKort[] = spelkort.getSpeladeKort(k).split(";");
				String fargOvalor[] = spelkortSpelareKort[1].split(" ");
												
				if(spelkortSpelareKort[0].equals(winner)||spelkortSpelareKort[0].equals(looser)){
					spelkort.vunnetSpelatKort(winner + ";" + fargOvalor[0] + " " + fargOvalor[1]);
					spelkort.removeEntry(k);
					k=0; 
				}
			} 
			spelkort.reverseList(); // korten i rätt ordning
			/*skrivUt();*/
		}
		System.out.println("------------------------------------------------------");
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


