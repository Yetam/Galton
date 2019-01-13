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
			pop.add(new Galton(12));
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
				return o1.fitness >= o2.fitness ? -1 : 1;
			}
		});
	}

	void createKidPopulation() {
		kid.clear();
		sumOfFitness=0;
		for(int i=0 ; i<pop.size()/2 ; i++){
			sumOfFitness += pop.get(i).fitness;
		}
		
		for(int i=0;i<pop.size()/4;i++){
			
			/**
			 * Ponizsze liniki maja wylosowac dwoch roznych rodzicow z populacji
			 */
			int parent1 = choseByRoulette();
			int parent2 = choseByRoulette();
			while(parent1 == parent2){
				parent2 = choseByRoulette();
			}
			//System.out.println(parent1 + " " + parent2);
			
			kid.add( new Galton(pop.get(parent1)) );
			kid.add( new Galton(pop.get(parent2)) );
		}
		
		for(int i=0;i<kid.size();i+=2){
			kid.get(i).cross(kid.get(i+1));
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
		//petla usuwajaca najgorsza polowe osbnikow z pop. Iteruje od tylu
		int maxIterationForAdding = pop.size()/2;
		for(int stryczek = 0 ; stryczek < maxIterationForAdding ; stryczek++){
			pop.remove(pop.size()-1);
		}
		
		for(int oknoZycia = 0 ; oknoZycia < maxIterationForAdding ; oknoZycia++){
			pop.add(new Galton(kid.get(oknoZycia)));
		}
	}

	void mutatePopulation(double chance) {
		int changes=0;
		for(int i=(pop.size()/2) ; i<(pop.size()) ; i++){		//iteruj po wszystkich organizmach
			for(int row=0 ; row<pop.get(i).n ; row++){	//iteruj po wszystkich rzedach danego organizmu
				for(int pos=0 ; pos<=row ; pos++){			//iteruj po wszystkich kolkach danego rzedu
					if(rnd.nextDouble() < chance){				//czy ma zajsc mutacja
						double newState = pop.get(i).getKolek(row, pos);	//zmienna na nowy stan
						while(newState == pop.get(i).getKolek(row, pos)){	//losuj nowy stan tak dlugo az nie wylosujesz innego niz jest
							pop.get(i).setKolek(row, pos, rnd.nextInt(3) - 1);	//wylosuj nowy stan kolka
						}
						changes++;
					}
				}
			}
		}
		System.out.println("Changes made by mutation: " + changes);
	}
	void printBestFitness(){
		System.out.println(pop.get(0).fitness);
	}
	void printAllFitness(){
		for(int i=0;i<pop.size();i++){
			System.out.print(" " + String.format("%.4f", pop.get(i).fitness));
		}
		System.out.println("");
		for(int i=0;i<pop.size();i++){
			System.out.print(" " + pop.get(i).ID);
		}
		System.out.println("");
	}
}
