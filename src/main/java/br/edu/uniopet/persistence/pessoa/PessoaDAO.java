/**
 * 
 */
package br.edu.uniopet.persistence.pessoa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import br.edu.uniopet.ConnectionFactory;
import br.edu.uniopet.pessoa.vo.Pessoa;


/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
class PessoaDAO implements IPessoaDAO {

	/**
	 * Instance variables
	 */

	private Connection connection;

	private int i;

	/**
	 * Default constructor
	 */

	public PessoaDAO() {
		// TODO Auto-generated constructor stub

		this.connection = ConnectionFactory.getInstance();

		try {
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create(Pessoa pessoa) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		int count = 0;

		String query = null;

		Integer idPessoa = null;

		// Data processing

		try {

			query = "INSERT INTO PESSOA_TABLE ";
			query += "(ID_PESSOA,PRIMEIRO_NOME,SOBRE_NOME,DATA_NASCIMENTO,SEXO,CPF,NUMERO_CELULAR,EMAIL) ";
			query += "VALUES (PESSOA_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

			// preparedStatement = this.connection.prepareStatement(query);

			preparedStatement = this.connection.prepareStatement(query);

			this.setPreparedStatement(pessoa, preparedStatement);

			count = preparedStatement.executeUpdate();

			if (count == 1) {

				idPessoa = this.search();

				pessoa.setIdPessoa(idPessoa);

				this.search(pessoa);

			} else {

				pessoa.setIdPessoa(null);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();

			pessoa = null;

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
	public List<Pessoa> recovery() {
		// TODO Auto-generated method stub
		// Variables declaration

		List<Pessoa> pessoas = null;

		Pessoa pessoa = null;

		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		try {
			query = "SELECT * FROM PESSOA_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			pessoas = new ArrayList<Pessoa>();

			while (resultSet.next()) {
				createPessoa(pessoa, resultSet);

				pessoas.add(pessoa);
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
		return pessoas;
	}

	@Override
	public void update(Pessoa pessoa) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		int count = 0;

		// Data processing

		try {

			query = "UPDATE PESSOA_TABLE SET ";
			query += "PRIMEIRO_NOME = ? ,SOBRE_NOME = ?,DATA_NASCIMENTO = ?,SEXO = ?,CPF = ?,NUMERO_CELULAR = ?,EMAIL = ?) ";
			query += "WHERE ID_PESSOA = ?";

			setPreparedStatement(pessoa, preparedStatement);

			preparedStatement.setInt(8, pessoa.getIdPessoa());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				this.search(pessoa);
			} else {
				pessoa = null;
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
	public Boolean delete(Pessoa pessoa) {
		// TODO Auto-generated method stub

		Boolean flag = null;

		PreparedStatement preparedStatement = null;

		String query = null;

		int count = 0;

		// Data processing

		i = 1;

		try {
			query = "DELETE FROM PESSOA_TABLE WHERE ID_PESSOA = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, pessoa.getIdPessoa());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				flag = new Boolean(true);
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
		Statement statement = null;

		Integer idPessoa = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing

		try {
			query = "SELECT MAX(ID_PESSOA) FROM PESSOA_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet != null && resultSet.next()) {

				idPessoa = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();

			idPessoa = null;

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

		return idPessoa;
	}

	@Override
	public void search(Pessoa pessoa) {
		// TODO Auto-generated method stub

		// Variables declaration
		PreparedStatement preparedStatement = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing

		i = 1;

		try {
			query = "SELECT * FROM PESSOA_TABLE WHERE ID_PESSOA = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, pessoa.getIdPessoa().intValue());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				this.createPessoa(pessoa, resultSet);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Pessoa> search(String nome) {
		// TODO Auto-generated method stub
		// Variables declaration

		List<Pessoa> pessoas = null;

		Pessoa pessoa = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		i = 1;

		try {
			nome = "%" + nome.toUpperCase() + "%";

			query = "SELECT * FROM PESSOA_TABLE ";
			
			query +="WHERE UPPER(PRIMEIRO_NOME) || ' ' || UPPER(SOBRE_NOME) LIKE ? ";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setString(i++, nome);

			resultSet = preparedStatement.executeQuery();

			pessoas = new ArrayList<Pessoa>();

			while (resultSet.next()) {
				
				pessoa = new Pessoa();
				
				createPessoa(pessoa, resultSet);

				pessoas.add(pessoa);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		// Information output
		return pessoas;
	}

	private void createPessoa(Pessoa pessoa, ResultSet resultSet) {

		// Data processing

		try {

			pessoa.setIdPessoa(new Integer(resultSet.getInt("ID_PESSOA")));

			pessoa.setPrimeiroNome(resultSet.getString("PRIMEIRO_NOME"));

			if (resultSet.getString("SOBRE_NOME") != null) {
				pessoa.setSobreNome(resultSet.getString("SOBRE_NOME"));
			}

			if (resultSet.getDate("DATA_NASCIMENTO") != null) {
				pessoa.setDataNascimento(new java.util.Date(resultSet.getDate("DATA_NASCIMENTO").getTime()));
			}

			if (resultSet.getString("SEXO") != null) {
				pessoa.setSexo(new Character(resultSet.getString("SEXO").charAt(0)));
			}

			pessoa.setCPF(resultSet.getString("CPF"));

			pessoa.setNumeroCelular(resultSet.getString("NUMERO_CELULAR"));

			if (resultSet.getString("EMAIL") != null) {
				pessoa.setEmail(resultSet.getString("EMAIL"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

			pessoa = null;
		}
	}

	private void setPreparedStatement(Pessoa pessoa, PreparedStatement preparedStatement) {

		// Data processing

		i = 1;

		try {

			preparedStatement.setString(i++, pessoa.getPrimeiroNome());

			if (pessoa.getPrimeiroNome() != null && !pessoa.getPrimeiroNome().equals("")) {

				preparedStatement.setString(i++, pessoa.getPrimeiroNome());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (pessoa.getDataNascimento() != null && !pessoa.getDataNascimento().equals(null)) {

				preparedStatement.setDate(i++, new Date(pessoa.getDataNascimento().getTime()));
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (pessoa.getSexo() != null && !pessoa.getSexo().equals(null)) {

				preparedStatement.setString(i++, pessoa.getSexo().toString());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			preparedStatement.setString(i++, pessoa.getCPF());

			preparedStatement.setString(i++, pessoa.getNumeroCelular());

			if (pessoa.getEmail() != null && !pessoa.getEmail().equals("")) {

				preparedStatement.setString(i++, pessoa.getEmail());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
