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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import model.Nanda;
import model.curso.matricula.AvaliacaoProfessor;

@Entity
@Table(name="planejamento")
public class Planejamento implements Serializable{
	
	public int id;
	
	public AvaliacaoProfessor avaliacaoProfessor;
	public List<Nanda> diagnosticosSelecionadoAluno;
	
	public Planejamento(){}
	
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "diagnosticos_professor", joinColumns = { @JoinColumn(name = "planejamentoId") }, inverseJoinColumns = { @JoinColumn(name = "nandaId") })
	public List<Nanda> getDiagnosticosSelecionadoAluno() {
		return diagnosticosSelecionadoAluno;
	}

	public void setDiagnosticosSelecionadoAluno(List<Nanda> diagnosticosSelecionadoAluno) {
		this.diagnosticosSelecionadoAluno = diagnosticosSelecionadoAluno;
	}
	

}
