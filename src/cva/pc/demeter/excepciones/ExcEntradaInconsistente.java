package cva.pc.demeter.excepciones;

public class ExcEntradaInconsistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4484661164446969113L;
	private String mensajeError="Valor no valido";
	
	public ExcEntradaInconsistente() {
	}

	public ExcEntradaInconsistente(Throwable arg0) {
		super("Valor no valido",arg0);
		// TODO Auto-generated constructor stub
	}

	public ExcEntradaInconsistente(String mensaje) {
		super(mensaje);
		// TODO Auto-generated constructor stub
	}
	
	public String getMensajeError() {
		return mensajeError;
	}

	protected  void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
