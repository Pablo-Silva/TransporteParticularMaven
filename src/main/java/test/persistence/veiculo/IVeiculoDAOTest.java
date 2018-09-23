/**
 * 
 */
package test.persistence.veiculo;

import java.util.List;

import br.edu.uniopet.veiculo.vo.Veiculo;

/**
 * @author Shooting Stars
 *
 */
public interface IVeiculoDAOTest {

	public void save(Veiculo veiculo);

	public List<Veiculo> list();

	public void update(Veiculo veiculo);

	public Boolean delete(Veiculo veiculo);

	public Integer search();

	public void search(Veiculo veiculo);

	public List<Veiculo> search(String modeloVeiculo);

}
