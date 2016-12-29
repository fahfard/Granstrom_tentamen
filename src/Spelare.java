
public class Spelare extends Person{

	private Djur spelareDjur;
	private boolean spelarNu;
	private int tur;
	
	public Spelare(String namn, String ID, Djur spelareDjur, boolean spelarNu, int tur){
		super.namn = namn;
		super.ID = ID;
		this.spelareDjur = spelareDjur;
		this.spelarNu = spelarNu;
		this.tur = tur;
	}
	
	public int vemsTur(){
		this.tur = tur;
		
		return this.tur;
	}
	
}
