package model.usuario;

public enum TipoUsuario {
	ADMINISTRADOR, PROFESSOR, ALUNO;
	
	public String toString() {
		if(this.equals(ADMINISTRADOR)){
			return "administrador";
		}else if(this.equals(PROFESSOR)){
			return "professor";
		}else if(this.equals(ALUNO)){
			return "aluno";
		}else{
			return null;
		}
	};
	
}
