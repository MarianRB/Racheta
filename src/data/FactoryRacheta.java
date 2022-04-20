package data;

public class FactoryRacheta {

	public CRacheta get_racheta(float inaltime)
	{
		if(inaltime < 4000)
		{
			return new SpaceX();
		}
		else
		{
			return new Nasa();
		}
		
	}
}
