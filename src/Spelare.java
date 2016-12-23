import static javax.swing.JOptionPane.showInputDialog;

public class Spelare extends Person{

	private Djur spelareDjur;
	private boolean spelarNu;
	private int tur;
	
	public Spelare(String namn, String ID, Djur spelareDjur){
		super.namn = namn;
		super.ID = ID;
		this.spelareDjur = spelareDjur;
	}
	
	public void speladeKort(){
		
	}
	
	public void adderaPackan(){
		
	}
	
	public void djurLate(){
		
	}
	
	
	
	public int vemsTur(){
		this.tur = tur;
		
		return this.tur;
	}
	
}
