package cva.pc.demeter.utilidades;

import java.io.Serializable;
import java.util.List;

public class TipDatPar implements Serializable {
	
	private static final long serialVersionUID = 8280969209334291898L;
	private long codigo;
	private String descripcion;
	
	public TipDatPar(long l, String descripcion) {
		super();
		this.codigo = l;
		this.descripcion = descripcion;
	}
	
	public TipDatPar(int l, String descripcion) {
		super();
		this.codigo = l;
		this.descripcion = descripcion;
	}
	
	public TipDatPar() {
		super();
		this.codigo = -1;
		this.descripcion = "";
	}
	
	
	public long getCodigo() {
		return codigo;
	}

	public int getintCodigo() {
		return (int)codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public String toString(){
		return descripcion;
	}
	
	public static int buscarIndice(List<TipDatPar> lista, int idBuscar ){
		int i = 0;
		for (TipDatPar codigo : lista) {
			if (codigo.getCodigo()== idBuscar)
				return i;
			i++;
		}
		return -1;
	}
	
	public static int buscarIndice(List<TipDatPar> lista, long idBuscar ){
		int i = 0;
		for (TipDatPar codigo : lista) {			
			if (codigo.getCodigo()== idBuscar)
				return i;
			i++;
		}
		return -1;
	}
	
	public static TipDatPar obtener(List<TipDatPar> lista, long idBuscar ){	
		for (TipDatPar objeto : lista) {			
			if (objeto.getCodigo()== idBuscar)
				return objeto;
		
		}
		return null;	
	}
	public static boolean contiene(List<TipDatPar> lista, long idBuscar){
		for (TipDatPar tipDatPar : lista) {
			if (tipDatPar.getCodigo()==idBuscar) return true;
		}
		return false;
	}
	
	public static String obtenerIndices(List<TipDatPar> lista){
		StringBuilder cadena = new StringBuilder("("); 
		for (TipDatPar salida : lista) {			
			cadena.append(salida.getCodigo());
			cadena.append(",");	
		}
		cadena.deleteCharAt(cadena.length());
		cadena.append(")");	
		return cadena.toString();	
	}
	
	public boolean existe(List<TipDatPar> lista){
		 
		for (TipDatPar objeto : lista) {			
			if (getCodigo() == objeto.getCodigo())
				return true;
		}
		return false;	
	}
}
