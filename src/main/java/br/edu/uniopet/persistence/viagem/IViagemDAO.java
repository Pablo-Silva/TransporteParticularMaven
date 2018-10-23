/**
 * 
 */
package br.edu.uniopet.persistence.viagem;

import java.util.List;

import br.edu.uniopet.viagem.model.Viagem;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public interface IViagemDAO {

	public void create(Viagem viagem);

	public List<Viagem> recovery();

	public void update(Viagem viagem);

	public Boolean delete(Viagem viagem);

	public Integer search();

	public void search(Viagem viagem);

	public List<Viagem> search(String endereco);

}
