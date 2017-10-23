package cva.pc.componentes;

import java.io.Serializable;


public class CompEncabezado implements Serializable{	
	private static final long serialVersionUID = -4782402483763146702L;
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = 0;
	public static final int CENTRO = 2;
	
	public static final String[] ALINEACION= {"left","right","center"};
	
	private String 		descripcion;
	private int			id; 
	private boolean 	visible=true;
	private int 		alineacion=0; 

	private boolean 	ordenable = false;
	private int 		ancho;
	
	private String 		metodoBinder;
	private String 		metodoModelo;
	private String 		metodoComponente;
	
	
	public CompEncabezado(){
		super();
	}
//////////////////////////////////////////////
	public CompEncabezado(String descripcion) {
		super();
		this.descripcion = descripcion;
		//ancho = 50;
		this.ancho = descripcion.length()+ descripcion.length()*7;	
	}
	//////////////////////////////////////////////
	public CompEncabezado(String descripcion, int ancho) {
		super();
		this.descripcion = descripcion;
		this.ancho = ancho;
	}
	//////////////////////////////////////////////
	public CompEncabezado(int id, String descripcion, int ancho) {
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

	public boolean isOrdenable() {
		return ordenable;
	}
	public void setOrdenable(boolean ordenable) {
		this.ordenable = ordenable;
	}

	public final boolean isVisible() {
		return visible;
	}
	public final void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public final int getAlineacion() {
		return alineacion;
	}
	public final void setAlineacion(int alineacion) {
		this.alineacion = alineacion;
	}
	
	public final String getStrAlineacion() {
		return ALINEACION[alineacion];
	}
	
	public final void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public final void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public String getMetodoBinder() {
		return metodoBinder;
	}
	public void setMetodoBinder(String metodoBinder) {
		this.metodoBinder = metodoBinder;
	}
	public String getMetodoModelo() {
		return metodoModelo;
	}
	public void setMetodoModelo(String metodoModelo) {
		this.metodoModelo = metodoModelo;
	}
	public String getMetodoComponente() {
		return metodoComponente;
	}
	public void setMetodoComponente(String metodoComponente) {
		this.metodoComponente = metodoComponente;
	}
}
