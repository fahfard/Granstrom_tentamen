import java.util.ArrayList;
import java.util.List;

public class Djur {

	private String animal;
	private String animalSound;
	
	
	public Djur(String animal, String animalSound){
		this.animal = animal;
		this.animalSound = animalSound;
	}
	
	public static void main(String[] args) {
		
		// For testing purposes
		DjurList djurList = new DjurList();
		djurList.getDjurlist();
		
	}
	
	public String toString(){
		return this.animal + "-" + this.animalSound;
	}

}
