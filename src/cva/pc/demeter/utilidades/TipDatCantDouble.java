package cva.pc.demeter.utilidades;

import java.util.ArrayList;
import java.util.List;



public class TipDatCantDouble extends TipDatPar implements Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7131672521848676308L;
	private double cantidad;
	
	public TipDatCantDouble(long l, String descripcion, double cantidad) {
		super(l, descripcion);
		this.cantidad = cantidad;
	}
	
	public TipDatCantDouble() {
		super();
		this.cantidad = 0;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object o = super.clone();
		return o;

	}
	
	public static TipDatCantDouble buscar(List<TipDatCantDouble> dobles, TipDatCantDouble doble) {
		for (TipDatCantDouble dobleTmp : dobles) {
			if (dobleTmp.equals(doble)){
				return dobleTmp;
			}
		}
		return null;
	}
	
	static public List<TipDatCantDouble> clonarLista(List<TipDatCantDouble> lista) throws CloneNotSupportedException {
		List<TipDatCantDouble> listaSalida = new ArrayList<TipDatCantDouble>();
		for (TipDatCantDouble item : lista) {
			listaSalida.add(new TipDatCantDouble(item.getCodigo(), item.getDescripcion(), item.getCantidad()));
		}
		return listaSalida;
	}
}
