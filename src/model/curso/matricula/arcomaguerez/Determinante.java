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

@Entity
@Table(name="determinante")
public class Determinante implements Serializable{
	
	public int id;
	
	public String determinante;
	public String justificativa;
	public PontosChave pontosChave;
	
	public Determinante(){}

	
	public Determinante(String determinante, String justificativa,
			PontosChave pontosChave) {
		super();
		this.determinante = determinante;
		this.justificativa = justificativa;
		this.pontosChave = pontosChave;
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
	
	@Column(name="determinante", nullable=false)
	public String getDeterminante() {
		return determinante;
	}

	public void setDeterminante(String determinante) {
		this.determinante = determinante;
	}

	@Column(name="justificativa", nullable=false)
	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idPontosChave",nullable=false)
	public PontosChave getPontosChave() {
		return pontosChave;
	}

	public void setPontosChave(PontosChave pontosChave) {
		this.pontosChave = pontosChave;
	}

}
