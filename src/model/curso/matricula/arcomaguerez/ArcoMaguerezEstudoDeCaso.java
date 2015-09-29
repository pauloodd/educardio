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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static int INVESTIGACAO = 0, PLANEJAMENTO = 1, IMPLEMENTACAO = 2, RESULTADOS_ESPERADOS = 3, AVALIACAO= 4, FINALIZADO = 5;
// public static int OBS_REALIDADE = 0, PONTOS_CHAVE = 1, TEORIZACAO = 2,		 HIPOTESES = 3, 		APLICACAO= 4, FINALIZADO = 5;

	
	public int id;
	
	public int faseDoArco;
	
	public MatriculaCursoAluno matriculaAluno;
	public EstudoDeCaso estudoDeCaso;
	
	public Planejamento planejamento;
	public Implementacao implementacao;
	public ResultadosEsperados resultadosEsperados;
	public Avaliacao avaliacao;
		
	public ArcoMaguerezEstudoDeCaso(){}
	
	public ArcoMaguerezEstudoDeCaso(int faseDoArco,
			MatriculaCursoAluno matriculaAluno, EstudoDeCaso estudoDeCaso,
			Planejamento planejamento, Implementacao implementacao, ResultadosEsperados resultadosEsperados, Avaliacao avaliacao) {
		super();
		this.faseDoArco = faseDoArco;
		this.matriculaAluno = matriculaAluno;
		this.estudoDeCaso = estudoDeCaso;
		this.planejamento = planejamento;
		this.implementacao = implementacao;
		this.resultadosEsperados = resultadosEsperados;
		this.avaliacao = avaliacao;
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
	@JoinColumn(name="fk_idImplementacao",nullable=false)
	public Implementacao getImplementacao() {
		return implementacao;
	}


	public void setImplementacao(Implementacao implementacao) {
		this.implementacao = implementacao;
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
	@JoinColumn(name="fk_idPlanejamento",nullable=false)
	public Planejamento getPlanejamento() {
		return planejamento;
	}


	public void setPontosChave(Planejamento planejamento) {
		this.planejamento = planejamento;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idResultadosEsperados",nullable=false)
	public ResultadosEsperados getResultadosEsperados() {
		return resultadosEsperados;
	}

	public void setResultadosEsperados(ResultadosEsperados resultadosEsperados) {
		this.resultadosEsperados = resultadosEsperados;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idAvaliacao",nullable=false)
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
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
		
		//public static int INVESTIGACAO = 0, PONSTO_CHAVE = 1, IMPLEMENTACAO = 2, RESULTADOS_ESPERADOS = 3, AVALIACAO= 4, FINALIZADO = 5;
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
