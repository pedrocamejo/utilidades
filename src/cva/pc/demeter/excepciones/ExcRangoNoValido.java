package cva.pc.demeter.excepciones;

public class ExcRangoNoValido extends ExcEntradaInvalida {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8862902856427604941L;

	public ExcRangoNoValido() {
		setMensajeError("Valor en rango invalido");
		// TODO Auto-generated constructor stub
	}

	public ExcRangoNoValido(Throwable arg0) {
		super(arg0);
		setMensajeError("Valor en rango invalido");
		// TODO Auto-generated constructor stub
	}

	
}
