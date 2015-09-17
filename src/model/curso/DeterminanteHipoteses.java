package model.curso;

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
@Table(name="determinante_hipoteses_de_solucao")
public class DeterminanteHipoteses implements Serializable{
	
	public int id;
	
	public String titulo;
	public EstudoDeCaso estudoDeCaso;
	
	public DeterminanteHipoteses(){}

	
	public DeterminanteHipoteses(int id) {
		super();
		this.id = id;
	}


	public DeterminanteHipoteses(String titulo, EstudoDeCaso estudoDeCaso) {
		super();
		this.titulo = titulo;
		this.estudoDeCaso = estudoDeCaso;
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

	@Column(name="titulo", nullable=false)
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idEstudoDeCaso",nullable=false)
	public EstudoDeCaso getEstudoDeCaso() {
		return estudoDeCaso;
	}


	public void setEstudoDeCaso(EstudoDeCaso estudoDeCaso) {
		this.estudoDeCaso = estudoDeCaso;
	}
	
	

}
