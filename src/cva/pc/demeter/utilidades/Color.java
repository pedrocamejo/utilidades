package cva.pc.demeter.utilidades;

import java.util.ArrayList;
import java.util.List;

public class Color {
	
	
	public static int NEGRO_HEX 		= 0;
	public static int BLANCO_HEX		= 1;
	public static int AMARILLO_HEX 		= 2;  	
	public static int AZUL_HEX 			= 3;
	public static int ROJO_HEX 			= 4;
	
	public static int GRIS_HEX 			= 5;
	public static int VERDE_HEX 		= 6;
	public static int MORADO_HEX 		= 7;
	public static int NARANJA_HEX 		= 8;
	public static int MARRON_HEX 		= 9;
	public static int ROSA_HEX 			= 10;
	public static int PLATA_HEX 		= 11;
	
	private String[] coloresHex = {"000000","FFFFFF","F8C222","006BFF","D91B1B","7C7C7C","23992A","6C2399","FF7100","381800","FF9FdE","E9E9E9"};
	private String[] coloresNom = {"NEGRO","BLANCO","AMARILLO","AZUL","ROJO","GRIS","VERDE","MORADO","NARANJA","MARRON","ROSA","PLATA"};
		
	public List<String> getColores(){
		List<String> lista = new ArrayList<String>();
		for (int i= 0; i<coloresNom.length; i++){
			lista.add(coloresNom[i]);
		}
		return lista;
		
	}
	
	public String getColorHexadecimal(int pos){
		return coloresHex[pos];
	}

}
