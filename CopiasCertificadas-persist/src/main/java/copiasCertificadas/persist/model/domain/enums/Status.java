package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum Status {

	
	_PORPRESENTAR(1,"POR PRESENTAR","EL TRAMITE HA SIDO PRECAPTURADO"),
	_PRESENTADO(2,"PRESENTADO","EL TRAMITE YA ESTA PRESENTADO EN LA GESTION"),
	_ENTRAMITE(3,"EN TRAMITE","EL TRAMITE ESTA SIENDO TRABAJADO Y/O EVALUADO"),
	_LISTOPARAENTREGA(4,"LISTO PARA ENTREGA","EL TRAMITE ESTA EN VENTANILLA LISTO PARA ENTREGAR"),
	_ENTREGADO(5,"ENTREGADO","EL TRAMITE YA FUE ENTREGADO Y CONCLUIDO"),
	_COMPLETADO(6,"COMPLETADO", "EL AVISO HA SIDO COMPLETADO");
	
	private final int id;
	private String tipo;
	private final String descripcion;
	
	private Status(final int id,final String tipo,final String descripcion){
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


	public static List<String> obtenerTodosTipo(){
		List<String> l=new ArrayList<String>();
		for(Status c:values()){
			l.add(c.tipo);
		}
		return l;
	}
	
	public static List<String> obtenerTodosDescripcion(){
		List<String> l=new ArrayList<String>();
		for(Status c:values()){
			l.add(c.descripcion);
		}
		return l;
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(Status c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}

}
