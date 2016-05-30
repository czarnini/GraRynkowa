import java.util.Scanner;

/**
 * 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class GraRynkowa
{
	
	public static void main(String args[])
	  {
		Controler controler = new Controler();
		View view = controler.getView();
		Model model = controler.getModel();
		Estimator est = new Estimator();
		Scanner scan = new Scanner(System.in);
		
		String jeszcze = "t";
		while(true)
		{

			System.out.println("Gotowka na ten etap: ");
			if(scan.hasNext())
				Model.GOTOWKA_NA_ETAP= scan.nextDouble();

			est.test();
			model.CountResults();
			
			System.out.println("Jaki byl wynik?");
			double result = scan.nextDouble(), estWynik=model.findClosestResult(result);
			
			System.out.println("Program oszacowal taki wynik: "+ estWynik);
			
			
		}
		
	  }
	
	
}



	