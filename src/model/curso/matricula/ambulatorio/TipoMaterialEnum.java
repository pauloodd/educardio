package model.curso.matricula.ambulatorio;

public enum TipoMaterialEnum {
	USO_CORRENTE, USO_CLINICO, GERAL;
	
	public String toString() {
		if(this.equals(GERAL)){
			return "mobília, equipamentos de informática e eletroeletrônico ";
		}else if(this.equals(USO_CORRENTE)){
			return "materiais de uso corrente";
		}else if(this.equals(USO_CLINICO)){
			return "equipamentos de uso clínico";
		}else{
			return null;
		}
	};
	
}
