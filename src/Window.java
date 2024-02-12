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
            "[][][][][]",
            "[]20[]5[]5[]"));

		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.add(mainPanel);
		
		JLabel lblHeader = new JLabel("Fraction Adder :)");
		lblHeader.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNum1 = new JTextField();
		txtNum1.setColumns(5);
		txtNum1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		txtDenom1 = new JTextField();
		txtDenom1.setColumns(5);
        txtDenom1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		txtNum2 = new JTextField();
		txtNum2.setColumns(5);
		txtNum2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				onUserInput(e);
			}
		});
		
		txtDenom2 = new JTextField();
		txtDenom2.setColumns(5);
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
		mainPanel.add(txtNum1, "tag n1");
		mainPanel.add(lblPlusOperator, "span 1 2");
		mainPanel.add(txtNum2, "tag n2");
		mainPanel.add(lblEqualsOperator, "span 1 2");
		mainPanel.add(lblNumAns, "wrap");
		// row 3 - denominator textfields / denominator answer label
		mainPanel.add(txtDenom1, "tag d1");
		mainPanel.add(txtDenom2, "tag d2");
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
        
    }    
	
	// ------------------------------------------------ main method
	public static void main(String[] args) {
		Window window = new Window();
		window.setVisible(true);
	}
}
