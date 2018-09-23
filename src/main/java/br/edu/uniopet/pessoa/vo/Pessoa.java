package br.edu.uniopet.pessoa.vo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */

/**
 * Class to represent a Pessoa
 * 
 * @author Pablo
 * 
 * @since 18/06/2018
 * 
 * @version 1.0
 *
 */
public class Pessoa implements Serializable, Cloneable {

	/**
	 * Generate serial version ID
	 */
	private static final long serialVersionUID = -7058067948909869260L;

	/**
	 * Instance variables
	 */

	private Integer idPessoa;

	private String primeiroNome;

	private String sobreNome;

	private Date dataNascimento;

	private Character sexo;

	private String CPF;

	private String numeroCelular;

	private String email;

	/**
	 * Access methods
	 */

	/**
	 * @return the idPessoa
	 */
	public Integer getIdPessoa() {
		return idPessoa;
	}

	/**
	 * @param idPessoa
	 *            the idPessoa to set
	 */
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	/**
	 * @return the primeiroNome
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	/**
	 * @param primeiroNome
	 *            the primeiroNome to set
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	/**
	 * @return the sobreNome
	 */
	public String getSobreNome() {
		return sobreNome;
	}

	/**
	 * @param sobreNome
	 *            the sobreNome to set
	 */
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the sexo
	 */
	public Character getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the cPF
	 */
	public String getCPF() {
		return CPF;
	}

	/**
	 * @param cPF
	 *            the cPF to set
	 */
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	/**
	 * @return the numeroCelular
	 */
	public String getNumeroCelular() {
		return numeroCelular;
	}

	/**
	 * @param numeroCelular
	 *            the numeroCelular to set
	 */
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Default constructor
	 */

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Class operation
	 */

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

		output = String.format("\n ID: %s", idPessoa != null ? idPessoa.toString() : "");

		output = String.format("\n Nome: %s", primeiroNome != null ? primeiroNome : "");

		output = String.format("\n Sobre Nome: %s", sobreNome != null ? sobreNome : "");

		output = String.format("\n Data de Nascimento: %s",
				dataNascimento != null ? new SimpleDateFormat("dd/MM/yyyy").format(this.dataNascimento) : "");

		output = String.format("\n Sexo: %s", sexo != null ? (this.sexo.equals('M') ? "Masculino" : "Feminino") : "");

		output = String.format("\n CPF: %s", CPF != null ? CPF : "");

		output = String.format("\n Número Celular: %s", numeroCelular != null ? numeroCelular : "");

		output = String.format("\n Email: %s", email != null ? email : "");

		// Information output

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
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
		result = prime * result + ((primeiroNome == null) ? 0 : primeiroNome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((sobreNome == null) ? 0 : sobreNome.hashCode());
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (CPF == null) {
			if (other.CPF != null) {
				return false;
			}
		} else if (!CPF.equals(other.CPF)) {
			return false;
		}
		if (dataNascimento == null) {
			if (other.dataNascimento != null) {
				return false;
			}
		} else if (!dataNascimento.equals(other.dataNascimento)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (idPessoa == null) {
			if (other.idPessoa != null) {
				return false;
			}
		} else if (!idPessoa.equals(other.idPessoa)) {
			return false;
		}
		if (numeroCelular == null) {
			if (other.numeroCelular != null) {
				return false;
			}
		} else if (!numeroCelular.equals(other.numeroCelular)) {
			return false;
		}
		if (primeiroNome == null) {
			if (other.primeiroNome != null) {
				return false;
			}
		} else if (!primeiroNome.equals(other.primeiroNome)) {
			return false;
		}
		if (sexo == null) {
			if (other.sexo != null) {
				return false;
			}
		} else if (!sexo.equals(other.sexo)) {
			return false;
		}
		if (sobreNome == null) {
			if (other.sobreNome != null) {
				return false;
			}
		} else if (!sobreNome.equals(other.sobreNome)) {
			return false;
		}
		return true;
	}

}
