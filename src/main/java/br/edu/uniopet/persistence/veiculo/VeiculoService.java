/**
 * 
 */
package br.edu.uniopet.persistence.veiculo;

import java.util.List;

import br.edu.uniopet.veiculo.vo.Veiculo;

/**
 * @author Pablo
 * 
 * @since 19/06/2018
 * 
 * @version 1.0
 *
 */
public class VeiculoService implements IVeiculoDAO {

	/**
	 * Instance variables
	 */

	private VeiculoDAO veiculoDAO;

	/**
	 * Default constructor
	 */

	public VeiculoService() {
		// TODO Auto-generated constructor stub

		this.veiculoDAO = new VeiculoDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#create(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public void create(Veiculo veiculo) {
		// TODO Auto-generated method stub

		veiculoDAO.create(veiculo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.veiculo.IVeiculoDAO#recovery()
	 */
	@Override
	public List<Veiculo> recovery() {
		// TODO Auto-generated method stub

		List<Veiculo> veiculos;

		veiculos = veiculoDAO.recovery();

		return veiculos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#update(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public void update(Veiculo veiculo) {
		// TODO Auto-generated method stub

		veiculoDAO.update(veiculo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#delete(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public Boolean delete(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
		// Variables declaration

		Boolean flag = null;

		// Data processing

		flag = veiculoDAO.delete(veiculo);

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.veiculo.IVeiculoDAO#search()
	 */
	@Override
	public Integer search() {
		// TODO Auto-generated method stub
		
		// Variables declaration

		Integer idVeiculo = null;

		idVeiculo = veiculoDAO.search();

		return idVeiculo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.uniopet.persistence.veiculo.IVeiculoDAO#search(br.edu.uniopet.veiculo.
	 * vo.Veiculo)
	 */
	@Override
	public void search(Veiculo veiculo) {
		// TODO Auto-generated method stub

		veiculoDAO.search(veiculo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.uniopet.persistence.veiculo.IVeiculoDAO#search(java.lang.String)
	 */
	@Override
	public List<Veiculo> search(String modeloVeiculo) {
		// TODO Auto-generated method stub
		return this.veiculoDAO.search(modeloVeiculo);
	}

}
