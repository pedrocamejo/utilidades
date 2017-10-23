package cva.pc.demeter.utilidades;

import java.io.Serializable;
import java.util.List;

public class TipDatParString implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4537312364855033171L;
	private String codigo;
	private String descripcion;
	
	public TipDatParString(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipDatParString() {
	}
	
	public String toString(){
		return descripcion;
	}
	
	public static int buscarIndice(List<TipDatParString> lista, String idBuscar ){
		
		for (int i = 0; i<lista.size(); i++) {
			if (idBuscar.equals(lista.get(i).getCodigo()))
				return i;
			
		}
		return -1;
	}
		
}
