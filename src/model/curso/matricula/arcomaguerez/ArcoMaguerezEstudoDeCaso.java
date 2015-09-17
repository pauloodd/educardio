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
import javax.persistence.Transient;

import model.curso.EstudoDeCaso;
import model.curso.matricula.MatriculaCursoAluno;

@Entity
@Table(name="arco_maguerez_estudo_de_caso")
public class ArcoMaguerezEstudoDeCaso implements Serializable{
	
	public static int OBS_REALIDADE = 0, PONTOS_CHAVE = 1, TEORIZACAO = 2, HIPOTESES = 3, APLICACAO= 4, FINALIZADO = 5;

	
	public int id;
	
	public int faseDoArco;
	
	public MatriculaCursoAluno matriculaAluno;
	public EstudoDeCaso estudoDeCaso;
	
	public PontosChave pontosChave;
	public Teorizacao teorizacao;
	public HipotesesDeSolucao hipotesesDeSolucao;
	public Aplicacao aplicacao;
		
	public ArcoMaguerezEstudoDeCaso(){}
	
	public ArcoMaguerezEstudoDeCaso(int faseDoArco,
			MatriculaCursoAluno matriculaAluno, EstudoDeCaso estudoDeCaso,
			PontosChave pontosChave, Teorizacao teorizacao, HipotesesDeSolucao hipotesesDeSolucao, Aplicacao aplicacao) {
		super();
		this.faseDoArco = faseDoArco;
		this.matriculaAluno = matriculaAluno;
		this.estudoDeCaso = estudoDeCaso;
		this.pontosChave = pontosChave;
		this.teorizacao = teorizacao;
		this.hipotesesDeSolucao = hipotesesDeSolucao;
		this.aplicacao = aplicacao;
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
	@JoinColumn(name="fk_idEstudoDeCaso",nullable=false)
	public EstudoDeCaso getEstudoDeCaso() {
		return estudoDeCaso;
	}


	public void setEstudoDeCaso(EstudoDeCaso estudoDeCaso) {
		this.estudoDeCaso = estudoDeCaso;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idTeorizacao",nullable=false)
	public Teorizacao getTeorizacao() {
		return teorizacao;
	}


	public void setTeorizacao(Teorizacao teorizacao) {
		this.teorizacao = teorizacao;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idMatriculaAluno",nullable=false)
	public MatriculaCursoAluno getMatriculaAluno() {
		return matriculaAluno;
	}


	public void setMatriculaAluno(MatriculaCursoAluno matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idPontosChave",nullable=false)
	public PontosChave getPontosChave() {
		return pontosChave;
	}


	public void setPontosChave(PontosChave pontosChave) {
		this.pontosChave = pontosChave;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idHipotesesSolucao",nullable=false)
	public HipotesesDeSolucao getHipotesesDeSolucao() {
		return hipotesesDeSolucao;
	}

	public void setHipotesesDeSolucao(HipotesesDeSolucao hipotesesDeSolucao) {
		this.hipotesesDeSolucao = hipotesesDeSolucao;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idAplicacao",nullable=false)
	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}
	
	@Column(name="faseDoArco", nullable=true)
	public int getFaseDoArco() {
		return faseDoArco;
	}


	public void setFaseDoArco(int faseDoArco) {
		this.faseDoArco = faseDoArco;
	}
	
	@Transient
	public String getFaseDescricao(){
		String retorno = "";
		
		//public static int OBS_REALIDADE = 0, PONSTO_CHAVE = 1, TEORIZACAO = 2, HIPOTESES = 3, APLICACAO= 4, FINALIZADO = 5;
		switch (getFaseDoArco()) {
		
		case 0:
			retorno = "observação da realidade";
			break;
		case 1:
			retorno = "pontos chave";
			break;
		case 2:
			retorno = "teorização";
			break;
		case 3:
			retorno = "hipóteses da soluação";
			break;
		case 4:
			retorno = "aplicação";
			break;
		case 5:
			retorno = "finalizado";
			break;
		default:
			break;
		}
		
		return retorno;
		
	}


}
