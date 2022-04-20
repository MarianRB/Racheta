package data;

import java.util.Scanner;

public class ProgramLansare {
	
	public void menu()
	{
		int alegere = -1;
		
		while(alegere != 0)
		{
			System.out.println("1.Lansare noua");
			System.out.println("2.Afisarre lista localitati");
			System.out.println("3.Adaugare localitate in lista");
			System.out.println("0.Iesire");
			
			Scanner sc = new Scanner(System.in);
			
			alegere = sc.nextInt();
			
			switch(alegere)
			{
			case 1:
				this.lansare();
				break;
			case 2:
				this.afisare_localitati();
				break;
			case 3:
				this.localitate_noua();
				break;
			case 0:
				System.out.println("Iesire...");
				break;
				default:
					System.out.println("Alegere invalida");
					break;
			}
		}
		
	}
	
	private void lansare()
	{
		Harta harta = Harta.get_instance();
		CLocalitate[] localitati = ReadingXML.read();
		harta.set_loc(localitati[0]);
		harta.set_loc(localitati[1]);
		CalculatorRuta calc = new CalculatorRuta();
		calc.incarcare_harta(harta);
		calc.pregatire_date_lansare("l1", "l2");
		
		
	}
	
	private void localitate_noua()
	{
		CLocalitate localitate = new CLocalitate();
		System.out.println("Introduceti numele");
		String nume;
		Scanner sc = new Scanner(System.in);
		nume = sc.nextLine();
		
		CCoordonate co = new CCoordonate();
		
		System.out.println("Introduceti lat N");
		
		co.setLatN(sc.nextDouble());
		
		System.out.println("Introduceti lat S");
		
		co.setLatS(sc.nextDouble());
		
		System.out.println("Introduceti longi E");
		
		co.setLongiE(sc.nextDouble());
		
		System.out.println("Introduceti longi V");
		
		co.setLongiV(sc.nextDouble());
		
		localitate.set_name(nume);
		localitate.set_coord(co);
		
		WritingXML.write(localitate);
	}
	
	private void afisare_localitati()
	{
		CLocalitate[] localitati = ReadingXML.read();
		for(int i =0;i<localitati.length;i++)
		{
			System.out.println(localitati[i].get_name());
		}
	}
}
