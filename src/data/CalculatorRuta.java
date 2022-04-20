package data;

import java.util.*;

public class CalculatorRuta {

	private Harta harta;
	
	public void incarcare_harta(Harta harta)
	{
		this.harta = harta;
	}
	
	public boolean pregatire_date_lansare(String l1, String l2)
	{
		CLocalitate loc1 = harta.get_loc_by_name(l1);
		CLocalitate loc2 = harta.get_loc_by_name(l2);
		
		if(loc1 == null || loc2 == null)
		{
			return false;
		}
		
		double lat1 = (loc1.get_coord().getLatN()>loc1.get_coord().getLatS())?loc1.get_coord().getLatN():loc1.get_coord().getLatS();
		double long1 = (loc1.get_coord().getLongiE()>loc1.get_coord().getLongiV())?loc1.get_coord().getLongiE():loc1.get_coord().getLongiV();
		
		double lat2 = (loc2.get_coord().getLatN()>loc2.get_coord().getLatS())?loc2.get_coord().getLatN():loc2.get_coord().getLatS();
		double long2 = (loc2.get_coord().getLongiE()>loc2.get_coord().getLongiV())?loc2.get_coord().getLongiE():loc2.get_coord().getLongiV();
		
		
		double distance = 6378.137 * Math.acos(Math.sin(long1)*Math.sin(long2)+Math.cos(long1)*Math.cos(long2)*Math.cos(lat2-lat1));
		
		
		double speed = Math.sqrt(distance*9.8);
		
		return true;
	}
	
}
