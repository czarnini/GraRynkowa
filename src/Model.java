/**
 * 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class Model {
	private ResultMatrix resultMatrix;
	private int howManySamples;
	Controler controler;
	
	/**
	 * TODO To musi byc definiowane przez Usera!   \/
	 */
	public static double 	KOSZTY_STALE=5000,
							AMORTYZACJA=10000,
							OPROCENTOWANIE=0.06,
							STOPA_PODATKU=0.19, 
							GOTOWKA_NA_ETAP=300000;
	/********************************************* /\ */
	
	Model(Controler controler)
	{
		resultMatrix = new ResultMatrix(howManySamples);
		howManySamples = 0;
		this.controler = controler;
	}
	
	public void CountResults()
	{
		resultMatrix.CountResults();
	}
	
	public void setHowManySamples(int howMany)
	{
		howManySamples=howMany;
	}
	

	
}
