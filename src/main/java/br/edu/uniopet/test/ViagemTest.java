/**
 * 
 */
package br.edu.uniopet.test;

import br.edu.uniopet.Reader;
import br.edu.uniopet.persistence.viagem.ViagemService;
import br.edu.uniopet.viagem.vo.Viagem;

/**
 * @author Shooting Stars
 *
 */
public class ViagemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Viagem viagem = new Viagem();
		
		ViagemService viagemService = new ViagemService();
		
		viagem.setEnderecoSaida("Rua Teste 123");
		
		viagem.setEnderecoChegada("Rua Teste 321");
		
		try {
			viagem.setDataInicio(Reader.converterStringToDate("24/06/2018"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			viagem.setDataFim(Reader.converterStringToDate("24/06/2018"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viagemService.create(viagem);
		
		System.out.println(viagem.toString());

	}

}
