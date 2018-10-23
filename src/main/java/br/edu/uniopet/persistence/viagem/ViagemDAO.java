/**
 * 
 */
package br.edu.uniopet.persistence.viagem;

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
import br.edu.uniopet.viagem.model.Viagem;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
class ViagemDAO implements IViagemDAO {

	/**
	 * Instance variables
	 */

	private Connection connection;

	private int i;

	/**
	 * Default constructor
	 */

	public ViagemDAO() {
		// TODO Auto-generated constructor stub

		this.connection = ConnectionFactory.getInstance();

		try {
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#create(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public void create(Viagem viagem) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		int count = 0;

		String query = null;

		Integer idViagem = null;

		// Data processing

		if (viagem!= null) {

			try {

				query = "INSERT INTO VIAGEM_TABLE ";
				query += "(ID_VIAGEM,ID_VEICULO,ID_MOTORISTA,ID_CLIENTE,ENDERECO_SAIDA,ENDERECO_CHEGADA,DATA_INICIO,DATA_FIM) ";
				query += "VALUES (VIAGEM_SEQUENCE.NEXTVAL,VEICULO_SEQUENCE.CURRVAL,MOTORISTA_SEQUENCE.CURRVAL,CLIENTE_SEQUENCE.CURRVAL, ?, ?, ?, ?)";

				preparedStatement = this.connection.prepareStatement(query);

				this.setPreparedStatement(viagem, preparedStatement);

				count = preparedStatement.executeUpdate();

				if (count == 1) {

					this.connection.commit();

					idViagem = this.search();

					viagem.setIdViagem(idViagem);

					this.search(viagem);

				} else {
					this.connection.rollback();

					viagem = null;
				}

			} catch (SQLException e) {
				// TODO: handle exception

				e.printStackTrace();

				viagem = null;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.viagem.IViagemDAO#recovery()
	 */
	@Override
	public List<Viagem> recovery() {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Viagem> viagems = null;

		Viagem viagem = null;

		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		try {
			query = "SELECT * FROM VIAGEM_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			viagems = new ArrayList<Viagem>();

			while (resultSet.next()) {

				createViagem(viagem, resultSet);

				viagems.add(viagem);
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
		return viagems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#update(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public void update(Viagem viagem) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		int count = 0;

		// Data processing

		try {

			query = "UPDATE VIAGEM_TABLE SET ";
			query += "ENDERECO_SAIDA = ? ,ENDERECO_CHEGADA = ? ,DATA_INICIO = ? ,DATA_FIM = ?) ";
			query += "WHERE ID_VIAGEM = ?";

			preparedStatement = setPreparedStatement(viagem, preparedStatement);

			preparedStatement.setInt(5, viagem.getIdViagem());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				this.connection.commit();

				this.search(viagem);
			} else {
				viagem = null;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#delete(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public Boolean delete(Viagem viagem) {
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
			query = "DELETE FROM VIAGEM_TABLE WHERE ID_VIAGEM = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, viagem.getIdViagem());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.viagem.IViagemDAO#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub

		// Variables declaration

		Statement statement = null;

		Integer idViagem = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing

		try {
			query = "SELECT MAX(ID_VIAGEM) FROM VIAGEM_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet != null && resultSet.next()) {

				idViagem = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();

			idViagem = null;

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

		return idViagem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#search(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public void search(Viagem viagem) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing
		i = 1;

		try {
			query = "SELECT * FROM VIAGEM_TABLE WHERE ID_VIAGEM = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, viagem.getIdViagem().intValue());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				viagem = new Viagem();

				createViagem(viagem, resultSet);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.viagem.IViagemDAO#search(java.lang.String)
	 */
	@Override
	public List<Viagem> search(String endereco) {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Viagem> viagems = null;

		Viagem viagem = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		i = 1;

		try {

			endereco = "%" + endereco.toUpperCase() + "%";

			query = "SELECT * FROM VIAGEM_TABLE ";
			query += "WHERE UPPER(ENDERECO_SAIDA) || ' ' || UPPER(ENDERECO_CHEGADA) LIKE ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setString(i++, endereco);

			resultSet = preparedStatement.executeQuery();

			viagems = new ArrayList<Viagem>();

			while (resultSet.next()) {

				viagem = new Viagem();

				createViagem(viagem, resultSet);

				viagems.add(viagem);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		// Information output
		return viagems;
	}

	private void createViagem(Viagem viagem, ResultSet resultSet) {

		// Data processing

		try {

			viagem.setIdViagem(new Integer(resultSet.getInt("ID_VIAGEM")));

			viagem.setIdVeiculo(new Integer(resultSet.getInt("ID_VEICULO")));

			viagem.setIdMotorista(new Integer(resultSet.getInt("ID_MOTORISTA")));

			viagem.setIdCliente(new Integer(resultSet.getInt("ID_CLIENTE")));

			viagem.setEnderecoSaida(resultSet.getString("ENDERECO_SAIDA"));

			viagem.setEnderecoChegada(resultSet.getString("ENDERECO_CHEGADA"));

			viagem.setDataInicio(new java.util.Date(resultSet.getDate("DATA_INICIO").getTime()));

			viagem.setDataFim(new java.util.Date(resultSet.getDate("DATA_FIM").getTime()));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			viagem = null;
		}
	}

	private PreparedStatement setPreparedStatement(Viagem viagem, PreparedStatement preparedStatement) {

		// Data processing

		i = 1;

		try {

			if (viagem.getEnderecoSaida() != null && !viagem.getEnderecoSaida().equals("")) {

				preparedStatement.setString(i++, viagem.getEnderecoSaida());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (viagem.getEnderecoChegada() != null && !viagem.getEnderecoChegada().equals("")) {

				preparedStatement.setString(i++, viagem.getEnderecoChegada());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (viagem.getDataInicio() != null && !viagem.getDataInicio().equals("")) {

				preparedStatement.setDate(i++, new Date(viagem.getDataInicio().getTime()));
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (viagem.getDataFim() != null && !viagem.getDataFim().equals("")) {

				preparedStatement.setDate(i++, new Date(viagem.getDataFim().getTime()));
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
