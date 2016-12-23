
public class Spelare extends Person{

	private String spelareDjur;
	private boolean spelarNu;
	private int tur;
	
	public Spelare(String namn, String ID, String spelareDjur){
		super.namn = namn;
		super.ID = ID;
		this.spelareDjur = spelareDjur;
	}
	
	public void speladeKort(){
		
	}
	
	public void adderaPackan(){
		
	}
	
	public void djurLäte(){
		
	}
	
	public int vemsTur(){
		this.tur = tur;
		
		return this.tur;
	}
	
}
