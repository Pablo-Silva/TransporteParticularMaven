package br.edu.uniopet.vo.motorista;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.uniopet.pessoa.vo.Pessoa;

/**
 * 
 */

/**
 * Class to represent a Motorista
 * 
 * @author Pablo
 * 
 * @since 18/06/2018
 * 
 * @version 1.0
 *
 */
public class Motorista extends Pessoa implements Serializable {

	/**
	 * Generate serial version ID
	 */
	private static final long serialVersionUID = -1151635793276869253L;

	/**
	 * Instance variables
	 */

	private Integer idMotorista;

	private Date dataCadastro;

	private Character statusMotorista;

	private String carteiraMotorista;

	/**
	 * Access methods
	 */

	/**
	 * @return the idMotorista
	 */
	public Integer getIdMotorista() {
		return idMotorista;
	}

	/**
	 * @param idMotorista
	 *            the idMotorista to set
	 */
	public void setIdMotorista(Integer idMotorista) {
		this.idMotorista = idMotorista;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro
	 *            the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the statusMotorista
	 */
	public Character getStatusMotorista() {
		return statusMotorista;
	}

	/**
	 * @param statusMotorista
	 *            the statusMotorista to set
	 */
	public void setStatusMotorista(Character statusMotorista) {
		this.statusMotorista = statusMotorista;
	}

	/**
	 * @return the carteiraMotorista
	 */
	public String getCarteiraMotorista() {
		return carteiraMotorista;
	}

	/**
	 * @param carteiraMotorista
	 *            the carteiraMotorista to set
	 */
	public void setCarteiraMotorista(String carteiraMotorista) {
		this.carteiraMotorista = carteiraMotorista;
	}

	/**
	 * Default constructor
	 */

	public Motorista() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Class operation
	 */
	
	public void validarCarteiraMotorista() {
		
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

		output = String.format("\n ID Motorista: %s", idMotorista != null ? idMotorista.toString() : "");

		output += String.format("\n Data de Cadastro: %s",
				dataCadastro != null ? new SimpleDateFormat("dd/MM/yyyy").format(this.dataCadastro) : "");

		output += String.format("\n Status: %s",
				statusMotorista != null ? (statusMotorista.equals('A') ? "Ativo" : "Inativo") : "");
		
		output += String.format("\n CNH: %s", carteiraMotorista != null ? carteiraMotorista : "");

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
		result = prime * result + ((carteiraMotorista == null) ? 0 : carteiraMotorista.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((idMotorista == null) ? 0 : idMotorista.hashCode());
		result = prime * result + ((statusMotorista == null) ? 0 : statusMotorista.hashCode());
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
		if (!(obj instanceof Motorista)) {
			return false;
		}
		Motorista other = (Motorista) obj;
		if (carteiraMotorista == null) {
			if (other.carteiraMotorista != null) {
				return false;
			}
		} else if (!carteiraMotorista.equals(other.carteiraMotorista)) {
			return false;
		}
		if (dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (idMotorista == null) {
			if (other.idMotorista != null) {
				return false;
			}
		} else if (!idMotorista.equals(other.idMotorista)) {
			return false;
		}
		if (statusMotorista == null) {
			if (other.statusMotorista != null) {
				return false;
			}
		} else if (!statusMotorista.equals(other.statusMotorista)) {
			return false;
		}
		return true;
	}

}
