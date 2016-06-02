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
			est.test();
		}
		
	  }
	
	
}



	