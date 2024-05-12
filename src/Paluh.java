import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import visão.DialogSobre;
import visão.PdfVisao;

import javax.swing.event.MenuEvent;  





public class Paluh {

	private JFrame frmPaluh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paluh window = new Paluh();
					window.frmPaluh.setLocationRelativeTo(null);
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
	public Paluh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
	
		frmPaluh = new JFrame();
		frmPaluh.setVisible(true);
		frmPaluh.getContentPane().setBackground(new Color(30, 55, 67));
		frmPaluh.setBackground(new Color(30, 55, 67));
		frmPaluh.setSize(new Dimension(1000,900));
		frmPaluh.setMinimumSize(new Dimension(800, 700));
		frmPaluh.setMaximumSize(new Dimension(1000, 900));
		frmPaluh.setTitle("Paluh - Privacidade Aluh");
		//frmPaluh.setBounds(100, 100, 450, 300);
		frmPaluh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar barraMenu = new JMenuBar();
		frmPaluh.setJMenuBar(barraMenu);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		barraMenu.add(menuArquivo);
		
		JMenuItem menuItemArquivo = new JMenuItem("Abrir...");
		menuItemArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Abrir.");


				JFileChooser arquivoAberto = new JFileChooser();
				
				FileNameExtensionFilter pdfFiltro = new FileNameExtensionFilter("PDF Documents", "pdf");
				arquivoAberto.setFileFilter(pdfFiltro);
			
				arquivoAberto.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = arquivoAberto.showSaveDialog(null);
				
				if(i==1) {
					System.out.println(" Nãda");
				}else {
					File arquivoPDF = arquivoAberto.getSelectedFile();
					System.out.println(arquivoPDF.getPath());
					
					
					PdfVisao frame = new PdfVisao();
					frame.setVisible(true);
				}
				
			}
		});
		menuItemArquivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		menuArquivo.add(menuItemArquivo);
		
		JMenuItem menuItemSair = new JMenuItem("Sair");
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		menuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		menuArquivo.add(menuItemSair);
		
		JMenu menuSobre = new JMenu("Sobre");
		menuSobre.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
				
			}
			
			public void menuDeselected(MenuEvent e) {
			
			}
			public void menuSelected(MenuEvent e) {
				System.out.println("dddd");
				try {
					DialogSobre dialog = new DialogSobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		menuSobre.setMnemonic('S');
		
		
		
		barraMenu.add(menuSobre);
	}

}
