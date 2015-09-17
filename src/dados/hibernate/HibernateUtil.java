package dados.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory fabricaDeSessao;
	
	
	static {
		try {
			fabricaDeSessao = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getFabricaDeSessao() {
		return fabricaDeSessao;
	}
	

	public static void desligar() {
		getFabricaDeSessao().close();
	}
	

}
