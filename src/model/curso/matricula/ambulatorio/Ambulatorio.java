package model.curso.matricula.ambulatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ambulatorio")
public class Ambulatorio implements Serializable{
	
	public int id;
	
	public Date dataMatricula;
	public List<Material> materiais;
	
	
	public Ambulatorio(){}
	

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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "materiais_ambulatorio", joinColumns = { @JoinColumn(name = "ambulatorioId") }, inverseJoinColumns = { @JoinColumn(name = "materialId") })
	public List<Material> getMateriais() {
		return materiais;
	}


	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	
	@Transient
	public List<Material> getTodosMateriaisPorTipo(TipoMaterialEnum tipoMaterial){
		 List<Material>  retorno = new ArrayList<Material>();
		 
		 if(tipoMaterial == TipoMaterialEnum.GERAL){
			 for (Material material : materiais) {
				 if(material.getTipoMaterial() == Material.GERAL){
					 retorno.add(material);
				 }
			 }
		 }else  if(tipoMaterial == TipoMaterialEnum.USO_CLINICO){
			 for (Material material : materiais) {
				 if(material.getTipoMaterial() == Material.USO_CLINICO){
					 retorno.add(material);
				 }
			 }
		 }else  if(tipoMaterial == TipoMaterialEnum.USO_CORRENTE){
			 for (Material material : materiais) {
				 if(material.getTipoMaterial() == Material.USO_CORRENTE){
					 retorno.add(material);
				 }
			 }
		 }
		 
		return retorno;
	}

		

}
