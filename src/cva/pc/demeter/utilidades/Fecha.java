package cva.pc.demeter.utilidades;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
	
		
public class Fecha extends Calendar implements Serializable{
		    
    static final long serialVersionUID = - 4332653121171162L;
    protected boolean fechaExacta;	    
    
    
    
    public Fecha() {
    }
    
    public Fecha(int ano, int mes, int dia) {
      //GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia); 
      this.set(ano,mes,dia);
    }	
    
    public Fecha(String fecha) {
    	int ano, mes, dia;
    	dia = Integer.parseInt(fecha.substring(0,2));
    	mes = Integer.parseInt(fecha.substring(3,5));
    	ano = Integer.parseInt(fecha.substring(6,10));   
    	GregorianCalendar gcAux = new GregorianCalendar(ano,mes-1,dia); 
        this.setTime(gcAux.getTime());
        //System.out.println("Fecha Seteada :" +fecha);
       
    }	
    
	public Fecha(Date fecha) {
	    this.setTime(fecha);
	}
	
	public Fecha(Calendar fecha) {
	    this.setTime(fecha.getTime());
	    
	}
      
  
	public Fecha(int ano, int mes, int dia, int hora, int minuto) {
		GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia,hora,minuto,0);
		setTime(gcAux.getTime());
	}	
	  
	public Fecha(Fecha otra) {
		if(otra!=null) {
			setTime(otra.getTime());
			this.fechaExacta = otra.fechaExacta;
		}
	}

    
    @SuppressWarnings("deprecation")
    public void agregarDias(int dias){
    	Date fecha = new Date();
    	int dia = fecha.getDate()+dias;
    	int mes = fecha.getMonth();
    	int ano = fecha.getYear()+1900;
    	//System.out.println(dia+"/"+mes+"/"+ano);
    	GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia); 
    	this.setTime(gcAux.getTime());
    }
    
    @SuppressWarnings("deprecation")
    public void agregarMeses(int meses){
    	Date fecha = new Date();
    	int dia = fecha.getDate();
    	int mes = fecha.getMonth()+meses;
    	int ano = fecha.getYear()+1900;
    	GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia); 
    	this.setTime(gcAux.getTime());
    }
    
    @SuppressWarnings("deprecation")
	public void agregarAnos(int anos){
    	Date fecha = new Date();
    	int dia = fecha.getDate();
    	int mes = fecha.getMonth();
    	int ano = fecha.getYear()+1900+anos;
    	GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia); 
    	this.setTime(gcAux.getTime());
    }
    
    @SuppressWarnings("deprecation")
    public void quitarMeses(int meses){
    	Date fecha = new Date();
    	int dia = fecha.getDate();
    	int mes = fecha.getMonth()-meses;
    	int ano = fecha.getYear()+1900;
    	GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia); 
        this.setTime(gcAux.getTime());
    }
    
    @SuppressWarnings("deprecation")
	public void quitarAnos(int anos){
    	Date fecha = new Date();
    	int dia = fecha.getDate();
    	int mes = fecha.getMonth();
    	int ano = fecha.getYear()+1900-anos;
    	GregorianCalendar gcAux = new GregorianCalendar(ano,mes,dia); 
        this.setTime(gcAux.getTime());
    }
    
       
    public String obtenerFechaHoy() {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.getFecha());
    }
    
    public static String obtenerFecha(Date fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }  
    
    public static String obtenerFechaAnoMesDia(Date fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(fecha);
    }  
    
    
    
    
    public static String obtenerFechaSQL(Date fecha) {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fecha);
    }  
    
    public String obtenerFormatoSQL() {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(this.getFecha());
    }
    
    public String obtenerTiraSQL() {
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(this.getFecha());
    }
    
    public static String obtenerMesEnLetra(Date fecha) {
    	String mes = new String();
    	switch (Integer.parseInt(obtenerFecha(fecha).substring(3, 5))){
    	case 1 : 
    		mes = "Enero";
    		break;
    	case 2 : 
    		mes = "Febrero";
    		break;
    	case 3 : 
    		mes = "Marzo";
    		break;
    	case 4 : 
    		mes = "Abril";
    		break;
    	case 5 : 
    		mes = "Mayo";
    		break;
    	case 6 : 
    		mes = "Junio";
    		break;
    	case 7 : 
    		mes = "Julio";
    		break;
    	case 8 : 
    		mes = "Agosto";
    		break;
    	case 9 : 
    		mes = "Septiembre";
    		break;
    	case 10 : 
    		mes = "Octubre";
    		break;
    	case 11 : 
    		mes = "Noviembre";
    		break;
    	case 12 : 
    		mes = "Diciembre";
    		break;
    	}
    	return mes;
    }
    
   
    public int get(int queQuieres) {
      GregorianCalendar gcAux = new GregorianCalendar();
      gcAux.setTime(this.getTime());
      return gcAux.get(queQuieres);
    }	    
    
    public String toString8() {	      
      java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
      return sdf.format(this.getFecha());
    }	    
   
    public String toString12() {	      
      java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddhhmm");
      return sdf.format(this.getFecha());
    }    
   
   
    public boolean esFechaExacta() {
      return this.fechaExacta;
    }
    
   
    public void setFechaExacta(boolean fechaExacta) {
      this.fechaExacta = fechaExacta;
    }
    
    public boolean after(GregorianCalendar gc) {
      GregorianCalendar gcAux = new GregorianCalendar();
      gcAux.setTime(this.getTime());
      return gcAux.after(gc);
    }
    
   
    public boolean before(GregorianCalendar gc) {
      GregorianCalendar gcAux = new GregorianCalendar();
      gcAux.setTime(this.getTime());
      return gcAux.before(gc);
    }
    
    
    public boolean after(Fecha otraFecha) {
      GregorianCalendar gcAux = new GregorianCalendar();
      gcAux.setTime(otraFecha.getTime());
      return after(gcAux);
    }
   
    public boolean before(Fecha otraFecha) {
      GregorianCalendar gcAux = new GregorianCalendar();
      gcAux.setTime(otraFecha.getTime());
      return before(gcAux);
    }
   
    public boolean isPosEqual(Fecha otra) {
        if(this.fechaExacta)
            if(otra.fechaExacta)
                return ((this.get(Calendar.DAY_OF_MONTH)==otra.get(Calendar.DAY_OF_MONTH)) &&
                        (this.get(Calendar.MONTH)==otra.get(Calendar.MONTH)) &&
                        (this.get(Calendar.YEAR)==otra.get(Calendar.YEAR)));
            else
                return (Math.abs(this.get(Calendar.YEAR)-otra.get(Calendar.YEAR))<2);
        else
            return (Math.abs(this.get(Calendar.YEAR)-otra.get(Calendar.YEAR))<2);
    }
    
    public Date getFecha() {		
		return (Date) this.getTime();		
	}

	public void setFecha(Date fecha) {
		this.setTime(fecha);
	}
    
    public String toString(){
    	java.text.DateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
	    return sdf.format(this.getFecha());
    }
    

	@Override
	public void add(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGreatestMinimum(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeastMaximum(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximum(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimum(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void roll(int arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}   
}