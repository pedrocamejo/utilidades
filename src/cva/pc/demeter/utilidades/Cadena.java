package cva.pc.demeter.utilidades;

public class Cadena {
	
	public static String llenarAlaDerecha(String cadena, int n, String con) {
		while(cadena.length()<n){
	        cadena = cadena+con;
	    }  
	    return cadena;  
	}
	
	public static String llenarAlaDerecha(String cadena, int n, String con, String sufijo) {
		while(cadena.length()<n){
	        cadena = cadena+con;
	    }  
		String txtInicio = cadena.substring(0,cadena.length()-sufijo.length());
	    return txtInicio+sufijo;  
	}
	

	public static String llenarAlaIzquierda(String cadena, int n, String con) {
		while(cadena.length()<n){
	        cadena = con+cadena;
	    }  
	    return cadena;
	    
	}
	
	public static String llenarAlaIzquierda(String cadena, int n, String con, String prefijo) {
		
		while(cadena.length()<n){
	        cadena = con+cadena;
	    } 
		String txtFinal = cadena.substring(prefijo.length(),cadena.length());
	    return prefijo+txtFinal;
	    
	}
	
	public static String llenarSandwitch(String prefijo, String cadena, int n, String con,String sufijo) {
		
		while(cadena.length()<n){
	        cadena = con+cadena;
	    } 
		String txtFinal = cadena.substring(prefijo.length(),cadena.length());
		cadena = prefijo+txtFinal;
		String txtInicio = cadena.substring(0,cadena.length()-sufijo.length());
	    return txtInicio+sufijo;
	    
	}

}
