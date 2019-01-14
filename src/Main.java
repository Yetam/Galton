
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Galton a = new Galton(5);
		Galton b = new Galton(5);

		//Fenotyp f = new Fenotyp(p);
		
		System.out.println(a);
		System.out.println(b);
		
		a.cross(b);
		
		System.out.println(a);
		System.out.println(b);
//		Plot pp = new Plot("a");	
//		pp.setData(new int[] {-1,1,0}, new int[] {0,1,-2},new int[] {-1,0,-2});
		
		*/

/**
 * TESTOWANIE POWTARZALNOSCI
 */
		/*
		Galton g = new Galton(16);
		for(int i=0;i<100;i++){
			g.simulate();
			System.out.println(g.fitness);
		}
		*/
		
/**
 * SYMULACJA
 */
		
		Populacja A = new Populacja();
		A.createGaltonPopulation(40);
		
		
		System.out.println("Rozpoczynam ewolucje");
		for(int i=0 ; i<100 ; i++){
			System.out.println("\n Generacja: " + i);
			
			A.addRandom();
			A.printAllFitness();
			A.simulateGaltonPopulation();
			A.printAllFitness();
			A.sortGaltonPopulation();
			
			A.printBestFitness();
			
			A.createKidPopulation();
			
			A.joinKidsAndPopulation();
			
			//A.mutatePopulation(0.0000001);
			A.pop.get(0).printGalton();
			
			
			
			//A.printAllFitness();
		
		}

	}

}
