/**
 * 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class Controler {
	private Model model;
	private View view;
	
	Controler()
	{
		model = new Model(this);
		view = new View(this);
	}
	
}
