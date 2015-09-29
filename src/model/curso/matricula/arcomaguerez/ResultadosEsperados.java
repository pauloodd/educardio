package model.curso.matricula.arcomaguerez;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.curso.matricula.AvaliacaoProfessor;

@Entity
@Table(name="resultados_esperados")
public class ResultadosEsperados implements Serializable{
	
	public int id;
	public AvaliacaoProfessor avaliacaoProfessor;
	
	public ResultadosEsperados(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idAvaliacaoProfessor", nullable=true)
	public AvaliacaoProfessor getAvaliacaoProfessor() {
		return avaliacaoProfessor;
	}

	public void setAvaliacaoProfessor(AvaliacaoProfessor avaliacaoProfessor) {
		this.avaliacaoProfessor = avaliacaoProfessor;
	}

}
