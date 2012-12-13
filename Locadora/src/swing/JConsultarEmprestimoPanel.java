package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



import swing.action.JCadastrarPanelCloseAction;
import locadora.ClienteDAO;
import locadora.Emprestimo;


@SuppressWarnings("serial")
public class JConsultarEmprestimoPanel extends JPanel{
	private JTextField busca;
	private JTextArea dados;
	
	public JConsultarEmprestimoPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60); 
		dados.setEditable(false);
		add(dados);
		add(new JLabel("Nome"));
		JTextField busca = new JTextField(8);
		add(busca);
	
		add(new JButton(new JCadastrarPanelCloseAction(principal, cards)));
	}

	public JConsultarEmprestimoPanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JCadastrarPanel::setVisible %b\n", aFlag);
		ClienteDAO emprestimo = new ClienteDAO();
		
		List<Emprestimo> cl = emprestimo.consultarEmprestimo();

	
			String s = "Cliente \t Filme\n\n";
		
			for (Emprestimo consultar : cl) {
			
				s += String.format("%s \t %s \n",	consultar.getCliente(),consultar.getFita());
			}
			
			dados.setText(s);
			
	}
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("VideoLocadora Gabrinus - Teste do Painel Consultar emprestimo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarEmprestimoPanel();
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
