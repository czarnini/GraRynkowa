
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Klasa generuj¹ca Macierz wyników, na jej podstawie bêdziemy okreœlaæ decyzje podejmowana w celu 
 * osiêgniêcia okreslonego wyniku
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class ResultMatrix {
	
	private ArrayList <Round>  rounds;

	public ResultMatrix(int howMany) {
		rounds= new ArrayList<Round>();
		GenerateRounds(howMany);
		try
		{
		if(CountResults()==-1)
		{
			throw new Exception("Wynik w niepoprawnej formie!");
		}
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * 
	 * @param howMany ile wynikow chcemy wygenerowac
	 */
	public void GenerateRounds(int howMany)
	{
		Random generator = new Random();
		Estimator estimator = new Estimator();
		for(int k=0; k<howMany/160; ++k)
		{
			/**
			 * Po jakosci
			 */
			for (int i = 1; i < 9; i++) 
			{
				/**
				 * Po wolumenie
				 */
				for(int j=0; j<4; ++j)
				{
					
						int		tmpJakosc = generator.nextInt(9)+(10*i)+1,
								tmpWolumen = generator.nextInt(50000)+(50000*j);
						
						double	tmpKJZ = Math.floor((estimator.value(tmpWolumen/1000, tmpJakosc))*100)/100;
						for(int l=0; l<10; l++)
						{
							
								double	tmpCena = Math.floor(((generator.nextDouble()*10.0)+tmpKJZ)*100)/100,
										tmpReklama = 5000*(tmpWolumen/100000);  //Na Kazde 100 000 wolumenu 5 000 na reklame?
								Round tmp = new Round(tmpWolumen, tmpJakosc, tmpKJZ, tmpCena, tmpReklama);
								rounds.add(tmp);
							
						}
					
				}
				
				
			}
		}
	}
	
	
	/**
	 * 
	 * @return -1 w wypadku b³êdu, 0 dla poprawnego wyniku.
	 */
	public int CountResults()
	{
		if(Model.GOTOWKA_NA_ETAP == -1)
		{
			return -1;
		}
		else
		{
			
				for (Iterator<Round> iterator = rounds.iterator(); iterator.hasNext();)
				{
					Round round = iterator.next();
					round.countWynik(Model.GOTOWKA_NA_ETAP);
					
				}
			return 0;
		}
		
	}
		
	public void print()
	{
		for (Iterator<Round> iterator = rounds.iterator(); iterator.hasNext();) {
			Round round = (Round) iterator.next();
			System.out.println(round.getWolumen()+"\t"+round.getJakosc()+"\t"+  round.getKjz() +"\t"+round.getCena()+"\t"+ round.getReklama()+"\t"+   round.getWynik() );
		}
	}

	
	
	public Round findBestResult() {
		
		Round bigest=new Round(0, 0, 0, 0, 0);
		
		for (Iterator <Round> iterator = rounds.iterator(); iterator.hasNext();)
		{
			Round round =  iterator.next();
			
			 if(round.getWynik()>bigest.getWynik())
			 {
				 bigest = round;
			 }
			
		}
		return bigest;
	}
	
	

}
