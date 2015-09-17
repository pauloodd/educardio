package util;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Util {
	
	public static String simplificarData(Date data){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(data);
	}
	
	public static Date criarData(String texto) throws ParseException{
		Date data = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		data = format.parse(texto);
		return data;
	}
	
}
