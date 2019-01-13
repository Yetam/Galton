import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Populacja {
	ArrayList<Galton> pop = new ArrayList<Galton>();
	ArrayList<Galton> kid = new ArrayList<Galton>();
	
	double sumOfFitness;
	Random rnd = new Random();

	Populacja() {
		// screen not connected...
	}

	void createGaltonPopulation(int n) {
		for (int i = 0; i < n; i++) {
			pop.add(new Galton(20));
		}
	}

	void simulateGaltonPopulation() {
		for(int i=0;i<pop.size();i++){
			pop.get(i).simulate();
		}
	}

	void sortGaltonPopulation() {
		pop.sort(new Comparator<Galton>() {
			@Override
			public int compare(Galton o1, Galton o2) {
				return o1.fitness > o2.fitness ? -1 : 1;
			}
		});
	}

	void createKidPopulation() {
		sumOfFitness=0;
		for(int i=0 ; i<pop.size()/2 ; i++){
			sumOfFitness += pop.get(i).fitness;
		}
		
		for(int i=0;i<pop.size()/2;i++){
			
			/**
			 * Ponizsze liniki maja wylosowac dwoch roznych rodzicow z populacji
			 */
			int parent1 = 0;
			int parent2 = 0;
			while(parent1 == parent2){
				parent1 = choseByRoulette();
				parent2 = choseByRoulette();
			}
			
		}
		
	}
	int choseByRoulette(){
		//wyznacz liczbe losowa od 0 do sumFitness
		double roulette = rnd.nextDouble()*sumOfFitness;
		int chosen=pop.size()-1;
		
		//odejmuj od wylosowanej kolejne fitnesy tak dlugo az nie bedzie mniejsza od zera. Jesli bedzie to oznacza ze dany iterator to wylosowany element
		for(int i=0;i<pop.size();i++){
			roulette-=pop.get(i).fitness;
			if(roulette<0){
				chosen = i;
				break;
			}
		}
		
		return chosen;
	}
	

	void joinKidsAndPopulation() {
	
	}

	void mutatePopulation() {

	}
}
