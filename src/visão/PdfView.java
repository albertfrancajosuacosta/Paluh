package visão;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.BoxLayout;

public class PdfView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PdfView() {
		setBounds(new Rectangle(0, 0, 1000, 800));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.getContentPane().setBackground(new Color(30, 55, 67));
		this.setBackground(new Color(30, 55, 67));
		this.setSize(new Dimension(1000,900));
		this.setMinimumSize(new Dimension(800, 700));
		this.setMaximumSize(new Dimension(1000, 900));
		this.setTitle("Paluh - Privacidade Aluh");

		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1000, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ButtonGroup grupoMeCriterioBusca = new ButtonGroup();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel painelSuperior = new JPanel();
		painelSuperior.setMinimumSize(new Dimension(1000, 50));
		painelSuperior.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		painelSuperior.setAlignmentX(Component.LEFT_ALIGNMENT);
		painelSuperior.setPreferredSize(new Dimension(1000, 50));
		painelSuperior.setSize(new Dimension(1000, 200));
		painelSuperior.setBounds(new Rectangle(0, 0, 200, 800));
		painelSuperior.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		painelSuperior.setBackground(new Color(30, 55, 67));
		contentPane.add(painelSuperior);
		painelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Selecione o critério de busca");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		painelSuperior.add(lblNewLabel);
		
		JRadioButton jrbCPF = new JRadioButton("CPF");
		jrbCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		jrbCPF.setBackground(new Color(30, 55, 67));
		jrbCPF.setForeground(new Color(255, 255, 255));
		painelSuperior.add(jrbCPF);
		
		JRadioButton jrbNome = new JRadioButton("Nome");
		jrbNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		jrbNome.setBackground(new Color(30, 55, 67));
		jrbNome.setForeground(new Color(255, 255, 255));
		painelSuperior.add(jrbNome);
		
		JRadioButton jrbTelefone = new JRadioButton("Telefone");
		jrbTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		jrbTelefone.setBackground(new Color(30, 55, 67));
		jrbTelefone.setForeground(new Color(255, 255, 255));
		painelSuperior.add(jrbTelefone);
		
		grupoMeCriterioBusca.add(jrbCPF);
		grupoMeCriterioBusca.add(jrbNome);
		grupoMeCriterioBusca.add(jrbTelefone);
		
		JPanel painelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) painelInferior.getLayout();
		flowLayout.setHgap(0);
		painelInferior.setBackground(new Color(255, 255, 0));
		painelInferior.setPreferredSize(new Dimension(1000, 850));
		contentPane.add(painelInferior);
	}

}
