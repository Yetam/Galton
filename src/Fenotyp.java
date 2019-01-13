import java.util.ArrayList;
import java.util.Random;

public class Fenotyp {
	
	
	
	int n;
	Random rnd = new Random();
	
	Fenotyp(Population organizm){
		this.n = organizm.n;
		
		int[] y = new int[n+1];	//osiagniety wynik
		int[] g = new int[n+1];	//docelowy wynik
			
		//wypelnianie tablicy na docelowy rozklad
		for(int i=0;i<=n;i++){	
			g[i] = 5;
			/**
			 * TO TRZEBA PODMIENIC NA ZDEFINIOWANY Z ZEWNATRZ ROZKLAD.... JAKOŒ... :P
			 */
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
				switch (organizm.getKolek(row, pos)) {
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
		
		for(int i=0;i<n;i++){
			System.out.print(y[i] + " ");
		}
		System.out.println("");
	}
	
	
}
