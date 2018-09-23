/**
 * 
 */
package br.edu.uniopet.model;

import java.util.List;

import br.edu.uniopet.cliente.vo.Cliente;
import br.edu.uniopet.persistence.cliente.ClienteService;

/**
 * @author Pablo
 *
 */
public class ManutencaoCliente {

	/**
	 * Instance variables
	 */

	private ClienteService clienteService;

	/**
	 * Default constructor
	 */

	public ManutencaoCliente() {
		// TODO Auto-generated constructor stub

		clienteService = new ClienteService();
	}

	/**
	 * Class operations
	 */

	public void create(Cliente cliente) {

		clienteService.create(cliente);
	}

	public List<Cliente> list() {

		return clienteService.recovery();
	}

	public void update(Cliente cliente) {

		clienteService.update(cliente);
	}

	public Boolean delete(Cliente cliente) {

		return clienteService.delete(cliente);
	}

	public void search(Cliente cliente) {

		clienteService.search(cliente);
	}

	public List<Cliente> search(String nome) {

		return clienteService.search(nome);
	}

}
