/**
 * 
 */
package br.edu.uniopet.persistence.motorista;

import java.util.List;

import br.edu.uniopet.persistence.pessoa.PessoaService;
import br.edu.uniopet.vo.motorista.Motorista;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public class MotoristaService implements IMotoristaDAO {

	/**
	 * Instance variables
	 */

	private MotoristaDAO motoristaDAO;

	/**
	 * Default constructor
	 */

	public MotoristaService() {
		// TODO Auto-generated constructor stub

		this.motoristaDAO = new MotoristaDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.motorista.IMotoristaDAO#create(br.edu.uniopet.
	 * motorista.vo.Motorista)
	 */
	@Override
	public void create(Motorista motorista) {
		// TODO Auto-generated method stub

		motoristaDAO.create(motorista);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.motorista.IMotoristaDAO#recovery()
	 */
	@Override
	public List<Motorista> recovery() {
		// TODO Auto-generated method stub

		// Variables declaration

		PessoaService pessoaService = new PessoaService();

		List<Motorista> motoristas;

		motoristas = motoristaDAO.recovery();

		return motoristas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.motorista.IMotoristaDAO#update(br.edu.uniopet.
	 * motorista.vo.Motorista)
	 */
	@Override
	public void update(Motorista motorista) {
		// TODO Auto-generated method stub

		PessoaService pessoaService = new PessoaService();

		pessoaService.update(motorista);

		motoristaDAO.update(motorista);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.motorista.IMotoristaDAO#delete(br.edu.uniopet.
	 * motorista.vo.Motorista)
	 */
	@Override
	public Boolean delete(Motorista motorista) {
		// TODO Auto-generated method stub
		Boolean flag = null;

		PessoaService pessoaService = new PessoaService();

		flag = motoristaDAO.delete(motorista);

		if (flag == true) {
			flag = pessoaService.delete(motorista);
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.motorista.IMotoristaDAO#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub
		Integer idMotorista = null;

		idMotorista = motoristaDAO.search();

		return idMotorista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.motorista.IMotoristaDAO#search(br.edu.uniopet.
	 * motorista.vo.Motorista)
	 */
	@Override
	public void search(Motorista motorista) {
		// TODO Auto-generated method stub
		
		motoristaDAO.search(motorista);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.motorista.IMotoristaDAO#search(java.lang.
	 * Character)
	 */
	@Override
	public List<Motorista> search(String nome) {
		// TODO Auto-generated method stub
		return this.motoristaDAO.search(nome);
	}

}
