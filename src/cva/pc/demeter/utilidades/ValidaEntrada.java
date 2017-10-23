package cva.pc.demeter.utilidades;




public class ValidaEntrada {
	
	
	public static final String ESREAL 			= "/[0-9]+\\.?[0-9]*/";
	public static final String ESNUMERO 		= "/[0-9]*/";
	public static final String ESCUENTA			= "/[0-9\\-]{20,24}/";
	public static final String ESNOMBREVALIDO 	= "/[A-Za-zñÑ]{3,}/";
	public static final String ESNOMBREVALIDOBL	= "/[A-Za-zñÑ\\' ]{3,}/";
	public static final String ESSOLOLETRAS 	= "/[A-Za-zñÑ]*/";
	public static final String ESRIF 			= "/[JjGgVveE]?-[0-9]{5,9}/";
	public static final String ESRIFCEDULA		= "/[JjGgVveEPp]?-[0-9]{5,9}/";
	public static final String ESCEDULA 		= "/[VvEePp]?-[0-9]{5,9}/";
	public static final String ESEMAIL 			= "/[a-zA-Z]+[0-9\\._a-zA-Z-]*@[a-zA-Z0-9]+\\.[a-zA-Z\\.]+/";
	public static final String ESEMAIL2			= "/\\.+@.+\\.[a-z]+/"; 
	
	public static final int SIN_PROBLEMA		= 0;
	public static final int CON_WARNING			= 1;
	public static final int CON_ERROR			= 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8485895738939819601L;


	public static boolean esTamanoValido(String cadena, int minimo){
		if (cadena.length()>=minimo){
				return true;
		}else
			return false;
	}
	
	public static boolean esTamanoValido(String cadena){
		if (cadena.length()>0){
				return true;
		}else
			return false;
	}
	
	public static boolean esDouble(String seleccion){
		if( seleccion.length()>0){
			if (seleccion.matches("[0-9]+\\.?[0-9]*")){
				return true;
			}else
				return false;
		}else
			return false;
	}
	
	
	public static boolean esPorcentaje(String seleccion){
		try{
			double valor = Double.parseDouble(seleccion);
			if (valor >= 0 && valor <= 100)
				return true;
			else
				return false;
		}catch (Exception e) {
			return false;
		}
	}
	
	public static boolean esDecimal(String seleccion){
		if( seleccion.length()>0){
			if (seleccion.matches("[0-9]+,?[0-9]*")){
				return true;
			}else
				return false;
		}else
			return true;
	}
	
	public static boolean esTamanoValido(String cadena, int minimo, int maximo){
		if (cadena.length()>=minimo && cadena.length()<=maximo){
				return true;
		}else
			return false;
	}
	
	public static boolean esSeleccionValida(int seleccion){
		if (seleccion >=0){
			return true;
		}else
			return false;
	}
	
	public static boolean esNumerico(String seleccion){
		if (seleccion.matches("[0-9]+")){
			return true;
		}else
			return false;
	}
	
	public static boolean esNumerico(String seleccion, int minimo){
		if (seleccion.matches("[0-9]{"+minimo+",}")){
			return true;
		}else
			return false;
	}
	
	public static boolean esNumerico(String seleccion, int minimo, int maximo){
		if (seleccion.matches("[0-9]{"+minimo+","+maximo+"}")){
			return true;
		}else
			return false;
	}
	
	
	public static boolean esNombreExigido(String seleccion){
		if (seleccion.matches("[A-Za-zñÑ]{3,}")){
			return true;
		}else
			return false;
	}
	
	public static boolean esNombre(String seleccion){
		if (seleccion.matches("[A-Za-zñÑ]*")){
			return true;
		}else
			return false;
	}

	public static boolean esNombre2(String seleccion){
		if (seleccion.matches("[A-Za-zñÑ\\' ]*")){
			return true;
		}else
			return false;
	}
	
	public static boolean esAlfabetico(String seleccion){
		if (seleccion.matches("[A-Z a-zñÑ]+")){
			return true;
		}else
			return false;
	}
	
	public static boolean esCedulaValida(String seleccion){
		if (seleccion.matches("[VvEePp]?-[0-9]{5,9}")){
			return true;
		}else
			return false;
	}	
	
	public static boolean esRIFValido(String seleccion){
		if (seleccion.matches("[JjGgVveE]?-[0-9]{5,9}")){
			return true;
		}else
			return false;
	}
	
	
	public static boolean esEmailValido(String seleccion){
		if( seleccion.length()>0){
			if (seleccion.matches("\\w\\S*@\\w+.w*")){
				return true;
			}else
				return false;
		}else
			return true;
	}
	
	public static boolean esEmailValidoExigido(String seleccion){
		if (seleccion.matches("\\w\\S*@\\w+\\.w*")){
			return true;
		}else
			return false;
	}
	
	public static boolean esCorreoValido(String seleccion){
		if( seleccion.length()>0){
			if (seleccion.matches("[a-zA-Z]+[0-9\\._a-zA-Z-]*@[a-zA-Z0-9]+\\.[a-zA-Z\\.]+")){
				return true;
			}else
				return false;
		}else
			return true;
	}
	
	
	
	
}
