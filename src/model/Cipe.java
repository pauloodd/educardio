package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cipe")
public class Cipe implements Serializable{
	
	public int id;
	public int codigo;
	public String termo;
	public String descricao;
	public String eixo;
	public String versao;
	
	
	public Cipe(int id, int codigo, String termo, String descricao,
			String eixo, String versao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.termo = termo;
		this.descricao = descricao;
		this.eixo = eixo;
		this.versao = versao;
	}

	public Cipe(int codigo, String termo, String descricao, String eixo,
			String versao) {
		super();
		this.codigo = codigo;
		this.termo = termo;
		this.descricao = descricao;
		this.eixo = eixo;
		this.versao = versao;
	}

	public Cipe(){}
	
	public Cipe(int id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="descricao_conceito",columnDefinition="TEXT")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name="codigo")
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Column(name="termo", length=100)
	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

	@Column(name="eixo", length=50)
	public String getEixo() {
		return eixo;
	}

	public void setEixo(String eixo) {
		this.eixo = eixo;
	}

	@Column(name="versao", length=10)
	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	@Transient
	public String getTermoTruncado() {
		return termo.replaceAll("\r\n", "");
	}
	
	@Transient
	public String getDescricaoTruncado() {
		return descricao.replaceAll("\r\n", "");
	}
	
	
}
