package cva.pc.demeter.utilidades;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
	
		
public class Tiempo implements Serializable{
		    

    /**
	 * 
	 */
	private static final long 	serialVersionUID = 3097346954549212468L;
	public static final boolean	AM = true;
	public static final boolean	PM = false;
	public static final boolean	HORADIA = false;
	public static final boolean	HORA = true;
	
	public static final int[]	DIARIO12H = {12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12};
	public static final int[]	DIARIO24H = {24,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
	public static final boolean[]	AMPM = {AM,AM,AM,AM,AM,AM,AM,AM,AM,AM,AM,AM,PM,PM,PM,PM,PM,PM,PM,PM,PM,PM,PM,PM,AM};
	
	private boolean horaDiaria;	
    private int		hora;
    private int		minuto;
    private int		segundo;
    
    
    
    
    
    public Tiempo() {
    	hora = 0;
    	minuto = 0;
    	segundo = 0;
    	this.horaDiaria = HORA;
    }
    
    public Tiempo(boolean horaDiaria, int hora, int minuto) {
    	this.horaDiaria = horaDiaria;
    	if (horaDiaria==HORADIA)
    		this.hora = buscarHora24(hora);
    	else
    		this.hora = hora;
    	this.minuto = minuto;
    	segundo = 0;
    }	
    
    
    public Tiempo(int hor, int minuto, boolean AmPm) {
    	this.hora = buscarHora12(AmPm, hor);
    	this.minuto = minuto;
    	segundo = 0;
    	this.horaDiaria = HORADIA;
    }
    
    public Tiempo(long milisegundos) {
    	this.horaDiaria = HORA;
    	hora  = (int)(milisegundos / 3600);
    	minuto = (int)((milisegundos % 3600) /60); 
    	segundo = (int)(milisegundos-(hora*3600+minuto*60));
    }
    
    public Tiempo(double hora) {
		int hor;
		Double lahora = new Double(hora);
		hor = lahora.intValue();
		double elmin =  (hora -hor)*100.00;
		BigDecimal bd = new BigDecimal(Double.toString(elmin));
	    bd = bd.setScale(0,BigDecimal.ROUND_HALF_UP);
		this.minuto = bd.intValue();
    	this.hora =hor;
    	this.horaDiaria = HORA;
    }
    
    public Tiempo(String tiempo) {
    	int longitud = tiempo.length();
    	this.horaDiaria = HORADIA;
    	switch (longitud) {
			case 5:
				horaString5(tiempo);
				break;
			case 8:
				horaString8(tiempo);
				break;
			case 11:
				horaString11(tiempo);
				break;
			default:
				horaString11(tiempo);
				break;
		} 
    	
    }	
    
    @SuppressWarnings("deprecation")
    public Tiempo(Time tiempo) {
    	this.horaDiaria = HORADIA;
    	this.hora = tiempo.getHours();
    	this.minuto = tiempo.getMinutes();
    	this.segundo = tiempo.getSeconds();
    }

      
    public Tiempo(int hora, int minuto, int segundo) {
      	this.hora = hora;
    	this.minuto = minuto;
    	this.segundo = segundo;
    	this.horaDiaria = HORA;
  
    }	   
    
    public Tiempo(Tiempo otra) {
	    if(otra!=null) {
	        this.hora = otra.getHora();
	        this.minuto = otra.getMinuto();
	    	this.segundo = otra.getSegundo();
	    	this.horaDiaria = otra.isHoraDiaria();
	    }
    }
    
    private int buscarHora12(boolean tipo, int valor){
    	int i ;
    	if (valor>12) valor %= 12;
    	for (i=0; i<DIARIO12H.length;i++){
    		if (tipo == AMPM[i] && valor == DIARIO12H[i])
    			return i;
    	}
    	return 0;	
    }
    
    private int buscarHora24(int valor){
    	int i ;
    	if (valor>12) valor /= 12;
    	for (i=0; i<DIARIO24H.length;i++){
    		if (valor == DIARIO24H[i])
    			return i;
    	}
    	return 0;	
    }
    
    public long getSegundos(){
    	long lTiempo = 0;
    	lTiempo += hora*3600;
    	lTiempo += minuto*60;
    	lTiempo += segundo;
    	return lTiempo;
    }
    
      
    public void fijarHora(boolean tipo, int hora, int minuto) {
    	//this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	this.horaDiaria = tipo;
    	this.hora = buscarHora24(hora);
    	this.minuto = minuto;
    	segundo = 0;
    }	
    
    public void fijarHora(boolean tipo, int hora, int minuto, int seg) {
    	fijarHora(tipo, hora, minuto);
    	this.segundo = seg;
    }
    
    private void horaString5(String tiempo){
    	int hor, minuto;
    	minuto = Integer.parseInt(tiempo.substring(3));
    	hor = Integer.parseInt(tiempo.substring(0,2));   
    	fijarHora(HORADIA,hor, minuto);
    }
    
    private void horaString8(String tiempo){
    	String segOam;
    	int hor, minuto;
    	minuto = Integer.parseInt(tiempo.substring(3,5));
    	hor = Integer.parseInt(tiempo.substring(0,2));   
    	segOam = tiempo.substring(6,8);
    	if (segOam.indexOf('M')>0){
    		if (segOam.equalsIgnoreCase("PM") && hor !=12){
    			hor +=12;
    		}else if (segOam.equalsIgnoreCase("AM") && hor ==12){
    			hor =0;
    		}
    		//this.hora = new GregorianCalendar(0,0,0,hor, minuto);
    		fijarHora(HORADIA, hor, minuto);
    	}else
    		fijarHora(HORADIA, hor, minuto, Integer.parseInt(segOam));
    		

    }
    
    private void horaString11(String tiempo){
      	String segOam;
    	int hor, minuto,segundo;
    	segundo = Integer.parseInt(tiempo.substring(6,8));
    	minuto = Integer.parseInt(tiempo.substring(3,5));
    	hor = Integer.parseInt(tiempo.substring(0,2));
    	segOam = tiempo.substring(9,11);
   		if (segOam.equalsIgnoreCase("PM") && hor !=12){
   			hor +=12;
   		}else if (segOam.equalsIgnoreCase("AM") && hor == 12){
			hor =0;
		}
   		fijarHora(HORADIA, hor, minuto, segundo);
   		//this.hora = new GregorianCalendar(0,0,0,hor, minuto, segundo);
    }
   
    
    public String obtenerHora12() {
    	StringBuilder mensaje = new StringBuilder();
    	if (horaDiaria == HORADIA){
    		int dias = hora/24;
    		int horat = hora%24;
    		if (dias>0){
        		mensaje.append(dias);
        		mensaje.append(" ");
        	}
        	mensaje.append(formatear(DIARIO12H[horat]));
        	mensaje.append(":");
        	mensaje.append(formatear(minuto));
        	mensaje.append(":");
        	mensaje.append(formatear(segundo));
        	mensaje.append(" ");
        	if (AMPM[horat]==AM)
        		mensaje.append("AM");
        	else
        		mensaje.append("PM");
    	}else{
   			mensaje.append(hora);
        	mensaje.append(":");
        	mensaje.append(formatear(minuto));
        	mensaje.append(":");
        	mensaje.append(formatear(segundo));
    	}
        return mensaje.toString();

    }
    
    public String obtenerHora24() {
    	StringBuilder mensaje = new StringBuilder();
    	if (horaDiaria == HORADIA){
    		int dias = hora/24;
    		int horat = hora%24;
    		if (dias>0){
        		mensaje.append(dias);
        		mensaje.append(" ");
        	}
        	mensaje.append(formatear(DIARIO24H[horat]));
        	mensaje.append(":");
        	mensaje.append(formatear(minuto));
        	mensaje.append(":");
        	mensaje.append(formatear(segundo));
    	}else{
   			mensaje.append(hora);
        	mensaje.append(":");
        	mensaje.append(formatear(minuto));
        	mensaje.append(":");
        	mensaje.append(formatear(segundo));
    	}
        return mensaje.toString();

    }
    
    
    public String obtenerFormatoSQL() {
    	StringBuilder mensaje = new StringBuilder();
		mensaje.append(hora);
    	mensaje.append(":");
    	mensaje.append(formatear(minuto));
    	mensaje.append(":");
    	mensaje.append(formatear(segundo));
    	return mensaje.toString();
    }
    
    public String formatear(int valor){
    	StringBuilder salida = new StringBuilder();
    	salida.append(valor);
    	if (salida.length()<2){
    		salida.insert(0, 0);
    	}
    	return salida.toString();
    }
    
    
    public static Tiempo restar(Tiempo hora1, Tiempo hora2){
    	long lhora1 = hora1.getSegundos();
    	long lhora2 = hora2.getSegundos();
    	lhora1 -= lhora2;
       	Tiempo salida = new Tiempo(lhora1);
       	return salida;
    }
    

    public static Tiempo sumar(Tiempo hora1, Tiempo hora2){
       	Long lhora1 = hora1.getSegundos();
    	Long lhora2 = hora2.getSegundos();
    	Tiempo salida = new Tiempo(lhora1+lhora2);
    	return salida;
    }

    
    
    public String toString() {
    	StringBuilder mensaje = new StringBuilder();
		mensaje.append(hora);
    	mensaje.append(":");
    	mensaje.append(formatear(minuto));
    	mensaje.append(":");
    	mensaje.append(formatear(segundo));
    	return mensaje.toString();
    }
    
    
	public double getHoraMinutos() {
    	double hora = this.hora*1.00;
    	double minutos = (this.minuto*1.00/100.00) +hora;
    	return minutos;
    }
    
    
    public boolean mayor(Tiempo gc) {
    	long valor1 =  this.getSegundos();
    	long valor2 =  gc.getSegundos();
    	return (valor1 > valor2);
    }

    
   
    public boolean menor(Tiempo gc) {
    	long valor1 =  this.getSegundos();
    	long valor2 =  gc.getSegundos();
    	return (valor2 > valor1);
    }
    
    public boolean menorIgual(Tiempo gc) {
    	return !mayor(gc);
    }
    
    public boolean mayorIgual(Tiempo gc) {
    	return !menor(gc);
    }
    
    public boolean igual(Tiempo gc) {
    	long valor1 =  this.getSegundos();
    	long valor2 =  gc.getSegundos();
    	return (valor2 == valor1);
    }
   
    

	public boolean isHoraDiaria() {
		return horaDiaria;
	}

	public void setHoraDiaria(boolean horaDiaria) {
		this.horaDiaria = horaDiaria;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getHora() {
		return hora;
	}

/*    private Locale obtenerLocalizacion(){
    	Locale la = new Locale("es","VE");
    	return la;
    }*/
    
}