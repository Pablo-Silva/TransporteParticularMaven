/**
 * 
 */
package br.edu.uniopet.persistence.motorista;

import java.util.List;

import br.edu.uniopet.motorista.model.Motorista;



/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public interface IMotoristaDAO {

	public void create(Motorista motorista );

	public List<Motorista> recovery();

	public void update(Motorista motorista);

	public Boolean delete(Motorista motorista);

	public Integer search();

	public void search(Motorista motorista);

	public List<Motorista> search(String nome);

}
