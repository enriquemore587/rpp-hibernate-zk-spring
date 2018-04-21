package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoPersona {
	
	_PERSONAFISICA(1,"PERSONA FISICA"),
	_PERSONAMORAL(2,"PERSONA MORAL");
	
	
	private final Integer id;
	private final String descripcion;
	
	private TipoPersona(final Integer id,final String descripcion){
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
		for(TipoPersona c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(TipoPersona c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(TipoPersona._PERSONAFISICA.getDescripcion()); 
	}

}
