import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Klasa generuj¹ca MAcierz wyników, na jej podstawie bêdziemy okreœlaæ decyzje podejmowana w celu 
 * osiêgniêcia okreslonego wyniku
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class ResultMatrix {
	
	private ArrayList <Round>  rounds;

	public ResultMatrix() {
		rounds= new ArrayList<Round>();
		Path file = Paths.get("Rounds.txt");
		BufferedReader reader;
		try {
			reader = Files.newBufferedReader(file);
			String line = null;
			while((line = reader.readLine())!=null)
			{
				double tmp[] = Arrays.stream( line.substring( 0,line.length()).split(",")).map(String::trim).mapToDouble(Double::parseDouble).toArray();
				//IOException e = null;
				if(tmp.length!=5)
					throw new IOException("zla liczba parametrow w pliku rounds.txt");
				Round tmpRound = new Round((int)tmp[0],(int)tmp[1],tmp[2], tmp[3], tmp[4]);
				rounds.add(tmpRound);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void GenerateRounds(int howMany)
	{
		Random generator = new Random();
		for (int i = 0; i < howMany; i++) 
		{
			/**
			 * TODO
			 * Generacja n losowych rund.
			 */
			
		}
	}
	
	
	/*
	 * Dla zadanej gotowki na etap wylicza wyniki 
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
					System.out.println(round.getWolumen()+"\t"+round.getJakosc()+"\t"+round.getWynik());
				}
			
			return 0;
		}
		
	}
	
	


}
