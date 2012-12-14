package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.ProgramaDAO;
import swing.Principal;
import entity.Programa;
	
	@SuppressWarnings("serial")
	public class JCadastrarPanelAction extends AbstractAction {
		private JPanel principal;
		private CardLayout cards;
		
		private JTextField nome;
		private JTextField genero;
		private JTextField horarioFim;
		private JTextField horarioInicio;

		public JCadastrarPanelAction(JPanel principal, CardLayout cards,JTextField nome,JTextField genero,JTextField horarioFim,JTextField horarioInicio) {
			super("Cadastrar");
			this.principal = principal;
			this.cards = cards;
			this.nome = nome;
			this.genero = genero;
			this.horarioFim = horarioFim;
			this.horarioInicio = horarioInicio;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			String nom,gen,hf,hi;
			
			
			ProgramaDAO programa = new ProgramaDAO();
//      
		
					nom = (nome.getText());
					gen = (genero.getText());
					hf = (horarioFim.getText());
					hi = (horarioInicio.getText());
										
					Programa cli = new Programa(0,nom ,gen,hi, hf);
					
					programa.inserir(cli);
					
			

					JOptionPane.showMessageDialog(null,
							"Programa Cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
			
		
			if (principal != null) {
				cards.show(principal, Principal.PRINCIPAL);
			}

		

				
}
}