package br.com.advocacialca.controller.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataFormatada {
	
	public static Calendar formatarData(String data) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
			
		date = sdf.parse(data);
		
		Calendar dataFormatada = Calendar.getInstance();
		dataFormatada.setTime(date);
		
		return dataFormatada;
		
		
	}
	
}
