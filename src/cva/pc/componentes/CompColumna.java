package cva.pc.componentes;

import java.io.Serializable;

public class CompColumna implements Serializable{	
	private static final long serialVersionUID = -4782402483763146702L;
	private String 	descripcion;
	private int		id; 
	private int 	ancho;
//////////////////////////////////////////////
	public CompColumna(String descripcion) {
		super();
		this.descripcion = descripcion;
		//ancho = 50;
		this.ancho = descripcion.length()+ descripcion.length()*7;	
	}
	//////////////////////////////////////////////
	public CompColumna(String descripcion, int ancho) {
		super();
		this.descripcion = descripcion;
		this.ancho = ancho;
	}
	//////////////////////////////////////////////
	public CompColumna(int id, String descripcion, int ancho) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.ancho = ancho;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String toString(){
		return descripcion;
	}
	public int getAncho() {
		return ancho;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
