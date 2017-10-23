package cva.pc.demeter.utilidades;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
	
		
public class Hora implements Serializable{
		    

    /**
	 * 
	 */
	private static final long 	serialVersionUID = 3097346954549212468L;
	public static final boolean	AM = true;
	public static final boolean	PM = false;
	public static final boolean	HORADIA = false;
	public static final boolean	HORA = true;
	protected boolean 			horaExacta;	    
    private Calendar			hora;

    public Hora() {
    	//hora = new GregorianCalendar(obtenerZonaHoraria(),obtenerLocalizacion());
    	//hora = Calendar.getInstance();
    	hora = new GregorianCalendar(obtenerZonaHoraria());
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
    	this.hora.set(Calendar.SECOND, 0);
   		this.hora.set(Calendar.HOUR_OF_DAY, 0);
   		this.hora.set(Calendar.MINUTE, 0);
   		this.hora.set(Calendar.MILLISECOND, 0);
    }
    
    public Hora(boolean tipo, int hora, int minuto) {
    	this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	//this.hora = Calendar.getInstance();
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
    	this.hora.set(Calendar.SECOND, 0);
    	this.hora.set(Calendar.MILLISECOND, 0);
    	if (tipo)
    		this.hora.set(Calendar.HOUR, hora);
    	else
    		this.hora.set(Calendar.HOUR_OF_DAY, hora);
    	this.hora.set(Calendar.MINUTE, minuto);
    }	
    
    
    public Hora(int hor, int minuto, boolean AM) {
    	int horaSola =hor;
    	if (!AM && hor!=12){
    		horaSola +=12;
    	}else if (AM && hor==12){
    		horaSola =0;
		}
    	this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	//this.hora = Calendar.getInstance();
    	this.hora.set(Calendar.MILLISECOND, 0);
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.SECOND, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
    	this.hora.set(Calendar.HOUR_OF_DAY, horaSola);
    	this.hora.set(Calendar.MINUTE, minuto);
    }
    
    public Hora(double hora) {
		int hor, minuto;
		Double lahora = new Double(hora);
		hor = lahora.intValue();
		double elmin =  (hora -hor)*100.00;
		BigDecimal bd = new BigDecimal(Double.toString(elmin));
	    bd = bd.setScale(0,BigDecimal.ROUND_HALF_UP);
		minuto = bd.intValue();
    	int horaSola =hor;
    	this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	this.hora.set(Calendar.MILLISECOND, 0);
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.SECOND, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
    	this.hora.set(Calendar.HOUR, horaSola);
    	this.hora.set(Calendar.MINUTE, minuto);
    }
    
    public Hora(String tiempo) {
    	int longitud = tiempo.length();
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
    
    public Hora(Date fecha) {
    	this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	hora.setTime(fecha);
    }
    
    @SuppressWarnings("deprecation")
    public Hora(Time tiempo) {
    	this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	this.hora.set(Calendar.MILLISECOND, 0);
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
    	this.hora.set(Calendar.SECOND, 0);
       	this.hora.set(Calendar.HOUR_OF_DAY, tiempo.getHours());
    	this.hora.set(Calendar.MINUTE, tiempo.getMinutes());
    }

    @SuppressWarnings("deprecation")
	public Hora(Date fecha, Time tiempo) {
    	hora = new GregorianCalendar(obtenerZonaHoraria());
    	hora.set(fecha.getYear()+1900, fecha.getMonth(), fecha.getDate(), tiempo.getHours(), tiempo.getMinutes());
    }
    
    public Hora(int hora, int minuto, int segundo) {
    	this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	//this.hora = Calendar.getInstance();
    	this.hora.set(Calendar.MILLISECOND, 0);
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
       	this.hora.set(Calendar.HOUR, hora);
    	this.hora.set(Calendar.MINUTE, minuto);
    	this.hora.set(Calendar.SECOND, segundo);
    }	   
    
    public Hora(Hora otra) {
	    if(otra!=null) {
	        this.hora = otra.getvalor();
	    }
    }
    
    
    public Hora(long milisegundos) {
    	hora = new GregorianCalendar(obtenerZonaHoraria());
    	//this.hora = Calendar.getInstance();
    	int hora  = (int)(milisegundos / 3600);
    	int minuto = (int)((milisegundos % 3600) /60); 
    	int segundo = (int)(milisegundos-(hora*3600+minuto*60));
    	//hora.setTimeInMillis(milisegundos);
    	this.hora.set(Calendar.MILLISECOND, 0);
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
       	this.hora.set(Calendar.HOUR, hora);
    	this.hora.set(Calendar.MINUTE, minuto);
    	this.hora.set(Calendar.SECOND, segundo);
    }

    public long getSegundos(){
    	long lTiempo = 0;
    	lTiempo += hora.get(Calendar.SECOND);
    	lTiempo += hora.get(Calendar.MINUTE)*60;
    	if (hora.get(Calendar.DAY_OF_YEAR)!=365){
    		lTiempo += hora.get(Calendar.HOUR_OF_DAY)*3600;
    		lTiempo += (hora.get(Calendar.DAY_OF_YEAR))*24*3600;
    	}else
    		lTiempo += hora.get(Calendar.HOUR)*3600;
    	//System.out.println(lTiempo);
    	return lTiempo;
    }
    
      
    public void fijarHora(boolean tipo, int hora, int minuto) {
    	//this.hora = new GregorianCalendar(obtenerZonaHoraria());
    	this.hora = Calendar.getInstance();
    	this.hora.set(Calendar.MILLISECOND, 0);
    	this.hora.set(Calendar.YEAR, 0);
    	this.hora.set(Calendar.MONTH, 0);
    	this.hora.set(Calendar.DAY_OF_MONTH, 0);
    	if (tipo)
    		this.hora.set(Calendar.HOUR, hora);
    	else
    		this.hora.set(Calendar.HOUR_OF_DAY, hora);
    	this.hora.set(Calendar.MINUTE, minuto);
    }	
    
    public void fijarHora(boolean tipo, int hora, int minuto, int seg) {
    	fijarHora(tipo, hora, minuto);
    	this.hora.set(Calendar.SECOND, seg);
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
   
    
    
    public String obtenerHora24() {
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return sdf.format(this.hora.getTime());
    }
    
    public String obtenerSoloHora24() {
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
        return sdf.format(this.hora.getTime());
    }
    
    public String obtenerSoloHora12() {
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm a");
        return sdf.format(this.hora.getTime());
    }
    
    public static String obtenerHora24(Date fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return sdf.format(fecha);
    }    
    
    public static String obtenerHora24(Time fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return sdf.format(fecha);
    }
    
    public String obtenerHora12() {
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
        return sdf.format(this.hora.getTime());
    }
    
    public static String obtenerHora12(Date fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
        return sdf.format(fecha);
    }
    
    public static String obtenerHora12(Time fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
        return sdf.format(fecha);
    }
    public String obtenerFormatoSQL() {
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return sdf.format(this.hora.getTime());
    }
    
    public String obtenerTiraSQL() {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return sdf.format(this.hora.getTime());
    }
    
    public static  double suma(double dhora1, double dhora2){
    	Hora hora1 = new Hora(dhora1);
    	Hora hora2 = new Hora(dhora2);
    	Long lhora1 = hora1.getvalor().getTimeInMillis();
    	Long lhora2 = hora2.getvalor().getTimeInMillis();
    	Hora salida = new Hora();
    	salida.setMilisegundos(lhora1+lhora2);
    	return salida.getHoraMinutos();
    }
    
    public static  double suma(Hora dhora1, Hora dhora2){
    	Long lhora1 = dhora1.getvalor().getTimeInMillis();
    	Long lhora2 = dhora2.getvalor().getTimeInMillis();
    	Hora salida = new Hora();
    	salida.setMilisegundos(lhora1+lhora2);
    	return salida.getHoraMinutos();
    }

    public static Hora restar(Hora hora1, Hora hora2){
    	long lhora1 = hora1.getSegundos();
    	long lhora2 = hora2.getSegundos();
    	
    	lhora1 -= lhora2;
       	Hora salida = new Hora(lhora1);
       	return salida;
    }
      

    public static Hora sumar(Hora hora1, Hora hora2){
       	Long lhora1 = hora1.getSegundos();
    	Long lhora2 = hora2.getSegundos();
    	
    	Hora salida = new Hora(lhora1+lhora2);
    	return salida;
    }

    
    public int get(int queQuieres) {
      return hora.get(queQuieres);
    }	    
    
    public String toString8() {	      
      java.text.DateFormat sdf = new java.text.SimpleDateFormat("hhmmssa");
      return sdf.format(this.hora);
    }	    
   
    public String toString4() {	      
      java.text.DateFormat sdf = new java.text.SimpleDateFormat("HHmm");
      return sdf.format(this.hora);
    }    
   
    public String toString6() {	      
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("hhmma");
        return sdf.format(this.hora);
    }    
   
    public String obtenerTiempoLargo() {
    	StringBuilder mensaje = new StringBuilder();
    	int dias = hora.get(Calendar.DAY_OF_YEAR);
    	if (dias>0){
    		mensaje.append(dias);
    		mensaje.append(" ");
    	}
    	mensaje.append(hora.get(Calendar.HOUR_OF_DAY));
    	mensaje.append(":");
    	mensaje.append(hora.get(Calendar.MINUTE));
    	mensaje.append(":");
    	mensaje.append(hora.get(Calendar.SECOND));
        return mensaje.toString();
    }
    
    public String toStringN() {
    	StringBuilder mensaje = new StringBuilder();
    	int dias = hora.get(Calendar.DAY_OF_YEAR);
    	if (dias == 365) 
    		dias = 0;
    	mensaje.append((hora.get(Calendar.HOUR_OF_DAY))+24*dias);
    	mensaje.append(":");
    	mensaje.append(hora.get(Calendar.MINUTE));
    	mensaje.append(":");
    	mensaje.append(hora.get(Calendar.SECOND));
        return mensaje.toString();
    }
    
    public boolean esFechaExacta() {
      return this.horaExacta;
    }
    
   
    public void setFechaExacta(boolean fechaExacta){
      this.horaExacta = fechaExacta;
    }
    
    
    public Calendar getvalor() {
        return this.hora;
      }
    
    @SuppressWarnings("deprecation")
	public int getHora() {
      return this.hora.getTime().getHours();
    }
    
    
    @SuppressWarnings("deprecation")
	public int getMinutos() {
      return this.hora.getTime().getMinutes();
    }
    
    @SuppressWarnings("deprecation")
	public double getHoraMinutos() {
    	double hora = this.hora.getTime().getHours()*1.00;
    	double minutos = (this.hora.getTime().getMinutes()*1.00/100.00) +hora;
    	return minutos;
    }
    
    
    public void setTime(Time fecha) {
    	this.hora.setTime(fecha);
    }
    
   
    public boolean after(GregorianCalendar gc) {
    	return hora.after(gc);
    }
    
   
    public boolean before(GregorianCalendar gc) {
    	return hora.before(gc);
    }
    
    public boolean isPosEqual(Hora otra) {
        if(this.horaExacta)
            if(otra.horaExacta)
                return ((this.get(Calendar.HOUR_OF_DAY)==otra.get(Calendar.HOUR_OF_DAY)) &&
                        (this.get(Calendar.MINUTE)==otra.get(Calendar.MINUTE)) &&
                        (this.get(Calendar.SECOND)==otra.get(Calendar.SECOND)));
            else
                return (Math.abs(this.get(Calendar.HOUR_OF_DAY)-otra.get(Calendar.HOUR_OF_DAY))<2);
        else
            return (Math.abs(this.get(Calendar.HOUR_OF_DAY)-otra.get(Calendar.HOUR_OF_DAY))<2);
    }
    
    public String toString(){
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss z");
        return sdf.format(this.hora.getTime());
    }
    
    public void setMilisegundos(long  horamlsg) {
    	hora.setTimeInMillis(horamlsg);
    	hora.setTimeZone(TimeZone.getDefault());
    } 

    private  TimeZone obtenerZonaHoraria(){
    	//TimeZone zonaHoraria = TimeZone.getTimeZone("GMT+00:00");
    	//TimeZone zonaHoraria = TimeZone.getTimeZone("America/Caracas");
    	TimeZone zonaHoraria = TimeZone.getDefault();
    	return zonaHoraria;
    }

/*    private Locale obtenerLocalizacion(){
    	Locale la = new Locale("es","VE");
    	return la;
    }*/
    
}