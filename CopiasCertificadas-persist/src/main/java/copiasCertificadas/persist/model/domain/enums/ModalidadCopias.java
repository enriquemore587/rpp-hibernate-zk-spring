package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum ModalidadCopias {
	/**TIPOS de MODALIDAD*/
	
	EXPED_COPIA_SIMPLE_INSTRUMENTO_NOTARIAL(4, "EXPED. DE COPIA SIMPLE DE INSTRUMENTO NOTARIAL"),
	EXPED_COPIA_CERTIFICADA_INSTRUMENTO_NOTARIAL(3, "EXPED. DE COPIA CERTIFICADA DE INSTRUMENTO NOTARIAL"),
	EXPED_TESTIMONIO_EFECTOS_INSCRIPCION_INSTRUMENTO_NOTARIAL(2, "EXPED. DE TESTIMONIO PARA EFECTOS DE INSCRIPCION DE INSTRUMENTO NOTARIAL"),
	EXPED_TESTIMONIO_ORDEN_INSTRUMENTO_NOTARIAL(1, "EXPED. DE TESTIMONIO EN SU ORDEN DE INSTRUMENTO NOTARIAL");
	
	private final String descripcion;
	private final int numero;
	
	private ModalidadCopias(final int numero,final String descripcion) {
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
	
	
	public static List<String> getAllModalidades(){
		List<String> l=new ArrayList<String>();
		for(ModalidadCopias c:values()){
			l.add(c.descripcion);
		}
		return l;
	}
	
	
	public static int logValue(String val) {
		int valor=0;
		for(ModalidadCopias c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.numero;					
				}
		}		
		return valor;	
	}


	
  public static void main(String[] args) {	
	  System.out.println(ModalidadCopias.logValue("EXPED. DE COPIA SIMPLE DE INSTRUMENTO NOTARIAL"));	  
  }
	
}
