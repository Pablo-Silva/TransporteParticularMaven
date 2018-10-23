package br.edu.uniopet.cliente.model;
import java.io.Serializable;

import javax.persistence.*;

import br.edu.uniopet.pessoa.model.Pessoa;

/**
 * 
 */

/**
 * Class to represent a Cliente
 * 
 * @author Pablo
 * 
 * @since 18/06/2018
 * 
 * @version 1.0
 *
 */

@Entity
public class Cliente extends Pessoa implements Serializable {

	/**
	 * Generate serial version ID
	 */
	private static final long serialVersionUID = 1051146897583809889L;

	/**
	 * Instance variables
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "CLIENTE_SEQUENCE")
	@Column(name = "ID_CLIENTE")
	private Integer idCliente;

	@OneToOne
	@JoinColumn(name = "ID_PESSOA" , referencedColumnName = "ID_PESSOA")
	private Pessoa pessoa;

	private String bandeiraCartao;

	private Integer numeroCartao;

	/**
	 * Access methods
	 */

	/**
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente
	 *            the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the bandeiraCartao
	 */
	public String getBandeiraCartao() {
		return bandeiraCartao;
	}

	/**
	 * @param bandeiraCartao
	 *            the bandeiraCartao to set
	 */
	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	/**
	 * @return the numeroCartao
	 */
	public Integer getNumeroCartao() {
		return numeroCartao;
	}

	/**
	 * @param numeroCartao
	 *            the numeroCartao to set
	 */
	public void setNumeroCartao(Integer numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * Default constructor
	 */

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Class operation
	 */
	
	public void validarBandeiraCartao() {
		
	}
	
	public void validarNumeroCartao() {
		
	}
	
	public void pagamentoCartao() {
		
	}
	
	public void pagamentoDinheiro() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		// Variables declaration

		String output = null;

		// Data processing

		output = String.format("\n ID Cliente: %s", idCliente != null ? idCliente.toString() : "");

		output += String.format("\n Bandeira Cartão: %s", bandeiraCartao != null ? bandeiraCartao : "");

		output += String.format("\n Número Cartão: %s", numeroCartao != null ? numeroCartao.toString() : "");

		return output;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bandeiraCartao == null) ? 0 : bandeiraCartao.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (bandeiraCartao == null) {
			if (other.bandeiraCartao != null) {
				return false;
			}
		} else if (!bandeiraCartao.equals(other.bandeiraCartao)) {
			return false;
		}
		if (idCliente == null) {
			if (other.idCliente != null) {
				return false;
			}
		} else if (!idCliente.equals(other.idCliente)) {
			return false;
		}
		if (numeroCartao == null) {
			if (other.numeroCartao != null) {
				return false;
			}
		} else if (!numeroCartao.equals(other.numeroCartao)) {
			return false;
		}
		return true;
	}

}
