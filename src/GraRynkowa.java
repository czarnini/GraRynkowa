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
		
		
		/*Model.GOTOWKA_NA_ETAP=300000;
		model.CountResults();
		Round best = model.findBestResult();
			System.out.println(best.getWolumen()+ "\t"+best.getJakosc()+ "\t"+best.getKjz()
			+ "\t"+best.getCena()+ "\t"+best.getReklama()+ "\t"+best.getWynik() +"\t Niesprzedany:"+best.getWolumenNiesprzedany()+ "\t"+best.getPrzychodyZodsprzedazy()); 
	*/
		
	  }
	
	
}



	