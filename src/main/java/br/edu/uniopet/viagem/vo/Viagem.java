/**
 * 
 */
package br.edu.uniopet.viagem.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class representing a trip from a customer and a driver
 * 
 * @author Pablo
 * 
 * @since 18/06/2018
 * 
 * @version 1.0
 *
 */
public class Viagem implements Serializable {
	
	/**
	 * Generate serial version ID
	 */
	private static final long serialVersionUID = 3409345885391204760L;
	
	/**
	 * Instance variables
	 */

	private Integer idViagem;
	
	private Integer idCliente;
	
	private Integer idMotorista;
	
	private Integer idVeiculo;
	
	private String enderecoSaida;
	
	private String enderecoChegada;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	/**
	 * Access methods
	 */

	/**
	 * @return the idViagem
	 */
	public Integer getIdViagem() {
		return idViagem;
	}

	/**
	 * @param idViagem the idViagem to set
	 */
	public void setIdViagem(Integer idViagem) {
		this.idViagem = idViagem;
	}

	/**
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	 * @return the enderecoSaida
	 */
	public String getEnderecoSaida() {
		return enderecoSaida;
	}

	/**
	 * @param enderecoSaida the enderecoSaida to set
	 */
	public void setEnderecoSaida(String enderecoSaida) {
		this.enderecoSaida = enderecoSaida;
	}

	/**
	 * @return the enderecoChegada
	 */
	public String getEnderecoChegada() {
		return enderecoChegada;
	}

	/**
	 * @param enderecoChegada the enderecoChegada to set
	 */
	public void setEnderecoChegada(String enderecoChegada) {
		this.enderecoChegada = enderecoChegada;
	}

	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataFim
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim the dataFim to set
	 */
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	/**
	 * Default constructor
	 */
	
	public Viagem() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Class operation
	 */
	
	public void calcularValorViagem() {
		
	}
	
	public void informarDestino(String enderecoSaida, String enderecoChegada) {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		//Variables declaration
		
		String output = null;
		
		//Data processing
		
		output = String.format("\n ID Viagem: %s", idViagem != null ? idViagem.toString() : "");
		
		output += String.format("\n ID Cliente: %s", idCliente != null ? idCliente.toString() : "");
		
		output += String.format("\n ID Motorista: %s", idMotorista != null ? idMotorista.toString() : "");
		
		output = String.format("\n ID Veiculo: %s", idVeiculo != null ? idVeiculo.toString() : "");
		
		output += String.format("\n Endereço Saida: %s", enderecoSaida != null ? enderecoSaida : "");
		
		output += String.format("\n Endereço Chegada: %s", enderecoChegada != null ? enderecoChegada : "");

		output += String.format("\n Data Inicio: %s",
				dataInicio != null ? new SimpleDateFormat("dd/MM/yyyy").format(this.dataInicio) : "");
		
		output += String.format("\n Data Fim: %s",
				dataFim != null ? new SimpleDateFormat("dd/MM/yyyy").format(this.dataFim) : "");
		
	
		//Information output
		
		return output;
		
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((enderecoChegada == null) ? 0 : enderecoChegada.hashCode());
		result = prime * result + ((enderecoSaida == null) ? 0 : enderecoSaida.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idMotorista == null) ? 0 : idMotorista.hashCode());
		result = prime * result + ((idVeiculo == null) ? 0 : idVeiculo.hashCode());
		result = prime * result + ((idViagem == null) ? 0 : idViagem.hashCode());
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
		if (!(obj instanceof Viagem)) {
			return false;
		}
		Viagem other = (Viagem) obj;
		if (dataFim == null) {
			if (other.dataFim != null) {
				return false;
			}
		} else if (!dataFim.equals(other.dataFim)) {
			return false;
		}
		if (dataInicio == null) {
			if (other.dataInicio != null) {
				return false;
			}
		} else if (!dataInicio.equals(other.dataInicio)) {
			return false;
		}
		if (enderecoChegada == null) {
			if (other.enderecoChegada != null) {
				return false;
			}
		} else if (!enderecoChegada.equals(other.enderecoChegada)) {
			return false;
		}
		if (enderecoSaida == null) {
			if (other.enderecoSaida != null) {
				return false;
			}
		} else if (!enderecoSaida.equals(other.enderecoSaida)) {
			return false;
		}
		if (idCliente == null) {
			if (other.idCliente != null) {
				return false;
			}
		} else if (!idCliente.equals(other.idCliente)) {
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
		if (idViagem == null) {
			if (other.idViagem != null) {
				return false;
			}
		} else if (!idViagem.equals(other.idViagem)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	

}
