/**
 * 
 */
package br.edu.uniopet.persistence.cliente;

import java.util.List;

import br.edu.uniopet.cliente.model.Cliente;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public interface IClienteDAO {

	public void create(Cliente cliente);

	public List<Cliente> recovery();

	public void update(Cliente cliente);

	public Boolean delete(Cliente cliente);

	public Integer search();

	public void search(Cliente cliente);

	public List<Cliente> search(String nome);

}
