package model.curso;

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
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import model.Nanda;
import model.sistema.Arquivo;

@Entity
@Table(name="estudo_de_caso")
public class EstudoDeCaso implements Serializable{
	
	public static int ANDAMENTO = 0, PAUSA = 1, PREVISTO = 2, BLOQUEADO = 3, CONCLUIDO = 4;
	public static int BAIXO = 0, MEDIO = 1, ALTO = 2;

	public int id;
	public int status;
	public String titulo;
	public String objetivosGerais;
	public String objetivosEspecificos;
	
	public int grauDificuldade;
	public String descricao;
	
	public List<Arquivo> imagensCaso;
	public List<Arquivo> imagensAuxiliares;
	
	public List<Nanda> diagnosticosSelecionadoProfessor;
	
	public String pontosChave;
	
	public Curso curso;
	
	public EstudoDeCaso(){}
	
	public EstudoDeCaso(int id) {
		super();
		this.id = id;
	}



	public EstudoDeCaso(int status, String titulo, String objetivosGerais,
			String objetivosEspecificos, int grauDificuldade, String descricao,
			List<Arquivo> imagensCaso, List<Arquivo> imagensAuxiliares,
			String pontosChave, Curso curso) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.objetivosGerais = objetivosGerais;
		this.objetivosEspecificos = objetivosEspecificos;
		this.grauDificuldade = grauDificuldade;
		this.descricao = descricao;
		this.imagensCaso = imagensCaso;
		this.imagensAuxiliares = imagensAuxiliares;
		this.pontosChave = pontosChave;
		this.curso = curso;
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

	@Column(name="status", nullable=false)
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="titulo", nullable=false)
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name="objetivosGerais", nullable=false, columnDefinition="TEXT")
	public String getObjetivosGerais() {
		return objetivosGerais;
	}


	public void setObjetivosGerais(String objetivosGerais) {
		this.objetivosGerais = objetivosGerais;
	}

	@Column(name="objetivosEspecificos", nullable=false, columnDefinition="TEXT")
	public String getObjetivosEspecificos() {
		return objetivosEspecificos;
	}


	public void setObjetivosEspecificos(String objetivosEspecificos) {
		this.objetivosEspecificos = objetivosEspecificos;
	}

	@Column(name="grauDificuldade", nullable=false)
	public int getGrauDificuldade() {
		return grauDificuldade;
	}


	public void setGrauDificuldade(int grauDificuldade) {
		this.grauDificuldade = grauDificuldade;
	}

	@Column(name="descricao", nullable=false, columnDefinition="TEXT")
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "arquivos_estudocasoimgs", joinColumns = { @JoinColumn(name = "estudoCasoId") }, inverseJoinColumns = { @JoinColumn(name = "arquivoId") })
	public List<Arquivo> getImagensCaso() {
		return imagensCaso;
	}


	public void setImagensCaso(List<Arquivo> imagensCaso) {
		this.imagensCaso = imagensCaso;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "arquivos_estudocasoimgsaux", joinColumns = { @JoinColumn(name = "estudoCasoId") }, inverseJoinColumns = { @JoinColumn(name = "arquivoId") })
	public List<Arquivo> getImagensAuxiliares() {
		return imagensAuxiliares;
	}


	public void setImagensAuxiliares(List<Arquivo> imagensAuxiliares) {
		this.imagensAuxiliares = imagensAuxiliares;
	}

	@Column(name="planejamento", nullable=false, columnDefinition="TEXT")
	public String getPontosChave() {
		return pontosChave;
	}


	public void setPontosChave(String pontosChave) {
		this.pontosChave = pontosChave;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idCurso",nullable=false)
	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "diagnosticos_professor", joinColumns = { @JoinColumn(name = "estudoCasoId") }, inverseJoinColumns = { @JoinColumn(name = "nandaId") })
	public List<Nanda> getDiagnosticosSelecionadoProfessor() {
		return diagnosticosSelecionadoProfessor;
	}

	public void setDiagnosticosSelecionadoProfessor(List<Nanda> diagnosticosSelecionadoProfessor) {
		this.diagnosticosSelecionadoProfessor = diagnosticosSelecionadoProfessor;
	}
	
	@Transient
	public String getDescricaoResumida(){
		return this.getDescricao().replaceAll("\\<.*?>","").substring(0, 100);
	}

	@Transient
	public String getStatusDescricao(){
		String retorno = "";
		
		//public static int ANDAMENTO = 0, PAUSA = 1, PREVISTO = 2, BLOQUEADO = 3, CONCLUIDO = 4;
		switch (getStatus()) {
		
		case 0:
			retorno = StatusEnum.ANDAMENTO.toString();
			break;
		case 1:
			retorno = StatusEnum.PAUSA.toString();
			break;
		case 2:
			retorno = StatusEnum.PREVISTO.toString();
			break;
		case 3:
			retorno = StatusEnum.BLOQUEADO.toString();
			break;
		case 4:
			retorno = StatusEnum.CONCLUIDO.toString();
			break;
		default:
			break;
		}
		
		return retorno;
		
	}

}
