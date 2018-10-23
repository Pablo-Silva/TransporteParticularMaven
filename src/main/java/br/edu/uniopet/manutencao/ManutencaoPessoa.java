/**
 * 
 */
package br.edu.uniopet.manutencao;

import java.util.List;

import br.edu.uniopet.persistence.pessoa.PessoaService;
import br.edu.uniopet.pessoa.model.Pessoa;

/**
 * @author Shooting Stars
 *
 */
public class ManutencaoPessoa {

	/**
	 * Instance variables
	 */

	private PessoaService pessoaService;

	/**
	 * Default constructor
	 */

	public ManutencaoPessoa() {
		// TODO Auto-generated constructor stub

		pessoaService = new PessoaService();
	}

	/**
	 * Class operations
	 */

	public void create(Pessoa pessoa) {

		pessoaService.create(pessoa);
	}

	public List<Pessoa> list() {

		return pessoaService.recovery();
	}

	public void update(Pessoa pessoa) {

		pessoaService.update(pessoa);
	}

	public Boolean delete(Pessoa pessoa) {

		return pessoaService.delete(pessoa);
	}

	public void search(Pessoa pessoa) {

		pessoaService.search(pessoa);
	}

	public List<Pessoa> search(String nome) {

		return pessoaService.search(nome);
	}

}
