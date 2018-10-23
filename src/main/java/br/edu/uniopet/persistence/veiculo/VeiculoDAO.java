/**
 * 
 */
package br.edu.uniopet.persistence.veiculo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.edu.uniopet.ConnectionFactory;
import br.edu.uniopet.veiculo.model.Veiculo;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
class VeiculoDAO implements IVeiculoDAO {

	/**
	 * Instance variables
	 */

	private Connection connection;

	private int i;

	/**
	 * Default constructor
	 */

	public VeiculoDAO() {
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
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#create(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public void create(Veiculo veiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		int count = 0;

		String query = null;

		Integer idVeiculo = null;

		// Data processing

		if (veiculo != null) {


			try {

				query = "INSERT INTO VEICULO_TABLE ";
				query += "(ID_VEICULO,ID_MOTORISTA,PLACA_VEICULO,MODELO_VEICULO,MARCA_VEICULO,COR_VEICULO,ACENTOS_VEICULO) ";
				query += "VALUES (VEICULO_SEQUENCE.NEXTVAL,MOTORISTA_SEQUENCE.CURRVAL, ?, ?, ?, ?, ?)";

				preparedStatement = this.connection.prepareStatement(query);

				this.setPreparedStatement(veiculo, preparedStatement);

				count = preparedStatement.executeUpdate();

				if (count == 1) {

					this.connection.commit();

					idVeiculo = this.search();

					veiculo.setIdVeiculo(idVeiculo);

					this.search(veiculo);

				} else {
					this.connection.rollback();

					veiculo = null;
				}

			} catch (SQLException e) {
				// TODO: handle exception

				e.printStackTrace();

				veiculo = null;

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
	 * @see br.edu.uniopet.persistence.veiculo.IVeiculoDAO#recovery()
	 */
	@Override
	public List<Veiculo> recovery() {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Veiculo> veiculos = null;

		Veiculo veiculo = null;

		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		try {
			query = "SELECT * FROM VEICULO_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			veiculos = new ArrayList<Veiculo>();

			while (resultSet.next()) {

				createVeiculo(veiculo, resultSet);

				veiculos.add(veiculo);
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
		return veiculos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#update(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public void update(Veiculo veiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		int count = 0;

		// Data processing

		try {

			query = "UPDATE VEICULO_TABLE SET ";
			query += "PLACA_VEICULO = ? ,MODELO_VEICULO = ? ,MARCA_VEICULO = ? ,COR_VEICULO = ?, ACENTOS_VEICULO = ?) ";
			query += "WHERE ID_VEICULO = ?";

			preparedStatement = setPreparedStatement(veiculo, preparedStatement);

			preparedStatement.setInt(6, veiculo.getIdVeiculo());

			count = preparedStatement.executeUpdate();

			if (count == 1) {
				this.connection.commit();

				this.search(veiculo);
			} else {
				veiculo = null;
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
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#delete(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public Boolean delete(Veiculo veiculo) {
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
			query = "DELETE FROM VEICULO_TABLE WHERE ID_VEICULO = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, veiculo.getIdVeiculo());

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
	 * @see br.edu.uniopet.persistence.veiculo.IVeiculoDAO#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub

		// Variables declaration

		Statement statement = null;

		Integer idVeiculo = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing

		try {
			query = "SELECT MAX(ID_VEICULO) FROM VEICULO_TABLE";

			statement = this.connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet != null && resultSet.next()) {

				idVeiculo = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();

			idVeiculo = null;

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

		return idVeiculo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#search(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public void search(Veiculo veiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		ResultSet resultSet = null;

		// Data processing
		i = 1;

		try {
			query = "SELECT * FROM VEICULO_TABLE WHERE ID_VEICULO = ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(i++, veiculo.getIdVeiculo().intValue());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				veiculo = new Veiculo();

				createVeiculo(veiculo, resultSet);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.veiculo.IVeiculoDAO#search(java.lang.String)
	 */
	@Override
	public List<Veiculo> search(String modeloVeiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		List<Veiculo> veiculos = null;

		Veiculo veiculo = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		i = 1;

		try {

			modeloVeiculo = "%" + modeloVeiculo.toUpperCase() + "%";

			query = "SELECT * FROM VEICULO_TABLE ";
			query += "WHERE UPPER(MODELO_VEICULO) LIKE ?";

			preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setString(i++, modeloVeiculo);

			resultSet = preparedStatement.executeQuery();

			veiculos = new ArrayList<Veiculo>();

			while (resultSet.next()) {

				veiculo = new Veiculo();

				createVeiculo(veiculo, resultSet);

				veiculos.add(veiculo);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		// Information output
		return veiculos;
	}

	private void createVeiculo(Veiculo veiculo, ResultSet resultSet) {

		try {

			veiculo.setIdMotorista(new Integer(resultSet.getInt("ID_MOTORISTA")));

			veiculo.setIdVeiculo(new Integer(resultSet.getInt("ID_VEICULO")));

			veiculo.setPlacaVeiculo(resultSet.getString("PLACA_VEICULO"));

			if (resultSet.getString("MODELO_VEICULO") != null) {
				veiculo.setModeloVeiculo(resultSet.getString("MODELO_VEICULO"));
			}

			if (resultSet.getString("MARCA_VEICULO") != null) {
				veiculo.setMarcaVeiculo(resultSet.getString("MARCA_VEICULO"));
			}

			if (resultSet.getString("COR_VEICULO") != null) {
				veiculo.setCorVeiculo(resultSet.getString("COR_VEICULO"));
			}

			veiculo.setAcentosVeiculos(new Integer(resultSet.getInt("ACENTOS_VEICULO")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			veiculo = null;
		}

	}

	private PreparedStatement setPreparedStatement(Veiculo veiculo, PreparedStatement preparedStatement) {

		// Data processing

		i = 1;

		try {

			preparedStatement.setString(i++, veiculo.getPlacaVeiculo().toString());

			if (veiculo.getModeloVeiculo() != null && !veiculo.getModeloVeiculo().equals("")) {

				preparedStatement.setString(i++, veiculo.getModeloVeiculo().toString());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (veiculo.getMarcaVeiculo() != null && !veiculo.getMarcaVeiculo().equals("")) {

				preparedStatement.setString(i++, veiculo.getMarcaVeiculo().toString());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			if (veiculo.getCorVeiculo() != null && !veiculo.getCorVeiculo().equals("")) {

				preparedStatement.setString(i++, veiculo.getCorVeiculo().toString());
			} else {

				preparedStatement.setNull(i++, Types.NULL);
			}

			preparedStatement.setInt(i++, (new Integer(veiculo.getAcentosVeiculos().toString())));

		} catch (SQLException e) {
			// TODO: handle exception
		}
		// Information Output

		return preparedStatement;

	}

}
