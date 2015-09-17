package dados.basicas;

import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.Meta;
import dados.DAOGenerico;

public interface MetaDAO extends DAOGenerico<Meta, Integer> {
	
	public void removerMetasDeDiagnostico(Diagnostico diagnostico);
	public void removerMeta(Meta meta);

}
