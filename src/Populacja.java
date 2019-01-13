import java.util.ArrayList;

public class Populacja {
	ArrayList<Galton> pop = new ArrayList<Galton>();
	ArrayList<Galton> kid = new ArrayList<Galton>();
	
	Populacja(){
		//screen not connected...
	}
	
	void createGaltonPopulation(int n){
		for(int i=0;i<n;i++){
			pop.add(new Galton(20));
		}
	}
	
	void simulateGaltonPopulation(){
		
	}
	void sortGaltonPopulation(){
		
	}
	void createKidPopulation(){
		
	}
	void joinKidsAndPopulation(){
		
	}
	void mutatePopulation(){
		
	}
}
