package es8_1;
import java.util.Random;

public class Main{
	private final static int SAXC = 300;// massimo numero di cittadini
	private final static int SAXS=20; // capienza max sala
	
	public static void main(String[] args) {
		
		 Random r = new Random(System.currentTimeMillis());
		 int NC = r.nextInt(SAXC);
		 Cittadini[] V = new Cittadini[NC];
		 Sala S = new Sala(SAXS);
		 int i;
	
		 System.out.println("la capienza massima della sala è di "+SAXS+" posti \n\n");

		 for	(i=0; i<NC; i++)
			 V[i] = new Cittadini(S,i,r);
	
		 // attivazione cittadini:	
		 for	(i=0; i<NC; i++)
			 V[i].start();	
		
		 //attesa terminazione cittadini:
		 try {
			 for(i=0; i<NC; i++)
				 V[i].join(); 
		 } catch (InterruptedException e) {	}
		 //stampa valori finali:
		 S.stampa(); 
	}
}
