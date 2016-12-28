
public abstract class Person {
	
	String namn;
	String ID; // 6 siffror - 4 siffror
	
	public String getNamn(){
		
		return this.namn;
	}
	
	public String getID(){
		
		return this.ID;
	}
	
	public String toString(){
		
		return this.namn + " " + this.ID;
	}
	
}
