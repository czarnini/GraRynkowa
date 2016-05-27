
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
			for (int i = 0; i < 10; i++) 
			{
				/**
				 * Po wolumenie
				 */
				for(int j=0; j<4; ++j)
				{
					
						int		tmpJakosc = generator.nextInt(9)+(10*i)+1,
								tmpWolumen = generator.nextInt(125000)+(125000*j);
						
						double	tmpKJZ = estimator.value(tmpWolumen, tmpJakosc);
						for(int l=0; l<10; l++)
						{
							
								double	tmpCena = (generator.nextDouble()*10.0)+tmpKJZ,
										tmpReklama = 5000*(tmpWolumen/10000);  //Na Kazde 10 000 wolumenu 5 000 na reklame?
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
					Round round = (Round) iterator.next();
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
	


}
