package entity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProgramaDAO {

	
	private static final String selectFindPrograma = "select * from programa where id = ?";
	private static final String selectPrograma = "select * from programa";
	private static final String insertPrograma = "insert into programa(nome, genero,horarioFim,horarioInicio) values (?, ?, ?, ?)";
	private static final String deletePrograma = "delete from programa where id = ?";
    
	// Configura essas variáveis de acordo com o seu banco

	public Programa findCliente(int id) {

		Programa c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/programa", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindPrograma);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id2 = rs.getInt("id");
				String nome = rs.getString("nome");
				String genero = rs.getString("genero");
				String horarioFim = rs.getString("horarioFim");
				String horarioInicio = rs.getString("horarioInicio");
			 c = new Programa(id,nome, genero, horarioFim, horarioInicio);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conexões

		return c;

	}

	public void inserir(Programa cl) {
		if (cl == null) {
			throw new IllegalArgumentException("O programa não pode ser null!");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/programa", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertPrograma);
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getGenero());
			stmt.setString(3, cl.getHorarioFim());
			stmt.setString(4, cl.getHorarioInicio());
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir operação");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conexões
	}

	public List<Programa> consultarPrograma() {
	
		List<Programa> ops = new ArrayList<Programa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/programa", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectPrograma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome  = rs.getString("nome");
				String genero  = rs.getString("genero");
				String horarioFim = rs.getString("horarioFim");
				String horarioInicio  = rs.getString("horarioInicio");
				Programa op = new Programa(id, nome,genero,horarioFim,horarioInicio);
				ops.add(op);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return ops;
	}
	
		
	public static void main(String[] args) {
		
		//select de clientes por id
		ProgramaDAO programa = new ProgramaDAO();		
//		Cliente c = cliente.findCliente(2);
			
		
		System.out.println(programa.consultarPrograma());
		
//		if (c == null) {
//			System.out.println("cliente não encontrado!");
//		} else {
//			System.out.println(c);}

			
	// realiza o select de todos os clientes
	//	ClienteDAO emprestimo = new ClienteDAO();	
	//		System.out.println(emprestimo.consultarEmprestimo());
			
//			Cliente asd = new Cliente(1, "Geraldo", "Padilha", 43602233,"rua andarai");
//			cliente.inserir(asd);
//			System.out.println(asd);	
	
	
	}
	}



