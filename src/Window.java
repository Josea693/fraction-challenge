import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import net.miginfocom.swing.MigLayout;

public class Window extends JFrame {

	private JPanel mainPanel;
	private JTextField txtNum1;
	private JTextField txtDenom1;
	private JTextField txtNum2;
	private JTextField txtDenom2;
	private JLabel lblDenomAns;
    private JLabel lblNumAns;
	private JLabel lblLargerFraction;
	
	// ----------------------------------------------- constructor method
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		mainPanel = new JPanel();
		
		// predefined MigLayout grid
		mainPanel.setLayout(new MigLayout("",
            "[][center][][center][]",
            "[]20[]5[]5[]"));

		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(mainPanel);
		
		JLabel lblHeader = new JLabel("Fraction Adder :)");
		lblHeader.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNum1 = new JTextField();
		txtNum1.setPreferredSize(new Dimension(60, 20));
		txtNum1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		txtDenom1 = new JTextField();
		txtDenom1.setPreferredSize(new Dimension(60, 20));
        txtDenom1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		txtNum2 = new JTextField();
		txtNum2.setPreferredSize(new Dimension(60, 20));
		txtNum2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		txtDenom2 = new JTextField();
		txtDenom2.setPreferredSize(new Dimension(60, 20));
		txtDenom2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		JLabel lblPlusOperator = new JLabel("+");
		lblPlusOperator.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblEqualsOperator = new JLabel("=");
		lblEqualsOperator.setFont(new Font("Arial", Font.PLAIN, 20));
		
		lblNumAns = new JLabel("?");
		lblNumAns.setFont(new Font("Arial", Font.PLAIN, 20));

		lblDenomAns = new JLabel("?");
		lblDenomAns.setFont(new Font("Arial", Font.PLAIN, 20));

		// row 1 - app title
		mainPanel.add(lblHeader, "span, wrap");
		// row 2 - numerator textfields / numerator answer label
		mainPanel.add(txtNum1);
		mainPanel.add(lblPlusOperator, "span 1 2, aligny center"); // span 1 2 means it will span 1 column and 2 rows
		mainPanel.add(txtNum2);
		mainPanel.add(lblEqualsOperator, "span 1 2, aligny center");
		mainPanel.add(lblNumAns, "wrap");
		// row 3 - denominator textfields / denominator answer label
		mainPanel.add(txtDenom1);
		mainPanel.add(txtDenom2);
		mainPanel.add(lblDenomAns);
		// row 4 - add greater / less than indicator
		lblLargerFraction = new JLabel("?");
		lblLargerFraction.setForeground(Color.BLUE);
		lblLargerFraction.setFont(new Font("Arial", Font.PLAIN, 20));
		mainPanel.add(lblLargerFraction, "cell 1 3");

        // Remove tab focus altogether
        mainPanel.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
        mainPanel.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.emptySet());
    }

    // ------------------------------------------------ event handlers
    private void onUserInput(KeyEvent e) {
		// get input from textfields and convert to integer / catch if incorrect input
		try {
            int numf1 = Integer.parseInt(txtNum1.getText());
            int numf2 = Integer.parseInt(txtNum2.getText());
            int denomf1 = Integer.parseInt(txtDenom1.getText());
            int denomf2 = Integer.parseInt(txtDenom2.getText());

			Fraction f1,f2,f3;
			f1 = new Fraction(numf1, denomf1);
			f2 = new Fraction(numf2, denomf2);

			f3 = f1.add(f2);

			lblNumAns.setText(Integer.toString(f3.getNumerator()));
			lblDenomAns.setText(Integer.toString(f3.getDenominator()));
    
            
			
		} catch(NumberFormatException nfe) {
			lblNumAns.setText("?");
			lblDenomAns.setText("?");
			lblLargerFraction.setText("?");
		}        
    }    
	
	// ------------------------------------------------ main method
	public static void main(String[] args) {
		Window window = new Window();
		window.setVisible(true);


		// // testing the Fraction class
		// Fraction f1, f2, f3;
		// f1 = new Fraction(1, 2);
		// f2 = new Fraction(1, 4);
		// f2 = new Fraction(6);
		
		// f3 = f1.add(f2);
		// f3 = f1.add(4);

		// System.out.println(f1.toString() + " + " + f2.toString() + " = " + f3.toString());
		// System.out.println(f1.toDecimal());


	}
}
