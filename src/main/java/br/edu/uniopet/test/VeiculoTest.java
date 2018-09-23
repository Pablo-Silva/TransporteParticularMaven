/**
 * 
 */
package br.edu.uniopet.test;

import br.edu.uniopet.persistence.veiculo.VeiculoService;
import br.edu.uniopet.veiculo.vo.Veiculo;

/**
 * @author Pablo
 * 
 * @since 22/06/2018
 * 
 * @version 1.0
 *
 */
public class VeiculoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Veiculo veiculo = new Veiculo();
		
		VeiculoService veiculoService = new VeiculoService();
		
		veiculo.setPlacaVeiculo("ashe123");
		
		veiculo.setModeloVeiculo("GOL");
		
		veiculo.setMarcaVeiculo("Volkis");
		
		veiculo.setCorVeiculo("Vermelho");
		
		veiculo.setAcentosVeiculos(new Integer(4));
		
		veiculoService.create(veiculo);
		
		System.out.println(veiculo.toString());

	}

}
