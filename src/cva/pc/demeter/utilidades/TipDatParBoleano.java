package cva.pc.demeter.utilidades;

import java.util.List;

public class TipDatParBoleano extends TipDatPar {
	
	/**
	 * 
	 */
	private static final long 	serialVersionUID = -9127110611867029914L;
	private boolean 			verificado;

	public TipDatParBoleano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipDatParBoleano(int l, String descripcion, boolean verificado) {
		super(l, descripcion);
		this.verificado = verificado;
	}

	public TipDatParBoleano(long l, String descripcion, boolean verificado) {
		super(l, descripcion);
		this.verificado = verificado;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}
	
	public static int buscarIndice(List<TipDatParBoleano> lista, String idBuscar ){
		
		for (int i = 0; i<lista.size(); i++) {
			if (idBuscar.equals(lista.get(i).getCodigo()))
				return i;
		}
		return -1;
	}
	
	public static int buscarIndice(List<TipDatParBoleano> lista, int   idBuscar ){
		
		for (int i = 0; i<lista.size(); i++) {
			if (idBuscar == lista.get(i).getCodigo())
				return i;
		}
		return -1;
	}
}
