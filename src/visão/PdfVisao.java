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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import java.awt.Insets;

public class PdfVisao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PdfVisao() {
		setBounds(new Rectangle(0, 0, 1000, 800));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.getContentPane().setBackground(new Color(30, 55, 67));
		this.setBackground(new Color(30, 55, 67));
		this.setSize(new Dimension(1000,900));
		this.setMinimumSize(new Dimension(800, 700));
		this.setMaximumSize(new Dimension(1000, 900));
		this.setTitle("Paluh - Privacidade Aluh");

		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1000, 900));
		contentPane.setMaximumSize(new Dimension(1000, 900));
		contentPane.setMinimumSize(new Dimension(800, 700));
		contentPane.setBounds(new Rectangle(0, 0, 1000, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ButtonGroup grupoMeCriterioBusca = new ButtonGroup();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1006, 0};
		gbl_contentPane.rowHeights = new int[]{29, 850, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel painelSuperior = new JPanel();
		painelSuperior.setMinimumSize(new Dimension(10, 100));
		painelSuperior.setPreferredSize(new Dimension(1000, 900));
		painelSuperior.setAlignmentX(Component.LEFT_ALIGNMENT);
		painelSuperior.setBounds(new Rectangle(0, 0, 200, 800));
		painelSuperior.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		painelSuperior.setBackground(new Color(30, 55, 67));
		GridBagConstraints gbc_painelSuperior = new GridBagConstraints();
		gbc_painelSuperior.gridwidth = 2;
		gbc_painelSuperior.fill = GridBagConstraints.BOTH;
		gbc_painelSuperior.gridx = 0;
		gbc_painelSuperior.gridy = 0;
		contentPane.add(painelSuperior, gbc_painelSuperior);
		
		
		JRadioButton jrbCPF = new JRadioButton("CPF");
		painelSuperior.setLayout(new BoxLayout(painelSuperior, BoxLayout.X_AXIS));
		
		
		JLabel lblNewLabel = new JLabel("Selecione o critério de busca");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		painelSuperior.add(lblNewLabel);
		jrbCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		jrbCPF.setBackground(new Color(30, 55, 67));
		jrbCPF.setForeground(new Color(255, 255, 255));
		painelSuperior.add(jrbCPF);
		
		grupoMeCriterioBusca.add(jrbCPF);
		
		JRadioButton jrbTelefone = new JRadioButton("Telefone");
		jrbTelefone.setVisible(false);
		
		
		JRadioButton jrbNome = new JRadioButton("Nome");
		jrbNome.setVisible(false);
		jrbNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		jrbNome.setBackground(new Color(30, 55, 67));
		jrbNome.setForeground(new Color(255, 255, 255));
		painelSuperior.add(jrbNome);
		grupoMeCriterioBusca.add(jrbNome);
		jrbTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		jrbTelefone.setBackground(new Color(30, 55, 67));
		jrbTelefone.setForeground(new Color(255, 255, 255));
		painelSuperior.add(jrbTelefone);
		grupoMeCriterioBusca.add(jrbTelefone);
		
		JButton btBuscar = new JButton("Buscar");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Buscar");
			}
		});
		painelSuperior.add(btBuscar);
		
		
		JPanel painelInferior = new JPanel();
		painelInferior.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		painelInferior.setBackground(new Color(255, 255, 0));
		painelInferior.setPreferredSize(new Dimension(1000, 850));
		GridBagConstraints gbc_painelInferior = new GridBagConstraints();
		gbc_painelInferior.gridheight = 2;
		gbc_painelInferior.gridwidth = 2;
		gbc_painelInferior.fill = GridBagConstraints.BOTH;
		gbc_painelInferior.gridx = 0;
		gbc_painelInferior.gridy = 1;
		contentPane.add(painelInferior, gbc_painelInferior);
		GridBagLayout gbl_painelInferior = new GridBagLayout();
		gbl_painelInferior.columnWidths = new int[]{343, 343, 0, 0};
		gbl_painelInferior.rowHeights = new int[]{844, 0};
		gbl_painelInferior.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_painelInferior.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		painelInferior.setLayout(gbl_painelInferior);
		
		
		/*
		JEditorPane visualizarDocumento = new JEditorPane();
		visualizarDocumento.setMaximumSize(new Dimension(50, 2147483647));
		visualizarDocumento.setPreferredSize(new Dimension(50, 20));
		GridBagConstraints gbc_visualizarDocumento = new GridBagConstraints();
		gbc_visualizarDocumento.anchor = GridBagConstraints.WEST;
		gbc_visualizarDocumento.fill = GridBagConstraints.BOTH;
		gbc_visualizarDocumento.gridwidth = 2;
		gbc_visualizarDocumento.insets = new Insets(0, 0, 0, 5);
		gbc_visualizarDocumento.gridx = 0;
		gbc_visualizarDocumento.gridy = 0;
		painelInferior.add(visualizarDocumento, gbc_visualizarDocumento);
		
		JPanel painelDireitaOpcoes = new JPanel();
		FlowLayout fl_painelDireitaOpcoes = (FlowLayout) painelDireitaOpcoes.getLayout();
		fl_painelDireitaOpcoes.setHgap(1);
		GridBagConstraints gbc_painelDireitaOpcoes = new GridBagConstraints();
		gbc_painelDireitaOpcoes.anchor = GridBagConstraints.WEST;
		gbc_painelDireitaOpcoes.fill = GridBagConstraints.BOTH;
		gbc_painelDireitaOpcoes.gridx = 2;
		gbc_painelDireitaOpcoes.gridy = 0;
		painelInferior.add(painelDireitaOpcoes, gbc_painelDireitaOpcoes);*/
	}

}
