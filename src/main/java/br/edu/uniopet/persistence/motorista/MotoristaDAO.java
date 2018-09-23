/**
 * 
 */
package br.edu.uniopet.persistence.motorista;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.edu.uniopet.ConnectionFactory;
import br.edu.uniopet.persistence.pessoa.PessoaService;
import br.edu.uniopet.vo.motorista.Motorista;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
class MotoristaDAO implements IMotoristaDAO {

	/**
	 * Instance variables
	 */

	private Connection connection;

	private PessoaService pessoaService;

	private int i;

	/**
	 * Default constructor
	 */

	public MotoristaDAO() {
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
	public void create(Motorista motorista) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		int count = 0;

		String query = null;

		Integer idMotorista = null;

		// Data processing

		if (motorista != null) {

			this.pessoaService.create(motorista);

			try {

				query = "INSERT INTO MOTORISTA_TABLE ";
				query += "(ID_MOTORISTA,ID_PESSOA,DATA_CADASTRO,STATUS_MOTORISTA,CARTEIRA_MOTORISTA) ";
				query += "VALUES (MOTORISTA_SEQUENCE.NEXTVAL,PESSOA_SEQUENCE.CURRVAL, ?, ?, ?)";

				preparedStatement = this.connection.prepareStatement(query);

				this.setPreparedStatement(motorista, preparedStatement);

				count = preparedStatement.executeUpdate();

				if (count == 1) {

					this.connection.commit();

					idMotorista = this.search();

					motorista.setIdMotorista(idMotorista);

					this.search(motorista);

				} else {
					this.connection.rollback();

					motorista = null;
				}

			} catch (SQLException e) {
				// TODO: handle exception

				e.printStackTrace();

				motorista = null;

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
	public List<Motorista> recovery() {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Motorista> motoristas = null;

		Motorista motorista = null;

		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		try {
			query = "SELECT * FROM MOTORISTA_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			motoristas = new ArrayList<Motorista>();

			while (resultSet.next()) {
				createMotorista(motorista, resultSet);

				motoristas.add(motorista);
			}
		} catch (SQLException e) {
			// TODO: handle exception

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
		return motoristas;
	}

	@Override
	public void update(Motorista motorista) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		int count = 0;

		// Data processing

		try {

			query = "UPDATE MOTORISTA_TABLE SET ";
			query += "DATA_CADASTRO = ? ,STATUS_MOTORISTA = ?,CARTEIRA_MOTORISTA = ?) ";
			query += "WHERE ID_MOTORISTA = ?";

			preparedStatement = setPreparedStatement(motorista, preparedStatement);

			preparedStatement.setInt(4, motorista.getIdMotorista());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				this.connection.commit();

				this.search(motorista);
			} else {
				motorista = null;
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
	public Boolean delete(Motorista motorista) {
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
			query = "DELETE FROM MOTORISTA_TABLE WHERE ID_MOTORISTA = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, motorista.getIdMotorista());

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

		Integer idMotorista = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing

		try {
			query = "SELECT MAX(ID_MOTORISTA) FROM MOTORISTA_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet != null && resultSet.next()) {

				idMotorista = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();

			idMotorista = null;

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

		return idMotorista;
	}

	@Override
	public void search(Motorista motorista) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing
		i = 1;

		try {
			query = "SELECT * FROM MOTORISTA_TABLE WHERE ID_MOTORISTA = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, motorista.getIdMotorista().intValue());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				motorista = new Motorista();

				createMotorista(motorista, resultSet);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<Motorista> search(String nome) {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Motorista> motoristas = null;

		Motorista motorista = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		i = 1;

		try {

			nome = "%" + nome.toUpperCase() + "%";

			query = "SELECT * FROM  PESSOA_TABLE INNER JOIN MOTORISTA_TABLE ";

			query += "ON PESSOA_TABLE.ID_PESSOA = MOTORISTA_TABLE.ID_PESSOA ";

			query += "WHERE UPPER(PRIMEIRO_NOME) || ' ' || UPPER(SOBRE_NOME) LIKE ?";
			;

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setString(i++, nome);

			resultSet = preparedStatement.executeQuery();

			motoristas = new ArrayList<Motorista>();

			while (resultSet.next()) {

				motorista = new Motorista();

				createMotorista(motorista, resultSet);

				motoristas.add(motorista);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		// Information output
		return motoristas;
	}

	private void createMotorista(Motorista motorista, ResultSet resultSet) {

		// Data processing

		try {

			motorista.setIdPessoa(new Integer(resultSet.getInt("ID_PESSOA")));
			
			motorista.setPrimeiroNome(resultSet.getString("PRIMEIRO_NOME"));

			motorista.setSobreNome(resultSet.getString("SOBRE_NOME"));

			motorista.setDataNascimento(new java.util.Date(resultSet.getDate("DATA_NASCIMENTO").getTime()));

			motorista.setSexo(new Character(resultSet.getString("SEXO").charAt(0)));

			motorista.setCPF(resultSet.getString("CPF"));

			motorista.setNumeroCelular(resultSet.getString("NUMERO_CELULAR"));

			motorista.setEmail(resultSet.getString("EMAIL"));

			motorista.setIdMotorista(new Integer(resultSet.getInt("ID_MOTORISTA")));

			motorista.setDataCadastro(new java.util.Date(resultSet.getDate("DATA_CADASTRO").getTime()));

			motorista.setStatusMotorista(new Character(resultSet.getString("STATUS_MOTORISTA").charAt(0)));

			motorista.setCarteiraMotorista(resultSet.getString("CARTEIRA_MOTORISTA"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			motorista = null;
		}
	}

	private PreparedStatement setPreparedStatement(Motorista motorista, PreparedStatement preparedStatement) {

		// Data processing

		i = 1;

		try {

			if (motorista.getDataCadastro() != null && !motorista.getDataCadastro().equals(null)) {

				preparedStatement.setDate(i++, new Date(motorista.getDataCadastro().getTime()));
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (motorista.getStatusMotorista() != null && !motorista.getStatusMotorista().equals(null)) {

				preparedStatement.setString(i++, motorista.getStatusMotorista().toString());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (motorista.getCarteiraMotorista() != null && !motorista.getCarteiraMotorista().equals("")) {

				preparedStatement.setString(i++, motorista.getCarteiraMotorista());
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
