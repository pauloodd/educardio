package model.curso.matricula.ambulatorio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="material")
public class Material implements Serializable{
	
	public static int GERAL = 0, USO_CORRENTE = 1, USO_CLINICO = 2;
			
	public int id;
	public String descricao;
	public int tipoMaterial;
	
	public Material(){}
	
	public Material(int id){
		this.id = id;
	}
	
	public Material(String descricao, int tipoMaterial) {
		super();
		this.descricao = descricao;
		this.tipoMaterial = tipoMaterial;
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

	@Column(name="descricao", nullable=false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name="tipoMaterial", nullable=false)
	public int getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(int tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	
	@Transient
	public String getTipoMaterialDescricao(){
		String retorno = "";
		
		//public static int  GERAL = 0, USO_CORRENTE = 1, USO_CLINICO = 2;
		switch (getTipoMaterial()) {
		
		case 0:
			retorno = TipoMaterialEnum.GERAL.toString();
			break;
		case 1:
			retorno = TipoMaterialEnum.USO_CORRENTE.toString();
			break;
		case 2:
			retorno = TipoMaterialEnum.USO_CLINICO.toString();
			break;
		default:
			break;
		}
		
		return retorno;
		
	}

	@Override
	public boolean equals(Object obj) {
		boolean retorno = false;
		if(this.getId() == ((Material)obj).getId()){
			retorno = true;
		}
		return retorno;
	}
		

}
