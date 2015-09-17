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
import javax.persistence.Table;

import model.curso.matricula.AvaliacaoProfessor;
import model.sistema.Arquivo;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="teorizacao")
public class Teorizacao implements Serializable{
	
	public int id;
	public List<Arquivo> arquivos;
	public AvaliacaoProfessor avaliacaoProfessor;
	
	public Teorizacao(){}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "arquivos_teorizacao", joinColumns = { @JoinColumn(name = "teorizacaoId") }, inverseJoinColumns = { @JoinColumn(name = "arquivoId") })
	public List<Arquivo> getArquivos() {
		return arquivos;
	}


	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
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
