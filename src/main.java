import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.*;

public class main {

	private static List<String> kortLista = new ArrayList<String>();
	private static List<String> playerList = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		// For testing purposes
		DjurList djurList = new DjurList();
		djurList.getDjurlist();
		
		int nrOfPlayers = createPlayers();
		
		delautKort(nrOfPlayers);
		skrivUt();
		System.out.println(kortLista.size()); // for testing purposes
	}
	
	private static void delautKort(int nrOfPlayers){
		
		SpelKort spelkort = new SpelKort();
		spelkort.createDeck();
		
		int i = 0;
	
		while(i < 52){
			for(int j = 0; j < nrOfPlayers; j++){		
				kortLista.add("Spelare: " + playerList.get(j) + ":" + spelkort.getFarg(i) + " " + spelkort.getValor(i));
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
		int nrOfPlayers = Integer.parseInt(indata);
		
		for(int i = 0; i < nrOfPlayers; i++){
			indata = showInputDialog(null, "Enter your name and an ID (e.g 'Joe 123456-1234')");
			String players[] = indata.split(" ");
			Spelare spelare = new Spelare(players[0], players[1], "Testanimals");
			playerList.add(players[0]);
		}
		return nrOfPlayers;
	}
}


