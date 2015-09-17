package model.curso.matricula.arcomaguerez;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.Cipe;

@Entity
@Table(name="intervencao")
public class Intervencao implements Serializable{
	
	public int id;
	
	public Meta meta;
	public Cipe cipe;
	public String textoComplementar;
	
	public Intervencao(){}

	
	public Intervencao(int id) {
		super();
		this.id = id;
	}


	public Intervencao(Meta meta, Cipe cipe, String textoComplementar) {
		super();
		this.meta = meta;
		this.cipe = cipe;
		this.textoComplementar = textoComplementar;
	}


	public Intervencao(int id, Meta meta, Cipe cipe, String textoComplementar) {
		super();
		this.id = id;
		this.meta = meta;
		this.cipe = cipe;
		this.textoComplementar = textoComplementar;
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

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idMeta",nullable=false)
	public Meta getMeta() {
		return meta;
	}


	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idCipe",nullable=false)
	public Cipe getCipe() {
		return cipe;
	}


	public void setCipe(Cipe cipe) {
		this.cipe = cipe;
	}

	@Column(name="textoComplementar", nullable=false, columnDefinition="TEXT")
	public String getTextoComplementar() {
		return textoComplementar;
	}


	public void setTextoComplementar(String textoComplementar) {
		this.textoComplementar = textoComplementar;
	}

	
	

}
