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
import javax.swing.text.BadLocationException;

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
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import java.awt.Panel;
import javax.swing.Box;

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
		gbl_contentPane.rowHeights = new int[] {29, 850, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel painelSuperior = new JPanel();
		painelSuperior.setMinimumSize(new Dimension(10, 100));
		painelSuperior.setPreferredSize(new Dimension(1000, 900));
		painelSuperior.setAlignmentX(Component.LEFT_ALIGNMENT);
		painelSuperior.setBounds(new Rectangle(0, 0, 200, 800));
		painelSuperior.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelSuperior.setBackground(new Color(30, 55, 67));
		GridBagConstraints gbc_painelSuperior = new GridBagConstraints();
		gbc_painelSuperior.insets = new Insets(0, 0, 5, 0);
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
		
		painelSuperior.add(btBuscar);
		
		JPanel painelInferior = new JPanel();
		painelInferior.setPreferredSize(new Dimension(1000, 800));
		painelInferior.setBackground(new Color(30, 55, 67));
		GridBagConstraints gbc_painelInferior = new GridBagConstraints();
		gbc_painelInferior.insets = new Insets(0, 0, 5, 0);
		gbc_painelInferior.gridwidth = 2;
		gbc_painelInferior.fill = GridBagConstraints.BOTH;
		gbc_painelInferior.gridx = 0;
		gbc_painelInferior.gridy = 1;
		painelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		

		
		JEditorPane documentoVisao = new JEditorPane();
		documentoVisao.setText("ee");
		documentoVisao.setForeground(new Color(0, 0, 0));
		documentoVisao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JPanel painelOpcoes = new JPanel();
	
		JSplitPane painelInferiorDividido = new JSplitPane(SwingConstants.VERTICAL,true,documentoVisao,painelOpcoes);
		painelInferiorDividido.setAlignmentY(Component.CENTER_ALIGNMENT);
		painelInferiorDividido.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		
		documentoVisao.setPreferredSize(new Dimension((int) (painelInferior.getPreferredSize().getWidth()-100), 
										(int)painelInferior.getPreferredSize().getHeight() ));
		
		documentoVisao.setMaximumSize(new Dimension( (int)(painelInferior.getMaximumSize().getWidth()), 
													(int) painelInferior.getMaximumSize().getHeight()  ));
		
		
		documentoVisao.setMinimumSize(new Dimension( (int) (painelInferior.getMinimumSize().getWidth()-100), 
														(int) painelInferior.getMinimumSize().getHeight()   ));
		
		
		documentoVisao.setSize(new Dimension( (int) (painelInferior.getSize().getWidth()), 
				
												(int) painelInferior.getSize().getHeight() ));
		
		painelOpcoes.setPreferredSize(new Dimension((int) (painelInferior.getPreferredSize().getWidth()), 
													(int)painelInferior.getPreferredSize().getHeight() ));
		
		
		painelOpcoes.setMaximumSize(new Dimension( (int) (painelInferior.getMaximumSize().getWidth()), 
				
													(int) painelInferior.getMaximumSize().getHeight()  ));
		
		
		painelOpcoes.setMinimumSize(new Dimension( (int) (painelInferior.getMinimumSize().getWidth()), 
				
																(int) painelInferior.getMinimumSize().getHeight()   ));
		
		
		painelOpcoes.setSize(new Dimension( (int) (painelInferior.getSize().getWidth()), 
				
											(int) painelInferior.getSize().getHeight() ));
		
		painelInferior.add(painelInferiorDividido);
		
		
		documentoVisao.setBackground(new Color(211, 211, 211));
		
		painelOpcoes.setBackground(new Color(30, 55, 67));
		
		
		
		painelOpcoes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		painelInferiorDividido.setDividerLocation(0.5);
		
		painelInferiorDividido.setOrientation(SwingConstants.VERTICAL); 
	

		painelInferiorDividido.setBackground(new Color(240, 240, 240));
		
		
		
	
		
		contentPane.add(painelInferior, gbc_painelInferior);
		
		

		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Buscar");
				
					
				documentoVisao.setText("al");
					
				documentoVisao.repaint();
			}
		});
		
		
	}

}
