package swing;



	import java.awt.CardLayout;
	import java.awt.Dimension;

import javax.swing.*;


import swing.action.JAboutMenuAction;
import swing.action.JCadastrarMenuAction;
import swing.action.JConsultarMenuAction;
import swing.action.JSairMenuAction;
import swing.JCadastrarPanel;


	public class Principal {
		public static final String PRINCIPAL = "PRINCIPAL";

		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Grade de Programação");
			CardLayout cards = new CardLayout();
			JPanel principal = new JPanel(cards);
			
			JPanel cadastrar = new JCadastrarPanel(principal, cards);
			
			
			JPanel consultar = new JConsultarPanel(principal, cards);
			
			JPanel vazio = new JPanel();
			JLabel label = new JLabel("Grade de Programação");
			vazio.add(label);
			
			principal.add(vazio, PRINCIPAL);
			principal.add(cadastrar, JCadastrarMenuAction.CADASTRAR1);
			principal.add(consultar, JConsultarMenuAction.CONSULTAR1);
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(principal);

			JMenuBar menubar = new JMenuBar();	
		    
			JMenu file = new JMenu("Arquivo");
			menubar.add(file);
			
			JMenu programa = new JMenu("Cadastrar Programa");
			menubar.add(programa);
			
			
			JMenu help = new JMenu("Sobre");
			menubar.add(help);
			
			
			
			
//	sair
			Action exitAction = new JSairMenuAction();
			file.add(exitAction);			

			Action aboutAction = new JAboutMenuAction(frame);
			help.add(aboutAction);
			
			
				
			Action cadastrarAction = new JCadastrarMenuAction(principal,cards);
			programa.add(cadastrarAction);
				
			Action consultarAction = new JConsultarMenuAction(principal,cards);
		    programa.add(consultarAction);
			
			
			frame.setJMenuBar(menubar);
			
			frame.setMinimumSize(new Dimension(400,200));

			frame.pack();
			frame.setVisible(true);	
		}

		public static void main(String[] args) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});
		}
	}


	
	
	
