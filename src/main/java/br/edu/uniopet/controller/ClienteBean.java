/**
 * 
 */
package br.edu.uniopet.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.uniopet.cliente.model.Cliente;
import br.edu.uniopet.manutencao.ManutencaoCliente;

import java.io.Serializable;
import java.util.List;

/**
 * @author Shooting Stars
 *
 */
@Named("clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 8033892558556179285L;

	/**
	 * Instance variables
	 */

	private Cliente cliente;

	private String caption;

	private List<Cliente> clientes;

	private ManutencaoCliente manutencaoCliente;

	/**
	 * Default constructor
	 */

	public ClienteBean() {
		// TODO Auto-generated constructor stub

		cliente = new Cliente();

		manutencaoCliente = new ManutencaoCliente();
	}

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

	public List<Cliente> getClientes() {

		return this.clientes;
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption
	 *            the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * Class operations
	 */

	public String create() {

		// Variables declaration

		FacesContext context = FacesContext.getCurrentInstance();

		// Data processing

		if (this.cliente.getIdCliente() == null) {

			manutencaoCliente.create(this.cliente);

			if (this.cliente != null) {

				this.caption = "Dados Cadastros com Sucesso";

			} else {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível salvar os dados.", ""));
			}

		} else {

			manutencaoCliente.update(this.cliente);

			if (this.cliente != null) {

				this.caption = "Dados Atualizados com Sucesso";

			} else {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível atualizar os dados.", ""));
			}
		}

		// Information output

		if (this.cliente != null) {

			this.clientes = null;

			return "mostrarCliente";

		} else {

			return null;
		}
	}

	public String list() {

		// Data processing

		this.clientes = manutencaoCliente.list();

		// Information output

		return "/pages/consulta/consultar";
	}

	public String delete() {

		// Variables declaration

		FacesContext context = FacesContext.getCurrentInstance();

		Boolean flag = null;

		// Data processing

		flag = manutencaoCliente.delete(this.cliente);

		if (flag != null && flag.equals(true)) {

			this.clientes = manutencaoCliente.list();

		} else {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Não foi possível excluir os dados da pessoa Código # " + cliente.getIdCliente(), ""));
		}

		// Information output

		return null;
	}
	
	public String search(String nome) {

		// Data processing

		this.clientes = manutencaoCliente.search(nome);

		return "/pages/consulta/consultar";
	}

	public String novel() {

		this.cliente = new Cliente();

		this.clientes = null;

		return "/pages/homepage";
	}

}
