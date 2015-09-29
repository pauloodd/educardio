package model.curso.matricula;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.curso.Curso;
import model.usuario.Aluno;

@Entity
@Table(name="matricula_curso_aluno")
public class MatriculaCursoAluno implements Serializable{
	
	public int id;
	
	public Aluno aluno;
	public Curso curso;
	
	public Date dataMatricula;
	
	public String pergunta1;
	public String pergunta2;
	public String pergunta3;
	public String pergunta4;
	
	public MatriculaCursoAluno(){}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="dataMatricula", nullable=false)
	public Date getDataMatricula() {
		return dataMatricula;
	}


	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idAluno",nullable=false)
	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idCurso",nullable=false)
	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Column(name="pergunta1", nullable=true)
	public String getPergunta1() {
		return pergunta1;
	}


	public void setPergunta1(String pergunta1) {
		this.pergunta1 = pergunta1;
	}

	@Column(name="pergunta2", nullable=true)
	public String getPergunta2() {
		return pergunta2;
	}


	public void setPergunta2(String pergunta2) {
		this.pergunta2 = pergunta2;
	}


	@Column(name="pergunta3", nullable=true)
	public String getPergunta3() {
		return pergunta3;
	}


	public void setPergunta3(String pergunta3) {
		this.pergunta3 = pergunta3;
	}


	@Column(name="pergunta4", nullable=true)
	public String getPergunta4() {
		return pergunta4;
	}


	public void setPergunta4(String pergunta4) {
		this.pergunta4 = pergunta4;
	}

	

}
