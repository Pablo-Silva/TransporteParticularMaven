/**
 * 
 */
package br.edu.uniopet.controller;

import java.util.List;
import br.edu.uniopet.model.ManutencaoPessoa;
import br.edu.uniopet.pessoa.vo.Pessoa;

/**
 * @author Shooting Stars
 *
 */
public class PessoaController {

	/**
	 * Instance variables
	 */

	private Pessoa pessoa;

	private List<Pessoa> pessoas;

	private ManutencaoPessoa manutencaoPessoa;

	/**
	 * Default constructor
	 */

	public PessoaController() {
		// TODO Auto-generated constructor stub

		this.pessoa = new Pessoa();

		this.manutencaoPessoa = new ManutencaoPessoa();
	}

	/**
	 * Access methods
	 */

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

	public void create() {

		if (this.pessoa != null
				&& (this.pessoa.getPrimeiroNome() != null && !this.pessoa.getPrimeiroNome().equals(""))) {

			manutencaoPessoa.create(this.pessoa);
		}
	}

	public List<Pessoa> list() {

		this.pessoas = this.manutencaoPessoa.list();

		return this.pessoas;
	}

	public void update() {

		if (this.pessoa != null
				&& (this.pessoa.getPrimeiroNome() != null && !this.pessoa.getPrimeiroNome().equals(""))) {

			this.manutencaoPessoa.update(this.pessoa);
		}
	}

	public Boolean delete() {

		return manutencaoPessoa.delete(this.pessoa);
	}

	public void search(Pessoa pessoa) {

		manutencaoPessoa.search(pessoa);
	}

	public List<Pessoa> search(String nome) {

		this.pessoas = manutencaoPessoa.search(nome);

		return this.pessoas;
	}

	public void novo() {

		this.pessoa = new Pessoa();
	}

}
