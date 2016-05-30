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
		setModel(new Model(this, 10000));
		setView(new View(this));
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
	
}
