
public abstract class Person {
	
	String namn;
	String ID; // 6 siffror - 4 siffror
	
	public String getNamn(){
		this.namn = namn;
		
		return this.namn;
	}
	
	public String getID(){
		this.ID = ID;
		
		return this.ID;
	}
	
	public String toString(){
		
		return this.namn + " " + this.ID;
	}
	
}
