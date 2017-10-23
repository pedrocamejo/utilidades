package cva.pc.demeter.utilidades;

import java.math.BigDecimal;

public class Real {
	private double valor;

	public Real() {
		super();
		this.valor = 0;
	}
	
	public Real(double valor) {
		super();
		this.valor = round(valor, 2);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = round(valor, 2);
	}
	
	public double round(double d, int decimalPlace){
		BigDecimal bd = new BigDecimal(Double.toString(d));
		bd = bd.setScale(decimalPlace,BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	public static double redondeoMoneda(double d){
		BigDecimal bd = new BigDecimal(Double.toString(d));
		bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
	
}
