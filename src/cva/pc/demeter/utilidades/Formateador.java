package cva.pc.demeter.utilidades;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Formateador {

	public static String rellenarNumero(Integer numero, String formato){
		DecimalFormat df1 = new DecimalFormat(formato); 
		return df1.format(numero);
	}

	public static String rellenarNumero(Long numero, String formato){
		DecimalFormat df1 = new DecimalFormat(formato);
		return df1.format(numero);
	}
	
	public static String formatearMoneda(Integer valor){
		if(valor == null){
			valor = 0;
		}
		DecimalFormat nf1 = formatearDecimales("##,###,###,##0");
		return nf1.format(valor); 
	}
	
	public static String rellenarBlanco(String valor, int longitud, boolean alInicio ){
		StringBuilder cadena= new StringBuilder();
		int i;
		if (valor!=null){
			cadena.append(valor);
			i=valor.length();
		}else
			i=0;
		if (alInicio)
			while(i++ <longitud )
				cadena.insert(0,' ');
		else
			while(i++ <longitud )
				cadena.append(' ');
		return cadena.toString();
	}
	
	public static String formatearMoneda(float valor){
		DecimalFormat nf1 = formatearDecimales("##,###,###,###,##0.0000");
		return nf1.format(valor); 
		
	}
	
	public  static String formatearMoneda(Double  valor){
		if(valor == null) {
			valor = 0.0;
		}
		DecimalFormat nf1 =  formatearDecimales("##,###,###,###,###,###,##0.0000");
		return nf1.format(valor); 
	}
	
	public  static String formatearMonedaVenezuela(Double  valor){
		if(valor == null) {
			valor = 0.0;
		}
		DecimalFormat nf1 =  formatearDecimales("##.###.###.###.###.###.##0,0000");
		return nf1.format(valor); 
	}
	
	public  static String formatearMonedaSQL(double  valor){
		DecimalFormat nf1 =  formatearDecimales();
		return nf1.format(valor); 
	}
	
	public static DecimalFormat formatearDecimales(String formato){
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
		unusualSymbols.setDecimalSeparator('.');
		unusualSymbols.setGroupingSeparator(',');
		DecimalFormat weirdFormatter = new DecimalFormat(formato, unusualSymbols);
		weirdFormatter.setGroupingSize(3);
		return weirdFormatter;
	}
	
	public static DecimalFormat formatearDecimales(){
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
		unusualSymbols.setDecimalSeparator('.');
		DecimalFormat weirdFormatter = new DecimalFormat("###################0.0000", unusualSymbols);
		return weirdFormatter;
	}
}
