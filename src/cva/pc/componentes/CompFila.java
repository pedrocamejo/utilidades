package cva.pc.componentes;

import cva.pc.demeter.excepciones.ExcPosicionNoValida;

public class CompFila {
	private String valor[];
	private int ultimo=0;  
	private int tamano;
		
	
	public CompFila(int tamano) {
		super();
		this.valor = new String[tamano];
		this.tamano = tamano;
		ultimo = 0;
		for (int i=0;i<tamano;i++)
			valor[i]="a";
	}
	
	public CompFila(String valor[]) {
		super();
		this.valor = valor;
		this.tamano = valor.length;
		ultimo = this.tamano;
	}

	public String[] getValor() {
		return valor;
	}

	public void setValor(String[] valor) {
		this.valor = valor;
	}
	
	public String getvalorDetalle(int indice){
		return valor[indice];
	}
	
	public void agregarColumna(String valorCol) throws ExcPosicionNoValida, IndexOutOfBoundsException{
		if (ultimo <tamano){
			try{
				valor[ultimo++] = valorCol;
			}catch (IndexOutOfBoundsException e){
				throw e;
			}
			
		}else
			throw new ExcPosicionNoValida();
	}

	public int getTamano() {
		return tamano;
	}
	
	
}
