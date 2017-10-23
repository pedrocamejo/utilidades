package cva.pc.demeter.excepciones;

public class ExcEntradaInvalida extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2846912268620077018L;
	private String mensajeError="Valor no valido";
	
	public ExcEntradaInvalida() {
	}

	public ExcEntradaInvalida(String mensaje) {
		super(mensaje);
	}
	
	public ExcEntradaInvalida(Throwable arg0) {
		super("Valor no valido",arg0);
		// TODO Auto-generated constructor stub
	}

	public String getMensajeError() {
		return mensajeError;
	}

	protected  void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	
}
