package data;

public class CLocalitate 
{

	String nume;
	CCoordonate coordonate;
	
	public void set_name(String name)
	{
		this.nume = name;
	}
	
	public String get_name()
	{
		return this.nume;
	}
	
	public void set_coord(CCoordonate coord)
	{
		this.coordonate = coord;
	}
	public CCoordonate get_coord()
	{
		return this.coordonate;
	}
}

class CCoordonate 
{
	
	private double latN;
	private double latS;
	private double longiE;
	private double longiV;
	
	public double getLatN()
	{
		return latN;
	}
	public double getLatS()
	{
		return latS;
	}
	public double getLongiE()
	{
		return longiE;
	}
	public double getLongiV()
	{
		return longiV;
	}
	public void setLatN(double newLatN) 
	{
	    this.latN = newLatN;
	}
	public void setLatS(double newLatS) 
	{
	    this.latS = newLatS;
	}
	public void setLongiE(double newLongiE) 
	{
	    this.longiE = newLongiE;
	}
	public void setLongiV(double newLongiV) 
	{
	    this.longiV = newLongiV;
	}
	public CCoordonate() 
	{
		latN=0;
		latS=0;
		longiE=0;
		longiV=0;
	}
}