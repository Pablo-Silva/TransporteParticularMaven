/**
 * 
 */
package br.edu.uniopet.controller;

import java.util.List;

import br.edu.uniopet.cliente.vo.Cliente;
import br.edu.uniopet.model.ManutencaoCliente;

/**
 * @author Pablo
 *
 */
public class ClienteController {

	/**
	 * Instance variables
	 */

	private Cliente cliente;

	private List<Cliente> clientes;

	private ManutencaoCliente manutencaoCliente;

	/**
	 * Default constructor
	 */

	public ClienteController() {
		// TODO Auto-generated constructor stub

		this.cliente = new Cliente();

		this.manutencaoCliente = new ManutencaoCliente();

	}

	/**
	 * Access methods
	 */

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void create() {

		if (this.cliente != null
				&& (this.cliente.getPrimeiroNome() != null && !this.cliente.getPrimeiroNome().equals(""))) {

			manutencaoCliente.create(this.cliente);
		}
	}

	public List<Cliente> list() {

		this.clientes = this.manutencaoCliente.list();

		return this.clientes;
	}

	public void update() {

		if (this.cliente != null
				&& (this.cliente.getPrimeiroNome() != null && !this.cliente.getPrimeiroNome().equals(""))) {

			this.manutencaoCliente.update(this.cliente);
		}
	}

	public Boolean delete() {

		return manutencaoCliente.delete(this.cliente);
	}

	public void search(Cliente cliente) {

		manutencaoCliente.search(cliente);
	}

	public List<Cliente> search(String nome) {

		this.clientes = manutencaoCliente.search(nome);

		return this.clientes;
	}

	public void novo() {

		this.cliente = new Cliente();
	}

}
