package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum TiposDeNota {

	REVOCACION(1,"REVOCACION",""),
	RENUNCIA(2,"RENUNCIA",""),
	INSCRIPCION(3,"INSCRIPCION",""),
	NULIDAD(4,"NULIDAD",""),
	CORRECCION(5,"CORRECCION",""),
	ERROR_DE_TRANSCRIPCION(6,"ERROR DE TRANSCRIPCION EN EL TESTIMONIO",""),
	CONSTANCIAS_AL_APENDICE(7,"AGREGAR CONSTANCIAS AL APENDICE",""),
	ENTREGA_DE_PRIMER_TESTIMONIO(8,"ENTREGA DE PRIMER TESTIMONIO","");
	
	private final int id;
	private String tipo;
	private final String descripcion;
	
	private TiposDeNota(final int id,final String tipo,final String descripcion){
		this.id=id;
		this.tipo=tipo;
		this.descripcion=descripcion;		
	}
	

	
	public int getId() {
		return id;
	}	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(TiposDeNota c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(TiposDeNota c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(TiposDeNota.CORRECCION.getDescripcion()); 
	}
	
	
	
}
