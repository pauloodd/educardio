package model.sistema;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivo")
public class Arquivo implements Serializable{

	public int id;
	public String extensao;
	public String nomeArqv;
	public byte[] dadosArqv;

	public Arquivo(){}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="extensao", nullable=false)
	public String getExtensao() {
		return extensao;
	}


	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	@Column(name="nomeArqv", nullable=false)
	public String getNomeArqv() {
		return nomeArqv;
	}


	public void setNomeArqv(String nomeArqv) {
		this.nomeArqv = nomeArqv;
	}

	@Column(name="dadosArqv", nullable=false, columnDefinition="LONGBLOB")
	public byte[] getDadosArqv() {
		return dadosArqv;
	}


	public void setDadosArqv(byte[] dataHora) {
		this.dadosArqv = dataHora;
	}
	
	

}
