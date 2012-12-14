package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import swing.action.JCadastrarPanelCloseAction;
import entity.ProgramaDAO;
import entity.Programa;


@SuppressWarnings("serial")
public class JConsultarPanel extends JPanel{

	private JTextArea dados;
	public JConsultarPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60); 
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JCadastrarPanelCloseAction(principal, cards)));
	}

	public JConsultarPanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JCadastrarPanel::setVisible %b\n", aFlag);
		ProgramaDAO programa = new ProgramaDAO();
		
		List<Programa> cl = programa.consultarPrograma();

	
			String s = "Nome \t\t Genero \t\t Horario Inicial \t\t Horario Final \n\n";
		
			for (Programa consultar : cl) {
			
				s += String.format("%s \t\t %s \t\t %s \t\t %s \n",	consultar.getNome(),consultar.getGenero(),consultar.getHorarioInicio(),consultar.getHorarioFim());
			}
			
			dados.setText(s);
			
	}
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Grade de Programação - Teste do Painel Consultar programas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarPanel();
		frame.getContentPane().add(painel);

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

