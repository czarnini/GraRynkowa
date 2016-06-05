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
		setModel(new Model(this, 1000));
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

	public Round solve(String text) {
		Model.GOTOWKA_NA_ETAP = Integer.parseInt(text);
		model.CountResults();
		return model.findBestResult();
		
	}

	

	public void setParam(String text, String text2, String text3, String text4) {
		Model.AMORTYZACJA = Integer.parseInt(text2);
		Model.KOSZTY_STALE = Integer.parseInt(text);
		Model.OPROCENTOWANIE = Double.parseDouble(text3);
		Model.STOPA_PODATKU = Double.parseDouble(text4);
	}
	
	
	
}
