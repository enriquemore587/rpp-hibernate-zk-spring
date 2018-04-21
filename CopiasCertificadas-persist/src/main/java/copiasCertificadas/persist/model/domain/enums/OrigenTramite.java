package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum OrigenTramite {

	_ELECTRONICO(1,"ELECTRONICO"),
	_FISICO(2,"FISICO");
	
	
	private final Integer id;
	private final String descripcion;
	
	private OrigenTramite(final Integer id,final String descripcion){
		this.id=id;
		this.descripcion=descripcion;		
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(OrigenTramite c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(OrigenTramite c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(OrigenTramite._ELECTRONICO.getDescripcion()); 
	}
}
