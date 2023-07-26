package es8_1;

import java.util.*;

public class Cittadini extends Thread
{   Sala s;
	int id;
	Random r;
	
	public  Cittadini(Sala S, int i, Random R)
	{	   this.s=S;
		   this.id=i;
		   this.r=R;
	}
        @Override
	public void run() {
		boolean entrato=false;
		int volte=0;
		for (volte=0; volte<5; volte++)
		{	entrato = s.entra(id);
			try {	
				if (entrato)
				{	
					System.out.println("Il thread " + id + "  e' entrato"); 
					Thread.sleep(r.nextInt(10)*1000);
					s.esce(id);
				}
				else {
					System.out.println("il  thread " + id + ":  non entra"); 
					Thread.sleep(r.nextInt(5)*1000);
				}
			} catch (InterruptedException e) {	}
		}
		if (!entrato)
			System.out.println("il  thread " + id + ":  dopo 5 tentativi lascia perdere");
		
	
	}

}

