import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class View {
	Controler controler;
	JFrame mainFrame;
	int screenWidth, screenHeight;
	private JTextField kosztyField;
	private JTextField amortyField;
	private JTextField oprocField;
	private JTextField podatekField;
	private JTextField gotowkaField;
	Round runda;
	View(Controler controler)
	{
		this.controler = controler;
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Wspomaganie decyzji w grze rynkowej");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //ustawienie okna na œrodku ekranu
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight();
		mainFrame.setBounds((screenWidth/2)-200, (screenHeight/2)-250, 400, 500);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);
		JLabel wolWyn = new JLabel("0");
		JLabel jakWyn = new JLabel("0");
		JLabel kjzWyn = new JLabel("0");
		JLabel cenaWyn = new JLabel("0");
		JLabel rekWyn = new JLabel("0");
		JLabel wynWyn = new JLabel("0");
		
		JButton btnOblicz = new JButton("Oblicz");
		btnOblicz.setEnabled(false);
		btnOblicz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controler.solve(gotowkaField.getText());
				runda = controler.getResult();
				wolWyn.setText(""+runda.getWolumen());
				jakWyn.setText(""+runda.getJakosc());
				kjzWyn.setText(""+runda.getKjz());
				cenaWyn.setText(""+runda.getCena());
				rekWyn.setText(""+runda.getReklama());
				wynWyn.setText(""+runda.getWynik());
				
			}
		});
		btnOblicz.setBounds(52, 244, 97, 25);
		mainFrame.getContentPane().add(btnOblicz);
		
		JLabel lblDane = new JLabel("Dane:");
		lblDane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDane.setBounds(52, 13, 76, 25);
		mainFrame.getContentPane().add(lblDane);
		
		JLabel lblKosztyStae = new JLabel("Koszty sta\u0142e:");
		lblKosztyStae.setBounds(52, 51, 109, 16);
		mainFrame.getContentPane().add(lblKosztyStae);
		
		JLabel lblAmortyzacja = new JLabel("Amortyzacja:");
		lblAmortyzacja.setBounds(52, 80, 97, 16);
		mainFrame.getContentPane().add(lblAmortyzacja);
		
		JLabel lblOprocentowanieKonta = new JLabel("Oprocentowanie konta:");
		lblOprocentowanieKonta.setBounds(52, 109, 150, 16);
		mainFrame.getContentPane().add(lblOprocentowanieKonta);
		
		JLabel lblStopaPodatku = new JLabel("Stopa podatku:");
		lblStopaPodatku.setBounds(52, 138, 109, 16);
		mainFrame.getContentPane().add(lblStopaPodatku);
		
		JLabel lblGotowkaNaEtap = new JLabel("Gotowka na etap:");
		lblGotowkaNaEtap.setBounds(52, 215, 109, 16);
		mainFrame.getContentPane().add(lblGotowkaNaEtap);
		
		kosztyField = new JTextField();
		kosztyField.setText("5000");
		kosztyField.setBounds(199, 48, 76, 22);
		mainFrame.getContentPane().add(kosztyField);
		kosztyField.setColumns(10);
		
		amortyField = new JTextField();
		amortyField.setText("10000");
		amortyField.setBounds(199, 77, 76, 22);
		mainFrame.getContentPane().add(amortyField);
		amortyField.setColumns(10);
		
		oprocField = new JTextField();
		oprocField.setText("0.06");
		oprocField.setBounds(199, 106, 76, 22);
		mainFrame.getContentPane().add(oprocField);
		oprocField.setColumns(10);
		
		podatekField = new JTextField();
		podatekField.setText("0.19");
		podatekField.setBounds(199, 135, 76, 22);
		mainFrame.getContentPane().add(podatekField);
		podatekField.setColumns(10);
		
		gotowkaField = new JTextField();
		gotowkaField.setText("2000000");
		gotowkaField.setBounds(199, 212, 76, 22);
		mainFrame.getContentPane().add(gotowkaField);
		gotowkaField.setColumns(10);
		
		JLabel lblWolumen = new JLabel("Wolumen:");
		lblWolumen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWolumen.setBounds(52, 282, 134, 16);
		mainFrame.getContentPane().add(lblWolumen);
		
		JLabel lblJako = new JLabel("Jako\u015B\u0107:");
		lblJako.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJako.setBounds(52, 311, 134, 16);
		mainFrame.getContentPane().add(lblJako);
		
		JLabel lblKosztJednZmienny = new JLabel("Koszt jedn. zmienny:");
		lblKosztJednZmienny.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKosztJednZmienny.setBounds(52, 340, 134, 16);
		mainFrame.getContentPane().add(lblKosztJednZmienny);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCena.setBounds(52, 369, 134, 16);
		mainFrame.getContentPane().add(lblCena);
		
		JLabel lblReklama = new JLabel("Reklama:");
		lblReklama.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReklama.setBounds(52, 398, 134, 16);
		mainFrame.getContentPane().add(lblReklama);
		
		JLabel lblPognozowanyWynik = new JLabel("Pognozowany wynik:");
		lblPognozowanyWynik.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPognozowanyWynik.setBounds(52, 427, 168, 25);
		mainFrame.getContentPane().add(lblPognozowanyWynik);
		
		wolWyn.setBounds(199, 282, 82, 16);
		mainFrame.getContentPane().add(wolWyn);
		
		
		jakWyn.setBounds(199, 311, 76, 16);
		mainFrame.getContentPane().add(jakWyn);
		
		
		kjzWyn.setBounds(199, 340, 76, 16);
		mainFrame.getContentPane().add(kjzWyn);
		
		
		cenaWyn.setBounds(199, 369, 76, 16);
		mainFrame.getContentPane().add(cenaWyn);
		
		
		rekWyn.setBounds(199, 398, 76, 16);
		mainFrame.getContentPane().add(rekWyn);
		
		
		wynWyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wynWyn.setBounds(232, 432, 134, 16);
		mainFrame.getContentPane().add(wynWyn);
		
		JButton btnDef = new JButton("Zdefiniuj dane pocz\u0105tkowe");
		btnDef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDef.setEnabled(false);
				kosztyField.setEnabled(false);
				amortyField.setEnabled(false);
				oprocField.setEnabled(false);
				podatekField.setEnabled(false);
				btnOblicz.setEnabled(true);
				controler.setParam(kosztyField.getText(), amortyField.getText(), oprocField.getText(), podatekField.getText());
			}
		});
		btnDef.setBounds(52, 167, 223, 25);
		mainFrame.getContentPane().add(btnDef);
	}
}
