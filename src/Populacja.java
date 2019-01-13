import java.util.ArrayList;
import java.util.Comparator;

public class Populacja {
	ArrayList<Galton> pop = new ArrayList<Galton>();
	ArrayList<Galton> kid = new ArrayList<Galton>();

	Populacja() {
		// screen not connected...
	}

	void createGaltonPopulation(int n) {
		for (int i = 0; i < n; i++) {
			pop.add(new Galton(20));
		}
	}

	void simulateGaltonPopulation() {

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

	}

	void joinKidsAndPopulation() {

	}

	void mutatePopulation() {

	}
}
