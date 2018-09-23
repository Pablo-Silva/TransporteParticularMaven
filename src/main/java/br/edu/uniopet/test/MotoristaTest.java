/**
 * 
 */
package br.edu.uniopet.test;

import br.edu.uniopet.Reader;
import br.edu.uniopet.persistence.motorista.MotoristaService;
import br.edu.uniopet.vo.motorista.Motorista;

/**
 * @author Shooting Stars
 *
 */
public class MotoristaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Motorista motorista = new Motorista();

		MotoristaService motoristaService = new MotoristaService();

		motorista.setPrimeiroNome("João");

		motorista.setSobreNome("Da Silva");

		try {
			motorista.setDataNascimento(Reader.converterStringToDate("15/12/1982"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		motorista.setSexo(new Character('M'));

		motorista.setCPF("123.456.789-88");

		motorista.setNumeroCelular("998989797");

		motorista.setEmail("joao@gmail.com");
		
		try {
			motorista.setDataCadastro(Reader.converterStringToDate("15/12/1982"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		motorista.setStatusMotorista(new Character('A'));
		
		motorista.setCarteiraMotorista("46061554699");
		
		motoristaService.create(motorista);
		
		System.out.println(motorista.toString());

	}

}
