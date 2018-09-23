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
public class PessoaService implements IPessoaDAO {
	
	/**
	 * Instance variables
	 */
	
	private PessoaDAO pessoaDAO;
	
	/**
	 * Default constructor
	 */
	
	public PessoaService() {
		// TODO Auto-generated constructor stub
		
		this.pessoaDAO = new PessoaDAO();
	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#create(br.edu.uniopet.pessoa.vo.Pessoa)
	 */
	@Override
	public void create(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
		pessoaDAO.create(pessoa);

	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#recovery()
	 */
	@Override
	public List<Pessoa> recovery() {
		// TODO Auto-generated method stub
		
		List<Pessoa> pessoas;
		
		pessoas = pessoaDAO.recovery();
		
		return pessoas;
	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#update(br.edu.uniopet.pessoa.vo.Pessoa)
	 */
	@Override
	public void update(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
		pessoaDAO.update(pessoa);

	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#delete(br.edu.uniopet.pessoa.vo.Pessoa)
	 */
	@Override
	public Boolean delete(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
		// Variables declaration
		
		Boolean flag = null;
		
		// Data processing
		
		flag = pessoaDAO.delete(pessoa);
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub
		
		// Variables declaration
		
		Integer idPessoa = null;
		
		idPessoa = pessoaDAO.search();
		
		return idPessoa;
	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#search(br.edu.uniopet.pessoa.vo.Pessoa)
	 */
	@Override
	public void search(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
		pessoaDAO.search(pessoa);

	}

	/* (non-Javadoc)
	 * @see br.edu.uniopet.persistence.pessoa.IPessoa#search(java.lang.String)
	 */
	@Override
	public List<Pessoa> search(String nome) {
		// TODO Auto-generated method stub
		return this.pessoaDAO.search(nome);
	}

}
