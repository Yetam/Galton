import java.util.Random;

public class Galton {

	private int[][] mLevels;
	int n;
	double fitness;
	Random rnd = new Random();
	
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
			//g[i] = 5;
			/**
			 * TO TRZEBA PODMIENIC NA ZDEFINIOWANY Z ZEWNATRZ ROZKLAD.... JAKOŒ... :P
			 */
			if( i>(n/3) && (i<2*n/3)) {
				g[i]=10;
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
					//do nothing bo skret w lewo
					break;
				case 1:
					pos++; //skret w prawo
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
		this.setFitness(fit);
		
		System.out.println("Fitness: " + fit);
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
	void setFitness(double newFitness){
		fitness = newFitness;
	}
}
