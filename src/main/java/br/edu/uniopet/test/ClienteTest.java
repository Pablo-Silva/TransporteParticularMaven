/**
 * 
 */
package br.edu.uniopet.test;

import br.edu.uniopet.Reader;
import br.edu.uniopet.cliente.vo.Cliente;
import br.edu.uniopet.persistence.cliente.ClienteService;

/**
 * @author Pablo
 * 
 * @since 22/06/2018
 * 
 * @version 1.0
 *
 */
public class ClienteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		
		ClienteService clienteService = new ClienteService();
		
		cliente.setPrimeiroNome("João");
		
		cliente.setSobreNome("Da Silva");
		
		try {
			cliente.setDataNascimento(Reader.converterStringToDate("15/12/1982"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cliente.setSexo(new Character('M'));
		
		cliente.setCPF("123.456.789-88");
		
		cliente.setNumeroCelular("998989797");
		
		cliente.setEmail("joao@gmail.com");
		
		cliente.setBandeiraCartao("MasterCard");
		
		cliente.setNumeroCartao(1234567890);
		
		clienteService.create(cliente);
		
		System.out.println(cliente.toString());
		
		clienteService.recovery();

	}

}
