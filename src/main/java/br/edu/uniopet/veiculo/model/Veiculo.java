/**
 * 
 */
package br.edu.uniopet.veiculo.model;

import java.io.Serializable;

/**
 * Class representing a vehicle of a driving entity.
 * 
 * @author Pablo
 * 
 * @since 18/06/2018
 * 
 * @version 1.0
 *
 */
public class Veiculo implements Serializable {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 7858251752390921671L;
	
	/**
	 * Instance variables
	 */
	
	private Integer idVeiculo;
	
	private Integer idMotorista;
	
	private String placaVeiculo;
	
	private String modeloVeiculo;
	
	private String marcaVeiculo;
	
	private String corVeiculo;
	
	private Integer acentosVeiculos;
	
	/**
	 * Access methods
	 */

	/**
	 * @return the idVeiculo
	 */
	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	/**
	 * @param idVeiculo the idVeiculo to set
	 */
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	/**
	 * @return the idMotorista
	 */
	public Integer getIdMotorista() {
		return idMotorista;
	}

	/**
	 * @param idMotorista the idMotorista to set
	 */
	public void setIdMotorista(Integer idMotorista) {
		this.idMotorista = idMotorista;
	}

	/**
	 * @return the placaVeiculo
	 */
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	/**
	 * @param placaVeiculo the placaVeiculo to set
	 */
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	/**
	 * @return the modeloVeiculo
	 */
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	/**
	 * @param modeloVeiculo the modeloVeiculo to set
	 */
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	/**
	 * @return the marcaVeiculo
	 */
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	/**
	 * @param marcaVeiculo the marcaVeiculo to set
	 */
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	/**
	 * @return the corVeiculo
	 */
	public String getCorVeiculo() {
		return corVeiculo;
	}

	/**
	 * @param corVeiculo the corVeiculo to set
	 */
	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	/**
	 * @return the acentosVeiculos
	 */
	public Integer getAcentosVeiculos() {
		return acentosVeiculos;
	}

	/**
	 * @param acentosVeiculos the acentosVeiculos to set
	 */
	public void setAcentosVeiculos(Integer acentosVeiculos) {
		this.acentosVeiculos = acentosVeiculos;
	}
	
	/**
	 * Default constructor
	 */
	
	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Class operation
	 */

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		// Variables declaration
		
		String output = null;
		
		// Data processing
		
		output = String.format("\n ID Veículo: %s", idVeiculo != null ? idVeiculo.toString() : "");
		
		output += String.format("\n ID Motorista: %s", idMotorista != null ? idMotorista.toString() : "");

		output += String.format("\n Placa: %s", placaVeiculo != null ? placaVeiculo : "");
		
		output += String.format("\n Modelo: %s", modeloVeiculo != null ? modeloVeiculo : "");
		
		output += String.format("\n Marca: %s", marcaVeiculo != null ? marcaVeiculo : "");
		
		output += String.format("\n Cor: %s", corVeiculo != null ? corVeiculo : "");
		
		output += String.format("\n Acentos: %s", acentosVeiculos != null ? acentosVeiculos : "");
		
		// Information output
		
		return output;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acentosVeiculos == null) ? 0 : acentosVeiculos.hashCode());
		result = prime * result + ((corVeiculo == null) ? 0 : corVeiculo.hashCode());
		result = prime * result + ((idMotorista == null) ? 0 : idMotorista.hashCode());
		result = prime * result + ((idVeiculo == null) ? 0 : idVeiculo.hashCode());
		result = prime * result + ((marcaVeiculo == null) ? 0 : marcaVeiculo.hashCode());
		result = prime * result + ((modeloVeiculo == null) ? 0 : modeloVeiculo.hashCode());
		result = prime * result + ((placaVeiculo == null) ? 0 : placaVeiculo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Veiculo)) {
			return false;
		}
		Veiculo other = (Veiculo) obj;
		if (acentosVeiculos == null) {
			if (other.acentosVeiculos != null) {
				return false;
			}
		} else if (!acentosVeiculos.equals(other.acentosVeiculos)) {
			return false;
		}
		if (corVeiculo == null) {
			if (other.corVeiculo != null) {
				return false;
			}
		} else if (!corVeiculo.equals(other.corVeiculo)) {
			return false;
		}
		if (idMotorista == null) {
			if (other.idMotorista != null) {
				return false;
			}
		} else if (!idMotorista.equals(other.idMotorista)) {
			return false;
		}
		if (idVeiculo == null) {
			if (other.idVeiculo != null) {
				return false;
			}
		} else if (!idVeiculo.equals(other.idVeiculo)) {
			return false;
		}
		if (marcaVeiculo == null) {
			if (other.marcaVeiculo != null) {
				return false;
			}
		} else if (!marcaVeiculo.equals(other.marcaVeiculo)) {
			return false;
		}
		if (modeloVeiculo == null) {
			if (other.modeloVeiculo != null) {
				return false;
			}
		} else if (!modeloVeiculo.equals(other.modeloVeiculo)) {
			return false;
		}
		if (placaVeiculo == null) {
			if (other.placaVeiculo != null) {
				return false;
			}
		} else if (!placaVeiculo.equals(other.placaVeiculo)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	

}
