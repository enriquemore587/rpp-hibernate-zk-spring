package org.CopiasCertificadas.view.enums;

import org.zkoss.zul.ListModelList;

public enum TiposAvisos {
	TiposAvisos1(1, "PERSONALES"),
	TiposAvisos2(2, "CIERRE Y APERTURA DE DECENA");
	
	private final String descripcion;
	private final int numero;
	static boolean bol=false;
	
	private TiposAvisos(final int numero,final String descripcion) {
		this.descripcion = descripcion;
		this.numero = numero;
	}
	
	public String toString(){
		return descripcion;
	}
	
	public int getNumero(){		
		return numero;
	}
	
	public Integer[] todos(){
		return new Integer[]{1,3,5};
	}
	
	
	public static ListModelList<String> getAllModalidades(){
		ListModelList<String> l=new ListModelList<String>();
		for(TiposAvisos c:values()){
			l.add(c.descripcion);
		}
		return l;
	}
	
	
	public static int logValue(String val) {
		int valor=0;
		for(TiposAvisos c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.numero;					
				}
		}		
		return valor;	
	}


	
  public static void main(String[] args) {	
	  System.out.println(TiposAvisos.logValue("PERSONALES"));	  
  }
}
