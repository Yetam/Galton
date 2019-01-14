import java.util.Random;

public class Galton {

	private int[][] mLevels;
	int n;
	double fitness;
	Random rnd = new Random();
	
	int ID = rnd.nextInt();
	
	int[] y;
	int[] g;

	public Galton(int n) {
		this.n = n;
		
		mLevels = new int[n][];
		for (int i = 0; i < n; i++) {
			mLevels[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				int losuLosu = rnd.nextInt(3) - 1;
				mLevels[i][j] = losuLosu;
			}
		}
	}
	
	void simulate(){
		
		y = new int[n+1];	//osiagniety wynik
		g = new int[n+1];	//docelowy wynik
			
		//wypelnianie tablicy na docelowy rozklad
		for(int i=0;i<=n;i++){
			if(i>n/2){
				g[i]=10000;
			}
			else{
				g[i]=0;
			}
				
		}
		
		//okreslenie liczby kulek potrzebnych do galtona
		int k=0;			
		for(int i=0;i<=n;i++){
			k += g[i];
		}
		
		/**
		 * Ponizej jest symulacja spadania k kulek przez tablice
		 */
		for(int i=0;i<k;i++){
			int pos=0;
			for(int row=0;row<n;row++){
				//sprawdzenie gdzie mamy isc
				switch (this.getKolek(row, pos)) {
				case -1:
					if(rnd.nextFloat() > 0.00){
						pos++;
					}
					break;
				case 1:
					if(rnd.nextFloat() < 0.00){
						pos++;
					}
					break;
				case 0:
					if(rnd.nextDouble() > 0.5){
						pos++;
					}
					break;
				}
			}
			y[pos]++;
		}
		
	/*
		//wypisywanie otrzymanego
		for(int i=0;i<n;i++){
			System.out.print(y[i] + " ");
		}
		System.out.println("");
		//wypisywanie zalozonego
		for(int i=0;i<n;i++){
			System.out.print(g[i] + " ");
		}
		System.out.println("");
		*/
		
		/**
		 * Ponizej jest obliczanie funkcji celu
		 */
		double Y=0;						
		double G=0;
		for(int i=0;i<=n;i++){		
			Y += Math.abs(g[i]-y[i]);
			G += g[i];
		}

		double fit = ((G - Y)/G + 1)/2;
		//fit = Math.pow(fit, 4);
		this.setFitness(fit);
		
		//System.out.println("Fitness: " + fit);
	}

	public String toString() {
		String s = "";
		int maxLen = mLevels[mLevels.length - 1].length;
		int offset = maxLen;

		for (int i = 0; i < mLevels.length; i++) {
			for (int k = 0; k < offset; k++) {
				s += " ";
			}
			offset -= 1;

			for (int j = 0; j < mLevels[i].length; j++) {
				switch (mLevels[i][j]) {
				case -1:
					s += "l ";
					break;
				case 0:
					s += "0 ";
					break;
				case 1:
					s += "p ";
					break;
				}
			}
			s += "\n";
		}

		return s;
	}
	
	int getKolek( int row, int pos ){
		//System.out.println(row + " " + pos);
		return mLevels[row][pos];
	}
	void setKolek(int row, int pos, int newState){
		 mLevels[row][pos] = newState;
	}
	void setFitness(double newFitness){
		fitness = newFitness;
	}
	
	public Galton(Galton parent) {
		this.n = parent.n;
		mLevels = parent.mLevels.clone();
		//this.fitness = parent.fitness;
		this.fitness = 0;
		this.ID = parent.ID;
	}
	
	public void cross(Galton other) {
		int size = (n+1)*n/2;
		
		int a = rnd.nextInt(size);
	    int b = rnd.nextInt(size);

		while(a == b) {
			b = rnd.nextInt(size);
		}
		int tmp;
		if(a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		//System.out.println("a " + a + " " + b);
		
		int[] oneDimA = new int[size];
		int[] oneDimB = new int[size];
		
		int counter = 0;
		for(int i = 0; i < mLevels.length; i++) {
			for(int j = 0; j < mLevels[i].length; j++) {
				oneDimA[counter] = mLevels[i][j];
				oneDimB[counter++] = other.mLevels[i][j];
			}
		}
		
		for(int i = a; i <= b; i++) {
			tmp = oneDimA[i];
			oneDimA[i] = oneDimB[i];
			oneDimB[i] = tmp;
		}
		
		counter= 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				mLevels[i][j] = oneDimA[counter];
				other.mLevels[i][j] = oneDimB[counter++];
			}
		}
		
		this.ID = rnd.nextInt();
		other.ID = rnd.nextInt();
	}
	String printGalton(){
		String s = "";
		for(int i=0;i<n+1;i++){
			s += (y[i] + " ");
		}
		
		return s;
	}
}
