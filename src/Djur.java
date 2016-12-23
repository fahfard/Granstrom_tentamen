import java.util.ArrayList;
import java.util.List;

public class Djur {

	private String animal;
	private String animalSound;
	
	
	public Djur(String animal, String animalSound){
		this.animal = animal;
		this.animalSound = animalSound;
	}
	
	public String toString(){
		return this.animal + "-" + this.animalSound;
	}

}
