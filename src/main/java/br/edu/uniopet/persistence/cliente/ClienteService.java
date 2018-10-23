/**
 * 
 */
package br.edu.uniopet.persistence.cliente;

import java.util.List;

import br.edu.uniopet.cliente.model.Cliente;
import br.edu.uniopet.persistence.pessoa.PessoaService;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public class ClienteService implements IClienteDAO {

	/**
	 * Instance variables
	 */

	private ClienteDAO clienteDAO;

	/**
	 * Default constructor
	 */

	public ClienteService() {
		// TODO Auto-generated constructor stub

		this.clienteDAO = new ClienteDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.cliente.IClienteDAO#create(br.edu.uniopet.cliente.
	 * vo.Cliente)
	 */
	@Override
	public void create(Cliente cliente) {
		// TODO Auto-generated method stub

		clienteDAO.create(cliente);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.cliente.IClienteDAO#recovery()
	 */
	@Override
	public List<Cliente> recovery() {
		// TODO Auto-generated method stub

		PessoaService pessoaService = new PessoaService();

		List<Cliente> clientes;

		clientes = clienteDAO.recovery();

		return clientes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.cliente.IClienteDAO#update(br.edu.uniopet.cliente.
	 * vo.Cliente)
	 */
	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub

		PessoaService pessoaService = new PessoaService();

		pessoaService.update(cliente);

		clienteDAO.update(cliente);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.cliente.IClienteDAO#delete(br.edu.uniopet.cliente.
	 * vo.Cliente)
	 */
	@Override
	public Boolean delete(Cliente cliente) {
		// TODO Auto-generated method stub
		Boolean flag = null;

		PessoaService pessoaService = new PessoaService();

		flag = clienteDAO.delete(cliente);

		if (flag == true) {
			flag = pessoaService.delete(cliente);
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.cliente.IClienteDAO#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub
		Integer idCliente = null;

		idCliente = clienteDAO.search();

		return idCliente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.cliente.IClienteDAO#search(br.edu.uniopet.cliente.
	 * vo.Cliente)
	 */
	@Override
	public void search(Cliente cliente) {
		// TODO Auto-generated method stub
		
		clienteDAO.search(cliente);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.cliente.IClienteDAO#search(java.lang.String)
	 */
	@Override
	public List<Cliente> search(String nome) {
		// TODO Auto-generated method stub
		
		return this.clienteDAO.search(nome);
	}

}
