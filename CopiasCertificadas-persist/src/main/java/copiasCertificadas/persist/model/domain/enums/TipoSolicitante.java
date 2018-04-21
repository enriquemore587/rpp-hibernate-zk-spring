package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoSolicitante {
	

	_NOTARIO(1,"NOTARIO"),
	_GESTOR(2,"GESTOR"),
	_PARTICULAR(3,"PARTICULAR"),
	_PERSONA_MORAL(4,"PERSONA MORAL"),
	_REPRESENTANTE_LEGAL(5,"REPRESENTANTE LEGAL"),
	_AUTORIDAD(6,"AUTORIDAD");
	
	
	private final Integer id;
	private final String descripcion;
	
	private TipoSolicitante(final Integer id,final String descripcion){
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
		for(TipoSolicitante c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(TipoSolicitante c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static String obtenerSting(int val) {
		String valor = "";
		for(TipoSolicitante c:values()){
			if (c.id.equals(val)) {
				valor=c.descripcion;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(TipoSolicitante._NOTARIO.getDescripcion()); 
	}

}
