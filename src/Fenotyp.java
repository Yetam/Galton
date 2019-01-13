import java.util.ArrayList;

public class Fenotyp {
	
	
	
	int n;
	
	Fenotyp(Population organizm){
		this.n = organizm.n;
		
		int[] y = new int[n+1];	//osiagniety wynik
		int[] g = new int[n+1];	//docelowy wynik
			
		//wypelnianie tablicy na docelowy rozklad
		for(int i=0;i<n;i++){	
			g[i] = 5;
		}
		
		//okreslenie liczby kulek potrzebnych do galtona
		int k=0;			
		for(int i=0;i<n;i++){
			k += g[i];
		}
		
		/*
		 * Ponizej jest symulacja spadania k kulek prze tablice
		 */
		for(int i=0;i<k;i++){
			int pozycja=n/2;
			for(int row=0;row<n;row++){
				
			}
		}
		
	}
	
	
}
