package cva.pc.demeter.excepciones;

public class ExcAgregacionInvalida extends Exception {
	
	private static final long serialVersionUID = 4484661164446969113L;
	private String mensajeError="Valor no valido";
	
	public ExcAgregacionInvalida() {
		super();
	}
	
	public ExcAgregacionInvalida(String mensaje) {
		super(mensaje);
	}

	public ExcAgregacionInvalida(Throwable arg0) {
		super("Valor no valido",arg0);
		
	}

	public String getMensajeError() {
		return mensajeError;
	}

	protected  void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
