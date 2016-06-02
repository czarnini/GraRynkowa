import java.util.Iterator;

/**
 * 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class Model {
	private ResultMatrix resultMatrix;
	Controler controler;
	
	/**
	 * TODO To musi byc definiowane przez Usera!   \/
	 */
	public static double 	KOSZTY_STALE=5000,
							AMORTYZACJA=10000,
							OPROCENTOWANIE=0.06,
							STOPA_PODATKU=0.19, 
							GOTOWKA_NA_ETAP=2000000;
	/********************************************* /\ 
	 * @param howManySamples */
	
	Model(Controler controler, int howManySamples)
	{
		resultMatrix = new ResultMatrix(howManySamples);
		this.controler = controler;
	}
	
	public void CountResults()
	{
		resultMatrix.CountResults();
	}
	
	
	public void estimateResult(double wantedResult)
	{
		
	}

	public double findClosestResult(double result) {
		double estRes= resultMatrix.findClosestResult(result);
		return estRes;
	}
	

	
}
