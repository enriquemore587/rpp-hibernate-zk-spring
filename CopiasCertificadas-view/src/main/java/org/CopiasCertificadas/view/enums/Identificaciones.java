package org.CopiasCertificadas.view.enums;

import org.zkoss.zul.ListModelList;

import com.lowagie.text.pdf.PdfDocument.Indentation;

public enum Identificaciones {
	Identificacion1(1,"IFE / INE"),
	Identificacion2(1,"CARTILLA MILITAR"),
	Identificacion3(1,"PASAPORTE");
	
	private final String descripcion;
	private final int numero;
	static boolean bol = false;
	
	private Identificaciones(final int numero, final String descripcion){
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
	
	public static ListModelList<String> getAllIdentificaciones(){
		ListModelList<String> l=new ListModelList<String>();
		for(Identificaciones c:values()){
			l.add(c.descripcion);
		}
		return l;
	}
	
	public static int logValue(String val) {
		int valor=0;
		for(Identificaciones c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.numero;					
				}
		}		
		return valor;	
	}


	
  public static void main(String[] args) {	
	  System.out.println(Identificaciones.logValue("CARTILLA MILITAR"));
  }
}
