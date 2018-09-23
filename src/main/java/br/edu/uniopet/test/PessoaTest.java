/**
 * 
 */
package br.edu.uniopet.test;

import br.edu.uniopet.persistence.pessoa.PessoaService;
import br.edu.uniopet.pessoa.vo.Pessoa;

/**
 * @author Shooting Stars
 *
 */
public class PessoaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pessoa pessoa = new Pessoa();
		
		PessoaService pessoaService = new PessoaService();
		
		pessoaService.recovery();

	}

}
