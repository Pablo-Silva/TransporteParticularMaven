/**
 * 
 */
package br.edu.uniopet.persistence.veiculo;

import java.util.List;

import br.edu.uniopet.veiculo.model.Veiculo;


/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public interface IVeiculoDAO {

	public void create(Veiculo veiculo);

	public List<Veiculo> recovery();

	public void update(Veiculo veiculo);

	public Boolean delete(Veiculo veiculo);

	public Integer search();

	public void search(Veiculo veiculo);

	public List<Veiculo> search(String modeloVeiculo);

}
