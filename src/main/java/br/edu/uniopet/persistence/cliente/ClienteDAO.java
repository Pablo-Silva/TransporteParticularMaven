/**
 * 
 */
package br.edu.uniopet.persistence.cliente;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.edu.uniopet.ConnectionFactory;
import br.edu.uniopet.cliente.model.Cliente;
import br.edu.uniopet.persistence.pessoa.PessoaService;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
class ClienteDAO implements IClienteDAO {

	/**
	 * Instance variables
	 */

	private Connection connection;

	private PessoaService pessoaService;

	private int i;

	/**
	 * Default constructor
	 */

	public ClienteDAO() {
		// TODO Auto-generated constructor stub

		this.connection = ConnectionFactory.getInstance();

		this.pessoaService = new PessoaService();

		try {
			this.connection.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create(Cliente cliente) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		int count = 0;

		String query = null;

		Integer idCliente = null;

		// Data processing

		if (cliente != null) {

			this.pessoaService.create(cliente);

			try {

				query = "INSERT INTO CLIENTE_TABLE ";
				query += "(ID_CLIENTE,ID_PESSOA,BANDEIRA_CARTAO,NUMERO_CARTAO) ";
				query += "VALUES (CLIENTE_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL, ?, ?)";

				preparedStatement = this.connection.prepareStatement(query);

				this.setPreparedStatement(cliente, preparedStatement);

				count = preparedStatement.executeUpdate();

				cliente = new Cliente();

				if (count == 1) {

					this.connection.commit();

					idCliente = this.search();

					cliente.setIdCliente(idCliente);

					this.search(cliente);

				} else {
					this.connection.rollback();

					cliente = null;
				}

			} catch (SQLException e) {
				// TODO: handle exception

				e.printStackTrace();

				cliente = null;

			} finally {

				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}

	@Override
	public List<Cliente> recovery() {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Cliente> clientes = null;

		Cliente cliente = null;

		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		String msg = null;

		// Data processing

		connection = ConnectionFactory.getInstance();

		if (connection == null) {

			return null;
		}

		try {
			query = "SELECT * FROM CLIENTE_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			clientes = new ArrayList<>();

			while (resultSet.next()) {

				cliente = new Cliente();

				createCliente(cliente, resultSet);

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			clientes = null;

			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {
					statement.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (resultSet != null) {

				try {
					resultSet.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return clientes;
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		int count = 0;

		// Data processing

		try {

			query = "UPDATE CLIENTE_TABLE SET ";
			query += "BANDEIRA_CARTAO = ? ,NUMERO_CARTAO = ?) ";
			query += "WHERE ID_CLIENTE = ?";

			preparedStatement = setPreparedStatement(cliente, preparedStatement);

			preparedStatement.setInt(3, cliente.getIdCliente());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				this.connection.commit();

				this.search(cliente);
			} else {
				cliente = null;
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Boolean delete(Cliente cliente) {
		// TODO Auto-generated method stub

		// Variables declaration

		Boolean flag = null;

		PreparedStatement preparedStatement = null;

		String query = null;

		int i = 0;

		int count = 0;

		// Data processing

		i = 1;

		try {
			query = "DELETE FROM CLIENTE_TABLE WHERE ID_TABLE = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, cliente.getIdCliente());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				flag = new Boolean(true);

				this.connection.commit();
			} else {
				flag = new Boolean(false);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

			flag = null;
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return flag;
	}

	@Override
	public Integer search() {
		// TODO Auto-generated method stub

		// Variables declaration

		Statement statement = null;

		Integer idCliente = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing

		try {
			query = "SELECT MAX(ID_CLIENTE) FROM CLIENTE_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet != null && resultSet.next()) {

				idCliente = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();

			idCliente = null;

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return idCliente;
	}

	@Override
	public void search(Cliente cliente) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing
		i = 1;

		try {
			query = "SELECT * FROM  PESSOA_TABLE P INNER JOIN CLIENTE_TABLE C ";
			query += "ON P.ID_PESSOA = C.ID_PESSOA ";
			query += "WHERE UPPER(PRIMEIRO_NOME) || ' ' || UPPER(SOBRE_NOME) LIKE ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, cliente.getIdCliente().intValue());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				cliente = new Cliente();

				createCliente(cliente, resultSet);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<Cliente> search(String bandeiraCartao) {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Cliente> clientes = null;

		Cliente cliente = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		i = 1;

		try {
			bandeiraCartao = "%" + bandeiraCartao.toUpperCase() + "%";

			query = "SELECT * FROM CLIENTE_TABLE BANDEIRA_CARTAO like ? ";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setString(i++, bandeiraCartao);

			resultSet = preparedStatement.executeQuery();

			clientes = new ArrayList<Cliente>();

			while (resultSet.next()) {

				cliente = new Cliente();

				createCliente(cliente, resultSet);

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		// Information output
		return clientes;
	}

	private void createCliente(Cliente cliente, ResultSet resultSet) {

		try {

			cliente.setIdPessoa(new Integer(resultSet.getInt("ID_PESSOA")));

			//cliente.setPrimeiroNome(resultSet.getString("PRIMEIRO_NOME"));

		//	if (resultSet.getString("SOBRE_NOME") != null) {

		//		cliente.setSobreNome(resultSet.getString("SOBRE_NOME"));

		//	} else {

		//		cliente.setSobreNome(null);
				
		//	}

		//	if (resultSet.getDate("DATA_NASCIMENTO") != null) {

		//		cliente.setDataNascimento(new java.util.Date(resultSet.getDate("DATA_NASCIMENTO").getTime()));

		//	} else {

		//		cliente.setDataNascimento(null);

		//	}

		//	if (resultSet.getString("SEXO") != null) {

		//		cliente.setSexo(new Character(resultSet.getString("SEXO").charAt(0)));

		//	} else {

		//		cliente.setSexo(null);

		//	}

		//	cliente.setCPF(resultSet.getString("CPF"));

		//	cliente.setNumeroCelular(resultSet.getString("NUMERO_CELULAR"));

		//	if (resultSet.getString("EMAIL") != null) {

		//		cliente.setEmail(resultSet.getString("EMAIL"));

		//	} else {

		//		cliente.setEmail(null);

		//	}

			cliente.setIdCliente(new Integer(resultSet.getInt("ID_CLIENTE")));

			cliente.setIdPessoa(new Integer(resultSet.getInt("ID_PESSOA")));

			if (resultSet.getString("BANDEIRA_CARTAO") != null) {

				cliente.setBandeiraCartao(resultSet.getString("BANDEIRA_CARTAO"));

			}

			else {

				cliente.setBandeiraCartao(null);
			}

			if (resultSet.getString("NUMERO_CARTAO") != null) {

				cliente.setNumeroCartao(new Integer(resultSet.getInt("NUMERO_CARTAO")));

			} else {

				cliente.setNumeroCartao(null);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			if (cliente != null) {

				cliente.setIdCliente(null);
			}

			e.printStackTrace();

		}

	}

	private PreparedStatement setPreparedStatement(Cliente cliente, PreparedStatement preparedStatement) {

		// Data processing

		i = 1;

		try {

			if (cliente.getBandeiraCartao() != null && !cliente.getBandeiraCartao().equals("")) {

				preparedStatement.setString(i++, cliente.getBandeiraCartao());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (cliente.getNumeroCartao() != null && !cliente.getNumeroCartao().equals(null)) {

				preparedStatement.setInt(i++, cliente.getNumeroCartao());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		// Information Output

		return preparedStatement;

	}

}
