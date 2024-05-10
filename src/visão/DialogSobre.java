package visão;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Font;

public class DialogSobre extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogSobre dialog = new DialogSobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSobre() {
		setTitle("Paluh - Sobre");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(30, 55, 67));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextArea txtrPrivacidadeAluhTem = new JTextArea();
		txtrPrivacidadeAluhTem.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtrPrivacidadeAluhTem.setAlignmentY(Component.TOP_ALIGNMENT);
		txtrPrivacidadeAluhTem.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtrPrivacidadeAluhTem.setEditable(false);
		txtrPrivacidadeAluhTem.setLineWrap(true);
		txtrPrivacidadeAluhTem.setWrapStyleWord(true);
		txtrPrivacidadeAluhTem.setText("Privacidade Aluh \n Privacidade Aluh tem como objetivo o desenvolvimento de aplicativo para anonimização (tarjamento) de dados pessoais em documentos textuais no formato PDF.");
		txtrPrivacidadeAluhTem.setForeground(new Color(255, 255, 255));
		txtrPrivacidadeAluhTem.setBackground(new Color(30, 55, 67));
		contentPanel.add(txtrPrivacidadeAluhTem);
	}

}
