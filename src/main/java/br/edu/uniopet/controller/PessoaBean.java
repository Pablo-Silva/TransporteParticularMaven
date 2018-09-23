/**
 * 
 */
package br.edu.uniopet.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.uniopet.cliente.vo.Cliente;
import br.edu.uniopet.model.ManutencaoPessoa;
import br.edu.uniopet.pessoa.vo.Pessoa;

import java.io.Serializable;
import java.util.List;

/**
 * @author Shooting Stars
 *
 */

@Named("pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -2462273276974957686L;

	/**
	 * Instance variables
	 */

	private Pessoa pessoa;

	private String caption;

	private List<Pessoa> pessoas;

	private ManutencaoPessoa manutencaoPessoa;

	/**
	 * Default constructor
	 */

	public PessoaBean() {
		// TODO Auto-generated constructor stub

		pessoa = new Pessoa();

		manutencaoPessoa = new ManutencaoPessoa();
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
	 * @return the pessoas
	 */
	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	/**
	 * Class operations
	 */

	public String create() {

		// Variables declaration

		FacesContext context = FacesContext.getCurrentInstance();

		// Data processing

		if (this.pessoa.getIdPessoa() == null) {

			manutencaoPessoa.create(this.pessoa);

			if (this.pessoa != null) {

				this.caption = "Dados Cadastros com Sucesso";

			} else {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível salvar os dados.", ""));
			}

		} else {

			manutencaoPessoa.update(this.pessoa);

			if (this.pessoa != null) {

				this.caption = "Dados Atualizados com Sucesso";

			} else {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível atualizar os dados.", ""));
			}
		}

		// Information output

		if (this.pessoa != null) {

			this.pessoa = null;

			return "mostrarPessoa";

		} else {

			return null;
		}
	}

	public String list() {

		// Data processing

		this.pessoas = manutencaoPessoa.list();

		// Information output

		return "/pages/consulta/consultarpessoa";
	}

	public String delete() {

		// Variables declaration

		FacesContext context = FacesContext.getCurrentInstance();

		Boolean flag = null;

		// Data processing

		flag = manutencaoPessoa.delete(this.pessoa);

		if (flag != null && flag.equals(true)) {

			this.pessoas = manutencaoPessoa.list();

		} else {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Não foi possível excluir os dados da pessoa Código # " + pessoa.getIdPessoa(), ""));
		}

		// Information output

		return null;
	}

	public String search(String nome) {

		// Data processing

		this.pessoas = manutencaoPessoa.search(nome);

		return "/pages/consulta/consultar";
	}

	public String novel() {

		this.pessoa = new Cliente();

		this.pessoas = null;

		return "/pages/homepage";

	}

}
