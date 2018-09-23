/**
 * 
 */
package br.edu.uniopet.persistence.pessoa;

import java.util.List;

import br.edu.uniopet.pessoa.vo.Pessoa;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public interface IPessoaDAO {
	
	public void create(Pessoa pessoa);
	
	public List<Pessoa> recovery();
	
	public void update(Pessoa pessoa);
	
	public Boolean delete(Pessoa pessoa);
	
	public Integer search();
	
	public void search(Pessoa pessoa);
	
	public List<Pessoa> search(String nome);

}
