package model.curso;

public enum GrauDificuldadeEnum {
	BAIXO, MEDIO, ALTO;
	
	public String toString() {
		if(this.equals(BAIXO)){
			return "baixo";
		}else if(this.equals(MEDIO)){
			return "médio";
		}else if(this.equals(ALTO)){
			return "alto";
		}else{
			return null;
		}
	};
	
}
