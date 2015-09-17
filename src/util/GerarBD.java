package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarBD {
	public static void main(String[] args) {
		try{
			System.out.println("Inicio da Geração do banco de dados...");
			Configuration cfg = new AnnotationConfiguration().configure();
			SchemaExport schemaExport = new SchemaExport(cfg);
			schemaExport.create(true,true);
			
			
		//	MainPopulaBD.execMainPopulaBD();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
