package model.curso;

public enum StatusEnum {
	ANDAMENTO, PAUSA, PREVISTO, BLOQUEADO, CONCLUIDO;
	
	public String toString() {
		if(this.equals(ANDAMENTO)){
			return "em andamentos";
		}else if(this.equals(PAUSA)){
			return "em pausa ou suspenso";
		}else if(this.equals(PREVISTO)){
			return "previsto";
		}else if(this.equals(BLOQUEADO)){
			return "bloqueado";
		}else if(this.equals(CONCLUIDO)){
			return "concluído";
		}else{
			return null;
		}
	};
	
}
