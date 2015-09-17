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

import model.Cipe;
import model.curso.DeterminanteHipoteses;

@Entity
@Table(name="diagnostico")
public class Diagnostico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int id;
	
	public Cipe cipe;
	public String textoComplementar;
	public DeterminanteHipoteses determinante;
	public HipotesesDeSolucao hipotesesDeSolucao;

	public List<Meta> metas;
	
	public Diagnostico(){}
	
	public Diagnostico(int id) {
		super();
		this.id = id;
	}

	public Diagnostico(Cipe cipe, String textoComplementar,
			DeterminanteHipoteses determinante, HipotesesDeSolucao hipotesesDeSolucao) {
		super();
		this.cipe = cipe;
		this.textoComplementar = textoComplementar;
		this.determinante = determinante;
		this.hipotesesDeSolucao = hipotesesDeSolucao;
	}
	
	public Diagnostico(Cipe cipe, String textoComplementar,
			DeterminanteHipoteses determinante) {
		super();
		this.cipe = cipe;
		this.textoComplementar = textoComplementar;
		this.determinante = determinante;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idCipe",nullable=true)
	public Cipe getCipe() {
		return cipe;
	}

	public void setCipe(Cipe cipe) {
		this.cipe = cipe;
	}

	@Column(name="textoComplementar", nullable=true, columnDefinition="TEXT")
	public String getTextoComplementar() {
		return textoComplementar;
	}

	public void setTextoComplementar(String textoComplementar) {
		this.textoComplementar = textoComplementar;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idDeterminante",nullable=true)
	public DeterminanteHipoteses getDeterminante() {
		return determinante;
	}

	public void setDeterminante(DeterminanteHipoteses determinante) {
		this.determinante = determinante;
	}
	
	@Transient
	public String getTextoComplementarResumido(){
		String retorno = "";
		if(getTextoComplementar() != null && getTextoComplementar().length() > 45){
			retorno = getTextoComplementar().substring(0, 45)+"...";
		}else{
			retorno = getTextoComplementar();
		}
		return retorno;
	}

	@OneToMany(mappedBy = "diagnostico", targetEntity = Meta.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Meta> getMetas() {
		return metas;
	}

	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idHipotesesSolucao")
	public HipotesesDeSolucao getHipotesesDeSolucao() {
		return hipotesesDeSolucao;
	}

	public void setHipotesesDeSolucao(HipotesesDeSolucao hipotesesDeSolucao) {
		this.hipotesesDeSolucao = hipotesesDeSolucao;
	}
}
