package cva.pc.demeter.excepciones;

public class ExcFiltroExcepcion extends Exception{
	
private static final long serialVersionUID = -7215716589335616546L;
private String mensajeError="Error en el Filtro";
	
	public ExcFiltroExcepcion() {
		super();
	}
	
	public ExcFiltroExcepcion(String mensaje) {
		super(mensaje);
	}

	public ExcFiltroExcepcion(Throwable arg0) {
		super("Error en el Filtro",arg0);
		
	}

	public String getMensajeError() {
		return mensajeError;
	}

	protected  void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

}
