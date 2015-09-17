package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
	
	public int id;
	public String descricao;
	public String numero;
	public String bairro;
	public String cep;
	public String estado;
	public String cidade;
	public String referencia;
	
	public Endereco(){}
	
	public Endereco(String descricao, String numero, String bairro, String cep, String cidade,
			String estado, String referencia) {
		this.descricao = descricao;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.referencia = referencia;
		this.cidade = cidade;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idEndereco", nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="descricao", nullable=false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name="numero", nullable=false)
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(name="bairro", nullable=false)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="cep", nullable=false)
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Column(name="estado", nullable=false)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name="cidade", nullable=false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="referencia", nullable=false)
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	
}
