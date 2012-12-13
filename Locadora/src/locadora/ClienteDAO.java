package locadora;
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

public class ClienteDAO {

	private static final String selectFindCliente = "select * from cliente where id = ?";
	private static final String selectCliente = "select * from cliente";
	private static final String insertCliente = "insert into cliente(nome, sobrenome,telefone,endereco) values (?, ?, ?, ?)";
	private static final String deleteCliente = "delete from cliente where id = ?";
	private static final String updateCliente = "update cliente  set nome = ?,sobrenome = ?, telefone = ?,endereco = ? where id = ?";
    private static final String selectEmprestimo = " select nome ,titulo from cliente,filme,fita,emprestimo where emprestimo.cliente = cliente.id and emprestimo.fita = fita.id and fita.filme = filme.id";
    private static final String selectEmprestimo2 = "select * from emprestimo";
    
	// Configura essas vari�veis de acordo com o seu banco

	public Cliente findCliente(int id) {

		Cliente c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindCliente);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id2 = rs.getInt("id");
				String nomee = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				int telefone = rs.getInt("telefone");
				String endereco = rs.getString("endereco");
				c = new Cliente(id2, nomee, sobrenome, telefone, endereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conex�es

		return c;

	}

	public void inserir(Cliente cl) {
		if (cl == null) {
			throw new IllegalArgumentException("O cliente n�o pode ser null!");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertCliente);
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getSobrenome());
			stmt.setInt(3, cl.getTelefone());
			stmt.setString(4, cl.getEndereco());
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir opera��o");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conex�es
	}

	public void deletar(Cliente d) {
		if (d == null) {
			throw new IllegalArgumentException("O cliente n�o pode ser null!");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(deleteCliente);

			stmt.setInt(1, d.getId());
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao deletar");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conex�es
	}

	public void editar(Cliente cl) {
		if (cl == null) {
			throw new IllegalArgumentException("O cliente n�o pode ser null!");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(updateCliente);
			
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getSobrenome());
			stmt.setInt(3, cl.getTelefone());
			stmt.setString(4, cl.getEndereco());
			stmt.setInt(5, cl.getId());
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir opera��o");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conex�es

	}

	public List<Cliente> consultarCliente() {
	
		List<Cliente> ops = new ArrayList<Cliente>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome  = rs.getString("nome");
				String sobrenome  = rs.getString("sobrenome");
				int telefone = rs.getInt("telefone");
				String endereco  = rs.getString("endereco");
				Cliente op = new Cliente(id, nome,sobrenome,telefone,endereco);
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
	
	
	public List<Emprestimo> consultarEmprestimo() {
		
		List<Emprestimo> ops = new ArrayList<Emprestimo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectEmprestimo);
			rs = stmt.executeQuery();
			while (rs.next()) {
			//	int id = rs.getInt("id");
				String cliente  = rs.getString("nome");
				String fita  = rs.getString("titulo");
				Emprestimo op = new Emprestimo(cliente,fita);
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
		ClienteDAO cliente = new ClienteDAO();		
//		Cliente c = cliente.findCliente(2);
		ClienteDAO emprestimo = new ClienteDAO();	
		
//		if (c == null) {
//			System.out.println("cliente n�o encontrado!");
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



