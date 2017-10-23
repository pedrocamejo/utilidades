package cva.pc.demeter.excepciones;

public class FiltroException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9138584556226911791L;
		private String mensaje;
	
	public FiltroException(String string) {
		super();
		mensaje = string;
		
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public FiltroException() {
		super();
	}
	
	
	public String getMessage(){
		return mensaje;
	}
	
}
