package modelo;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	@Embedded
	private Endereco endereço;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Endereco getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereco endereço) {
		this.endereço = endereço;
	}
	

}
