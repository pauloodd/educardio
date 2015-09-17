package model.curso.matricula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacao_professor")
public class AvaliacaoProfessor {

	
	public int id;
	public String nota;
	public String comentario;
	
	public AvaliacaoProfessor(){}
	
	public AvaliacaoProfessor(String nota, String comentario) {
		super();
		this.nota = nota;
		this.comentario = comentario;
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

	@Column(name="nota", nullable=true)
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Column(name="comentario", nullable=true, columnDefinition="TEXT")
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

}
