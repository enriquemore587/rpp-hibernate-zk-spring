package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum Operaciones {

	_GUARDO_INFORMACION(1,"GUARDO INFORMACION","Se Guardo Informacion de Tramite DGJYEL"),
	_EDITO_INFORMACION(2,"EDITO INFORMACION","Se Edito Tramite"),
	_ELIMINO_INFORMACION(3,"ELIMINO TRAMITE","Se Elimino Tramite"),	
	_CONSULTO_TRAMITE(4,"CONSULTO TRAMITE","Se Consulto Tramite para visualizarlo");
	
	private final int id;
	private String tipo;
	private final String descripcion;
	
	
	private Operaciones(final int id,final String tipo,final String descripcion){
		this.id=id;
		this.tipo=tipo;
		this.descripcion=descripcion;		
	}
	

	
	public int getId() {
		return id;
	}	
	public String getDescripcion() {
		return descripcion;
	}	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(Operaciones c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(Operaciones c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(Operaciones._GUARDO_INFORMACION.getDescripcion()); 
	}
}
