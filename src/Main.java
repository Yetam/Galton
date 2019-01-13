
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
		
		Populacja A = new Populacja();
		A.createGaltonPopulation(20);
		
		
		System.out.println("Rozpoczynam ewolucje");
		for(int i=0 ; i<2 ; i++){
			
			A.simulateGaltonPopulation();
		System.out.println(A.pop.size());
			A.sortGaltonPopulation();
		System.out.println(A.pop.size());
				A.printBestFitness();
		System.out.println(A.pop.size());	
			A.createKidPopulation();
		System.out.println(A.pop.size());
			A.joinKidsAndPopulation();
			System.out.println(A.pop.size());
			A.mutatePopulation(0.001);
			System.out.println(A.pop.size());
		}
	}

}
