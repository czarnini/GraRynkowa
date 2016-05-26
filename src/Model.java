/**
 * 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class Model {
	private ResultMatrix resultMatrix;
	/**
	 * TODO To musi byc definiowane przez Usera!
	 */
	
	public static double 	KOSZTY_STALE=5000,
							AMORTYZACJA=10000,
							OPROCENTOWANIE=0.06,
							STOPA_PODATKU=0.19, 
							GOTOWKA_NA_ETAP=-1;
	Model()
	{
		resultMatrix = new ResultMatrix();
	}
	
	public void CountResults()
	{
		resultMatrix.CountResults();
	}
	
}
