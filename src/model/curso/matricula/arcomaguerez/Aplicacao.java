package model.curso.matricula.arcomaguerez;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aplicacao")
public class Aplicacao implements Serializable{
	
	public int id;
	public String texto;
	
	
	public Aplicacao(){}
	

	public Aplicacao(String texto) {
		super();
		this.texto = texto;
	}


	public Aplicacao(int id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
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

	@Column(name="texto", nullable=true, columnDefinition="TEXT")
	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}

	

}
