package cva.pc.demeter.utilidades;

public class TipDatCantInt extends TipDatPar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2765434241400650433L;
	private int cantidad;
	
	public TipDatCantInt(long l, String descripcion, int cantidad) {
		super(l, descripcion);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
