package model.curso;

import java.io.Serializable;
import java.util.Date;
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

import model.sistema.Arquivo;
import model.usuario.Professor;
import util.DataUtil;

@Entity
@Table(name="curso")
public class Curso implements Serializable{
	
	public static int ANDAMENTO = 0, PAUSA = 1, PREVISTO = 2, BLOQUEADO = 3, CONCLUIDO = 4;

	public int id;
	public String titulo;
	public String objetivos;
	public String ementa;
	public String metodologia;
	public Date dataInicio;
	public Date dataFim;
	public int status;
	public Professor professor;
	public List<Arquivo> arquivos;
	
	

	public Curso(int id, String titulo, String objetivos, String ementa,
			Date dataInicio, Date dataFim, int status, Professor professor, List<Arquivo> arquivos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.objetivos = objetivos;
		this.ementa = ementa;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
		this.professor = professor;
		this.arquivos = arquivos;
	}


	public Curso(){}
	
	public Curso(int id){
		super();
		this.id = id;
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

	@Column(name="objetivos", nullable=false, columnDefinition="TEXT")
	public String getObjetivos() {
		return objetivos;
	}


	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	@Column(name="ementa", nullable=false, columnDefinition="TEXT")
	public String getEmenta() {
		return ementa;
	}


	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	@Column(name="dataInicio", nullable=false)
	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name="dataFim", nullable=false)
	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "arquivos_curso", joinColumns = { @JoinColumn(name = "cursoId") }, inverseJoinColumns = { @JoinColumn(name = "arquivoId") })
	public List<Arquivo> getArquivos() {
		return arquivos;
	}


	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	@Column(name="status", nullable=false)
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idProfessor",nullable=false)
	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
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
	
	@Transient
	public String getDataInicioFormatada(){
		return DataUtil.formatarData(dataInicio);
	}
	
	@Transient
	public String getDataFimFormatada(){
		return DataUtil.formatarData(dataFim);
	}
	
	@Transient
	public String getEmentaFormatada(){
		String retorno = "";
		if(getEmenta() != null && getEmenta().length() > 44){
			retorno = getEmenta().substring(0, 44);
		}else{
			retorno = getEmenta();
		}
		return retorno;
	}


	@Column(name="metodologia", nullable=false, columnDefinition="TEXT")
	public String getMetodologia() {
		return metodologia;
	}


	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

}
