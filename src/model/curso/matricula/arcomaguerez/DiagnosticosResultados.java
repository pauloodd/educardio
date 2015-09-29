package model.curso.matricula.arcomaguerez;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import model.Nanda;
import model.Noc;

@Entity
@Table(name="diagnosticos_resultados_esperados")
public class DiagnosticosResultados implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int id;
	
	public ResultadosEsperados resultadosEsperados;
	
	public Nanda nandaProfessor;
	public List<Noc> nocsSelecionadosAluno;

	public DiagnosticosResultados(){}
	
	public DiagnosticosResultados(int id) {
		super();
		this.id = id;
	}

	public DiagnosticosResultados(Nanda nandaProfessor) {
		super();
		this.nandaProfessor = nandaProfessor;
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
	@JoinColumn(name="fk_idNandaProfessor",nullable=false)
	public Nanda getNandaProfessor() {
		return nandaProfessor;
	}

	public void setNandaProfessor(Nanda nandaProfessor) {
		this.nandaProfessor = nandaProfessor;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idResultadosEsperados",nullable=false)
	public ResultadosEsperados getResultadosEsperados() {
		return resultadosEsperados;
	}

	public void setResultadosEsperadoso(ResultadosEsperados resultadosEsperados) {
		this.resultadosEsperados = resultadosEsperados;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "nocs_selecionado_aluno", joinColumns = { @JoinColumn(name = "diagnosticosResultadoId") }, inverseJoinColumns = { @JoinColumn(name = "nocId") })
	public List<Noc> getNocsSelecionadosAluno() {
		return nocsSelecionadosAluno;
	}

	public void setNocsSelecionadosAluno(List<Noc> nocsSelecionadosAluno) {
		this.nocsSelecionadosAluno = nocsSelecionadosAluno;
	}
	
	
}
