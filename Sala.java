package es8_1;

import java.util.Random;

public class Sala {
	// var. locali: capienza, ora posti occupati, pacchi_abbigliamento,giocattoli, donatori
	private  int capienza;
	private int liberi,  donatori,p_abiti,giochi;
	float denaro;
	private final static int MAXOGGETTI=20;

	public  Sala(int MAX)
	{	this.capienza=MAX;
		this.liberi=capienza;
		this.donatori=0;
		this.p_abiti=0;
		this.giochi=0;
		this.denaro=0;
		
	}
	
	public synchronized void esce(int id)
	{ 		
			liberi++;
	}
	
	public synchronized boolean entra(int id)
	{	boolean risultato;	
		System.out.println("ENTRA "+id+" - I posti liberi sono " + liberi );

		if (liberi>0)
		{	risultato=true;
			liberi --;
			donatori++;
			
			//ora deve donare
			Random r = new Random(System.currentTimeMillis());
			int c_abiti = r.nextInt(MAXOGGETTI);
			Random  r1= new Random(System.currentTimeMillis());
			int c_giochi = r1.nextInt(MAXOGGETTI);
			Random r2= new Random(System.currentTimeMillis());
			float c_soldi= r2.nextInt(MAXOGGETTI);
			
			p_abiti=p_abiti+c_abiti;
			giochi=giochi+c_giochi;
			denaro=denaro+c_soldi;
			
		}
		else risultato=false;
		return risultato; 	
	}

	
	public synchronized void stampa()
	{ 	
		System.out.println("Chiusura Sala, esito donazione:\n capi di abbigliamento " +p_abiti + "\ngiocattoli: " + giochi +"\ndenaro: " + denaro+ "\ninoltre nella sala sono entrate " + donatori + " persone");
	}
	}
