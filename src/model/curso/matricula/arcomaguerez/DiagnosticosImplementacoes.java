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
import model.Nic;

@Entity
@Table(name="diagnosticos_implementacoes")
public class DiagnosticosImplementacoes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int id;
	
	public Implementacao implementacao;
	
	public Nanda nandaProfessor;
	public List<Nic> nicsSelecionadosAluno;

	public DiagnosticosImplementacoes(){}
	
	public DiagnosticosImplementacoes(int id) {
		super();
		this.id = id;
	}

	public DiagnosticosImplementacoes(Nanda nandaProfessor) {
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
	@JoinColumn(name="fk_idImplementacao",nullable=false)
	public Implementacao getImplementacao() {
		return implementacao;
	}

	public void setImplementacao(Implementacao implementacao) {
		this.implementacao = implementacao;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "nics_selecionado_aluno", joinColumns = { @JoinColumn(name = "diagnosticosIntervencoesId") }, inverseJoinColumns = { @JoinColumn(name = "nicId") })
	public List<Nic> getNicsSelecionadosAluno() {
		return nicsSelecionadosAluno;
	}

	public void setNicsSelecionadosAluno(List<Nic> nicsSelecionadosAluno) {
		this.nicsSelecionadosAluno = nicsSelecionadosAluno;
	}
	
	
}
