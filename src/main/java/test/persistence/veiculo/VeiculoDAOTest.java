/**
 * 
 */
package test.persistence.veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import static test.persistence.veiculo.Persistence.ATUALIZACAO_ERRO;
import static test.persistence.veiculo.Persistence.ATUALIZACAO_NAO_SUCESSO;
import static test.persistence.veiculo.Persistence.ATUALIZACAO_SUCESSO;
import static test.persistence.veiculo.Persistence.CONSULTA_ERRO;
import static test.persistence.veiculo.Persistence.CONSULTA_NAO_SUCESSO;
import static test.persistence.veiculo.Persistence.CONSULTA_SUCESSO;
import static test.persistence.veiculo.Persistence.EXCLUSAO_ERRO;
import static test.persistence.veiculo.Persistence.EXCLUSAO_NAO_SUCESSO;
import static test.persistence.veiculo.Persistence.EXCLUSAO_SUCESSO;
import static test.persistence.veiculo.Persistence.FLAG;
import static test.persistence.veiculo.Persistence.INSERCAO_ERRO;
import static test.persistence.veiculo.Persistence.INSERCAO_NAO_SUCESSO;
import static test.persistence.veiculo.Persistence.INSERCAO_SUCESSO;
import static test.persistence.veiculo.Persistence.RECUPERACAO_DADOS_NAO_SUCESSO;
import static test.persistence.veiculo.Persistence.RECUPERACAO_DADOS_SUCESSO;

import br.edu.uniopet.ConnectionFactory;
import br.edu.uniopet.veiculo.vo.Veiculo;

/**
 * @author Shooting Stars
 *
 */

class VeiculoDAOTest implements IVeiculoDAOTest {

	/**
	 * Instance variables
	 */

	private Connection connection;

	int i;

	/**
	 * Default constructor
	 */

	public VeiculoDAOTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Access methods
	 */

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Class operations
	 */

	@Override
	public void save(Veiculo veiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		String msg = null;

		Integer idVeiculo = null;

		Integer count = null;

		// Data processing

		try {

			query = "INSERT INTO VEICULO_TABLE ";
			query += "(ID_VEICULO,ID_MOTORISTA,PLACA_VEICULO,MODELO_VEICULO,MARCA_VEICULO,COR_VEICULO,ACENTOS_VEICULO) ";
			query += "VALUES (VEICULO_SEQUENCE.NEXTVAL,MOTORISTA_SEQUENCE.CURRVAL, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(query);

			setPreparedStatement(veiculo, preparedStatement);

			count = new Integer(preparedStatement.executeUpdate());

			if (count != null && count.equals(1)) {

				connection.commit();

				msg = INSERCAO_SUCESSO;

				idVeiculo = this.search();

				if (idVeiculo != null && idVeiculo.intValue() > 0) {

					veiculo.setIdVeiculo(idVeiculo);

					search(veiculo);

					msg += RECUPERACAO_DADOS_SUCESSO;

				} else {

					msg += RECUPERACAO_DADOS_NAO_SUCESSO;
				}

			} else {

				msg = INSERCAO_NAO_SUCESSO;
			}

		} catch (SQLException e) {

			veiculo = null;

			msg = INSERCAO_ERRO + e.getMessage();

			e.printStackTrace();

		} finally {

			if (FLAG.equals(true) && msg != null) {

				System.err.println(String.format("\n %s: %s", this.getClass().getSimpleName(), msg));

				if (veiculo != null) {

					System.err.println(String.format("\n Dados inserido: %s", veiculo.toString()));
				}
			}
		}

	}

	@Override
	public List<Veiculo> list() {
		// TODO Auto-generated method stub
		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		String msg = null;

		Veiculo veiculo = null;

		List<Veiculo> veiculos = null;

		// Data processing

		connection = ConnectionFactory.getInstance();

		if (connection == null) {

			return null;
		}

		try {

			query = "SELECT * FROM VEICULO_TABLE";

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery(query);

			if (resultSet.last()) {

				resultSet.beforeFirst();

				veiculos = new ArrayList<>();

				while (resultSet.next()) {

					veiculo = new Veiculo();

					createVeiculo(veiculo, resultSet);

					veiculos.add(veiculo);
				}

				msg = CONSULTA_SUCESSO;

			} else {

				msg = CONSULTA_NAO_SUCESSO;
			}

		} catch (Exception e) {
			// TODO: handle exception

			veiculos = null;

			msg = CONSULTA_ERRO + e.getMessage();

			e.printStackTrace();

		} finally {

			if (FLAG.equals(true) && msg != null) {

				System.err.println(String.format("\n %s: %s", this.getClass().getSimpleName(), msg));

				if (veiculos != null && veiculos.size() > 0) {

					System.err.println("\n Dados: ");

					for (Veiculo veic : veiculos) {

						System.err.println(veic.toString());
					}
				}
			}
		}

		// Information output

		return veiculos;
	}

	@Override
	public void update(Veiculo veiculo) {
		// TODO Auto-generated method stub

		PreparedStatement preparedStatement = null;

		String query = null;

		String msg = null;

		Integer count = null;

		// Data processing

		try {

			query = "UPDATE VEICULO_TABLE SET ";
			query += "PLACA_VEICULO = ? ,MODELO_VEICULO = ? ,MARCA_VEICULO = ? ,COR_VEICULO = ?, ACENTOS_VEICULO = ?) ";
			query += "WHERE ID_VEICULO = ?";

			preparedStatement = connection.prepareStatement(query);

			setPreparedStatement(veiculo, preparedStatement);

			preparedStatement.setInt(i++, veiculo.getIdVeiculo());

			count = new Integer(preparedStatement.executeUpdate());

			if (count != null && count.equals(1)) {

				connection.commit();

				msg = ATUALIZACAO_SUCESSO;

				search(veiculo);

			} else {

				msg = ATUALIZACAO_NAO_SUCESSO;
			}

		} catch (SQLException e) {
			// TODO: handle exception

			if (veiculo != null) {

				veiculo.setIdVeiculo(null);
			}

			msg = ATUALIZACAO_ERRO + e.getMessage();

			e.printStackTrace();

		} finally {

			if (FLAG.equals(true) && msg != null) {

				System.err.println(String.format("\n %s: %s", VeiculoDAOTest.class.getSimpleName(), msg));

				if (veiculo != null) {

					System.err.println("\n Dados atualizados: " + veiculo.toString());
				}
			}
		}

	}

	@Override
	public Boolean delete(Veiculo veiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		String query = null;

		String msg = null;

		Boolean flag = null;

		Integer count = null;

		// Data processing

		i = 1;

		try {

			query = "DELETE FROM VEICULO_TABLE WHERE ID_VEICULO = ?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(i++, veiculo.getIdVeiculo());

			count = new Integer(preparedStatement.executeUpdate());

			if (count != null && count.equals(1)) {

				connection.commit();

				flag = true;

				msg = EXCLUSAO_SUCESSO;

			} else {

				flag = false;

				msg = EXCLUSAO_NAO_SUCESSO;
			}

		} catch (SQLException e) {
			// TODO: handle exception

			flag = null;

			msg = EXCLUSAO_ERRO + e.getMessage();

			e.printStackTrace();

		} finally {

			if (FLAG.equals(true) && msg != null) {

				System.err.println(String.format("\n %s: %s", this.getClass().getSimpleName(), msg));

				if (flag != null && flag.equals(true)) {

					System.err.println("\n Dados excluídos: " + veiculo.toString());

				} else {

					System.err.println("\n Não foi possível excluir dados.");
				}
			}
		}

		// Information output

		return flag;
	}

	@Override
	public Integer search() {
		// TODO Auto-generated method stub

		// Variables declaration

		Statement statement = null;

		ResultSet resultSet = null;

		String query = null;

		Integer idVeiculo = null;

		// Data processing

		try {

			query = "SELECT MAX(ID_VEICULO) FROM VEICULO_TABLE";

			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet.next()) {

				idVeiculo = new Integer(resultSet.getInt(1));
			}

		} catch (SQLException e) {
			// TODO: handle exception

			idVeiculo = null;

			e.printStackTrace();
		}

		// Information output

		return idVeiculo;
	}

	@Override
	public void search(Veiculo veiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		// Data processing

		i = 1;

		try {

			query = "SELECT * FROM VEICULO_TABLE WHERE ID_VEICULO = ?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(i++, veiculo.getIdVeiculo().intValue());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				veiculo = new Veiculo();

				createVeiculo(veiculo, resultSet);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			if (veiculo != null) {

				veiculo.setIdVeiculo(null);
			}

			e.printStackTrace();
		}

	}

	@Override
	public List<Veiculo> search(String modeloVeiculo) {
		// TODO Auto-generated method stub

		// Variables declaration

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		String query = null;

		List<Veiculo> veiculos = null;

		Veiculo veiculo = null;

		// Data processing

		i = 1;

		try {

			modeloVeiculo = "%" + modeloVeiculo.toUpperCase() + "%";

			query = "SELECT * FROM VEICULO_TABLE PESSOA WHERE MODELO_VEICULO LIKE ? ORDER BY MODELO_VEICULO ASC";

			preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			preparedStatement.setString(i++, modeloVeiculo);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.last()) {

				resultSet.beforeFirst();

				veiculos = new ArrayList<>();

				while (resultSet.next()) {

					veiculo = new Veiculo();

					createVeiculo(veiculo, resultSet);

					veiculos.add(veiculo);
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();
		}

		// Information output

		return veiculos;
	}

	private void setPreparedStatement(Veiculo veiculo, PreparedStatement preparedStatement) {

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

			if (veiculo != null) {

				veiculo.setIdVeiculo(null);
			}

			e.printStackTrace();
		}
	}

	private void createVeiculo(Veiculo veiculo, ResultSet resultSet) {

		// Data processing

		try {

			veiculo.setIdVeiculo(new Integer(resultSet.getInt("ID_VEICULO")));
			;

			veiculo.setIdMotorista(new Integer(resultSet.getInt("ID_MOTORISTA")));
			;

			veiculo.setPlacaVeiculo(resultSet.getString("PLACA_VEICULO"));

			if (resultSet.getString("MODELO_VEICULO") != null) {

				veiculo.setModeloVeiculo(resultSet.getString("MODELO_VEICULO"));

			} else {

				veiculo.setModeloVeiculo(null);
			}

			if (resultSet.getString("MARCA_VEICULO") != null) {

				veiculo.setMarcaVeiculo(resultSet.getString("MARCA_VEICULO"));

			} else {

				veiculo.setMarcaVeiculo(null);
			}

			if (resultSet.getString("COR_VEICULO") != null) {

				veiculo.setCorVeiculo(resultSet.getString("COR_VEICULO"));

			} else {

				veiculo.setCorVeiculo(null);
			}

		} catch (SQLException e) {
			// TODO: handle exception

			if (veiculo != null) {

				veiculo.setIdVeiculo(null);
			}

			e.printStackTrace();
		}
	}

}
