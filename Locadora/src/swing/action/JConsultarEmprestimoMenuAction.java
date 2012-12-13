package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

	@SuppressWarnings("serial")
	public class JConsultarEmprestimoMenuAction  extends AbstractAction {
		public static final String CONSULTAR4 = "CONSULTAR4";

		private JPanel principal;
		private CardLayout cards;
		
		public JConsultarEmprestimoMenuAction(JPanel principal, CardLayout cards) {
			super("Consultar Emprestimos");
			this.principal = principal;
			this.cards = cards;		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cards.show(principal, CONSULTAR4);
		}
	}
