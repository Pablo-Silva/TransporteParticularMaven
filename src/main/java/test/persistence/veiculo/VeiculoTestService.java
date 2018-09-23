/**
 * 
 */
package test.persistence.veiculo;

import java.sql.Connection;
import java.util.List;

import br.edu.uniopet.ConnectionFactory;
import br.edu.uniopet.veiculo.vo.Veiculo;

/**
 * @author Shooting Stars
 *
 */
public class VeiculoTestService implements IVeiculoDAOTest {

	/**
	 * Instance variables
	 */

	private VeiculoDAOTest veiculoDAOTest;

	private Connection connection;

	/**
	 * Default constructor
	 */

	public VeiculoTestService() {
		// TODO Auto-generated constructor stub

		connection = ConnectionFactory.getInstance();

		veiculoDAOTest = new VeiculoDAOTest();

		veiculoDAOTest.setConnection(connection);
	}

	/**
	 * Class operations
	 */

	@Override
	public void save(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
		veiculoDAOTest.save(veiculo);

	}

	@Override
	public List<Veiculo> list() {
		// TODO Auto-generated method stub
		return veiculoDAOTest.list();
	}

	@Override
	public void update(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
		veiculoDAOTest.update(veiculo);

	}

	@Override
	public Boolean delete(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return veiculoDAOTest.delete(veiculo);
	}

	@Override
	public Integer search() {
		// TODO Auto-generated method stub
		return veiculoDAOTest.search();
	}

	@Override
	public void search(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
		veiculoDAOTest.save(veiculo);

	}

	@Override
	public List<Veiculo> search(String modeloVeiculo) {
		// TODO Auto-generated method stub
		return veiculoDAOTest.search(modeloVeiculo);
	}

}
