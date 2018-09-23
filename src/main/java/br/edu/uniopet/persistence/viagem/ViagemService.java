/**
 * 
 */
package br.edu.uniopet.persistence.viagem;

import java.util.List;

import br.edu.uniopet.viagem.vo.Viagem;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public class ViagemService implements IViagemDAO {

	/**
	 * Instance variables
	 */

	private ViagemDAO viagemDAO;

	/**
	 * Default constructor
	 */

	public ViagemService() {
		// TODO Auto-generated constructor stub

		this.viagemDAO = new ViagemDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#create(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public void create(Viagem viagem) {
		// TODO Auto-generated method stub

		viagemDAO.create(viagem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.viagem.IViagemDAO#recovery()
	 */
	@Override
	public List<Viagem> recovery() {
		// TODO Auto-generated method stub

		List<Viagem> viagens;

		viagens = viagemDAO.recovery();

		return viagens;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#update(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public void update(Viagem viagem) {
		// TODO Auto-generated method stub

		viagemDAO.update(viagem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#delete(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public Boolean delete(Viagem viagem) {
		// TODO Auto-generated method stub

		// Variables declaration

		Boolean flag = null;

		// Data processing

		flag = viagemDAO.delete(viagem);

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.viagem.IViagemDAO#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub
		
		// Variables declaration

				Integer idViagem = null;

				idViagem = viagemDAO.search();

				return idViagem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.viagem.IViagemDAO#search(br.edu.uniopet.viagem.vo.
	 * Viagem)
	 */
	@Override
	public void search(Viagem viagem) {
		// TODO Auto-generated method stub
		
		viagemDAO.search(viagem);

		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.viagem.IViagemDAO#search(java.lang.String)
	 */
	@Override
	public List<Viagem> search(String endereco) {
		// TODO Auto-generated method stub
		
		return this.viagemDAO.search(endereco);
	}

}
