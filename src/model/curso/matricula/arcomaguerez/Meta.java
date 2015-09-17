package model.curso.matricula.arcomaguerez;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="meta")
public class Meta implements Serializable{
	
	public int id;
	
	public Diagnostico diagnostico;
	public String textoMeta;
	
	List<Intervencao> intervencoes;
	
	public Meta(){}

	public Meta(int id, Diagnostico diagnostico, String textoMeta) {
		super();
		this.id = id;
		this.diagnostico = diagnostico;
		this.textoMeta = textoMeta;
	}

	public Meta(Diagnostico diagnostico, String textoMeta) {
		super();
		this.diagnostico = diagnostico;
		this.textoMeta = textoMeta;
	}

	public Meta(int id) {
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

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idDiagnostico",nullable=false)
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Column(name="textoMeta", nullable=false, columnDefinition="TEXT")
	public String getTextoMeta() {
		return textoMeta;
	}


	public void setTextoMeta(String textoMeta) {
		this.textoMeta = textoMeta;
	}
	
	@Transient
	public String getTextoMetaResumido(){
		String retorno = "";
		if(getTextoMeta() != null && getTextoMeta().length() > 45){
			retorno = getTextoMeta().substring(0, 45)+"...";
		}else{
			retorno = getTextoMeta();
		}
		return retorno;
	}

	@OneToMany(mappedBy = "meta", targetEntity = Intervencao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Intervencao> getIntervencoes() {
		return intervencoes;
	}

	public void setIntervencoes(List<Intervencao> intervencoes) {
		this.intervencoes = intervencoes;
	}

}
