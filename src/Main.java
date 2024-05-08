import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;

public class Main {

	private JFrame frmPaluh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPaluh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaluh = new JFrame();
		frmPaluh.getContentPane().setBackground(new Color(30, 55, 67));
		frmPaluh.setBackground(new Color(30, 55, 67));
		frmPaluh.setMinimumSize(new Dimension(800, 700));
		frmPaluh.setMaximumSize(new Dimension(1000, 900));
		frmPaluh.setTitle("Paluh");
		frmPaluh.setBounds(100, 100, 450, 300);
		frmPaluh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
