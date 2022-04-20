package data;

import java.util.Vector;

import java.util.Iterator;

public class Harta
{
	private static Harta instanta_harta = null;
	
	private ContainerLocalitati localitati;
	int nlocalitati;
	
	private Harta()
	{
		this.localitati = new ContainerLocalitati();
		nlocalitati = 0;
	}
	
	static public Harta get_instance()
	{
		if(instanta_harta == null)
		{
			instanta_harta = new Harta();
		}
		
		return instanta_harta;
		
	}
	
	public void set_loc(CLocalitate loc)
	{
		this.localitati.adauga(loc);
		nlocalitati++;
	}
	
	public CLocalitate get_loc_by_name(String nume)
	{
		Iterator itr = (Iterator) this.localitati.getIterator();
		
		while(itr.hasNext())
		{
			CLocalitate loc = (CLocalitate) itr.next();
			if(loc.get_name().equals(nume))
			{
				return loc;
			}
		}
		
		return null;
	}

}
