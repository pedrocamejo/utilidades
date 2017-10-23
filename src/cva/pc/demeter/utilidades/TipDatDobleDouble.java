package cva.pc.demeter.utilidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TipDatDobleDouble implements Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6976073741751346638L;
	private int 				id;
	private TipDatCantDouble	primero;
	private TipDatCantDouble	segundo;

	
	
	
	public TipDatDobleDouble() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipDatCantDouble getPrimero() {
		return primero;
	}

	public void setPrimero(TipDatCantDouble primero) {
		this.primero = primero;
	}

	public TipDatCantDouble getSegundo() {
		return segundo;
	}

	public void setSegundo(TipDatCantDouble segundo) {
		this.segundo = segundo;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object o = super.clone();
		return o;

	}
	
	static public List<TipDatDobleDouble> clonarLista(List<TipDatDobleDouble> lista) throws CloneNotSupportedException {
		List<TipDatDobleDouble> listaSalida = new ArrayList<TipDatDobleDouble>();
		for (TipDatDobleDouble item : lista) {
			TipDatDobleDouble nuevo = new TipDatDobleDouble();
			nuevo.setId(item.getId());
			nuevo.setPrimero(item.getPrimero());
			nuevo.setSegundo(item.getSegundo());
			listaSalida.add(nuevo);
		}
		return listaSalida;
	}
}
